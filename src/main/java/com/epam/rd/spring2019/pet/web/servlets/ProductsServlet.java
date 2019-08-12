package com.epam.rd.spring2019.pet.web.servlets;


import com.epam.rd.spring2019.pet.services.ProductService;
import com.epam.rd.spring2019.pet.services.ProductServiceImpl;
import com.epam.rd.spring2019.pet.web.dtos.ProductViewDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        List<ProductViewDto> productViewDtoList = productService.getAllProducts();
        session.setAttribute("products", productViewDtoList);

        resp.sendRedirect("/products.jsp");
    }


}
