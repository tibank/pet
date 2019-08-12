package com.epam.rd.spring2019.pet.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "LogoutServlet",
        urlPatterns = "/logout"
)
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        request.setAttribute("caller", "/logout");

        HttpSession session=request.getSession(false);
        session.invalidate();

        response.sendRedirect("/index.jsp");
    }
}
