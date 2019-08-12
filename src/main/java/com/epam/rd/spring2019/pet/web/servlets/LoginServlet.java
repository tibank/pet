package com.epam.rd.spring2019.pet.web.servlets;

import com.epam.rd.spring2019.pet.exceptions.ValidationException;
import com.epam.rd.spring2019.pet.services.UserService;
import com.epam.rd.spring2019.pet.services.UserServiceImpl;
import com.epam.rd.spring2019.pet.web.dtos.ErrorDto;
import com.epam.rd.spring2019.pet.web.dtos.UserViewDto;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserViewDto user = null;

        HttpSession session = req.getSession(true);
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            user = userService.login(email, password);
            session.setAttribute("user", user);
            resp.sendRedirect("/index");
        } catch (ValidationException|SQLException |NamingException ex) {
            ErrorDto errorDto = new ErrorDto(ex.getMessage(), ex.getClass().getSimpleName());

            if (ex.getClass().getSimpleName().equals("ValidationException")) {
                errorDto.setListError(((ValidationException) ex).getErrList());
            }
            session.setAttribute("error", errorDto);
            resp.sendRedirect("/error");
        }
    }
}
