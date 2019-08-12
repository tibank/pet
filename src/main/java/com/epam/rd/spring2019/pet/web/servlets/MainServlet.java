package com.epam.rd.spring2019.pet.web.servlets;

import com.epam.rd.spring2019.pet.models.Cart;
import com.epam.rd.spring2019.pet.models.Category;
import com.epam.rd.spring2019.pet.services.CategoryService;
import com.epam.rd.spring2019.pet.services.CategoryServiceImpl;
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

@WebServlet(name = "MainServlet", urlPatterns = "/index")
public class MainServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        List<Category> categoryList = categoryService.getAllCategories();
        session.setAttribute("categories", categoryList);

        List<ProductViewDto> productViewDtoList = productService.getAllProducts();
        session.setAttribute("products", productViewDtoList);

        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new Cart());
        }

        resp.sendRedirect("/index.jsp");
        //req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
