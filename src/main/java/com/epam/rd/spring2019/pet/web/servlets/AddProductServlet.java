package com.epam.rd.spring2019.pet.web.servlets;


import com.epam.rd.spring2019.pet.Utils.UtilsServlet;
import com.epam.rd.spring2019.pet.services.ProductService;
import com.epam.rd.spring2019.pet.services.ProductServiceImpl;
import com.epam.rd.spring2019.pet.web.dtos.ProductCreateDto;
import com.epam.rd.spring2019.pet.web.dtos.ProductViewDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


@WebServlet(name = "AddProductServlet", urlPatterns = "/addproduct")
public class AddProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ProductCreateDto productCreateDto = extractProductFromRequest(req);
        ProductViewDto productViewDto = productService.addNewProduct(productCreateDto);
        HttpSession session = req.getSession();
        String result = productViewDto != null
                ? productViewDto.getName() + " is added!"
                : "Failed to add new product";

        session.setAttribute("result", result);
        resp.sendRedirect("/products");
    }

    private ProductCreateDto extractProductFromRequest(HttpServletRequest req) {
        Map<String,String> params = UtilsServlet.getRequestParams(req);
        return new ProductCreateDto(params);
    }
}
