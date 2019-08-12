package com.epam.rd.spring2019.pet.web.servlets;

import com.epam.rd.spring2019.pet.Utils.UtilsServlet;
import com.epam.rd.spring2019.pet.exceptions.ValidationException;
import com.epam.rd.spring2019.pet.services.UserService;
import com.epam.rd.spring2019.pet.services.UserServiceImpl;
import com.epam.rd.spring2019.pet.web.dtos.ErrorDto;
import com.epam.rd.spring2019.pet.web.dtos.UserCreateDto;
import com.epam.rd.spring2019.pet.web.dtos.UserViewDto;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "registrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserViewDto user = null;

        req.setCharacterEncoding("UTF-8");
        UserCreateDto UserCreateDto = UtilsServlet.extractUserFromRequest(req);
        HttpSession session = req.getSession(true);

        try {
            user = userService.registerUser(UserCreateDto);
            session.setAttribute("user", user);
            resp.sendRedirect("/index");
        } catch (ValidationException|SQLException|NamingException ex) {
            ErrorDto errorDto = new ErrorDto(ex.getMessage(), ex.getClass().getSimpleName());

            if (ex.getClass().getSimpleName().equals("ValidationException")) {
                errorDto.setListError(((ValidationException) ex).getErrList());
            }
            session.setAttribute("error", errorDto);
            resp.sendRedirect("/error");
        }

    }
}
