package com.epam.rd.spring2019.pet.web.servlets;


import com.epam.rd.spring2019.pet.Utils.UtilsServlet;
import com.epam.rd.spring2019.pet.models.Cart;
import com.epam.rd.spring2019.pet.services.ProductService;
import com.epam.rd.spring2019.pet.services.ProductServiceImpl;
import com.epam.rd.spring2019.pet.web.dtos.FilterProductDto;
import com.epam.rd.spring2019.pet.web.dtos.ProductViewDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "FilterServlet", urlPatterns = "/filter")
public class FilterServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        FilterProductDto filterProductDto = null;
        filterProductDto = UtilsServlet.extractFilterFromRequest(req);

        List<ProductViewDto> productViewDtoList = productService.getProductsByFilter(filterProductDto);
        session.setAttribute("products", productViewDtoList);

        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new Cart());
        }

        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }


}
