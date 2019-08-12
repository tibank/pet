package com.epam.rd.spring2019.pet.web.servlets;

import com.epam.rd.spring2019.pet.models.Cart;
import com.epam.rd.spring2019.pet.models.TradeUnit;
import com.epam.rd.spring2019.pet.services.ProductService;
import com.epam.rd.spring2019.pet.services.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ChangeOrderServlet", urlPatterns = "/changeorder")
public class ChangeOrderServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String productId = req.getParameter("productId");
        String action = req.getParameter("act");
        HttpSession session = req.getSession();

        Cart cart = (Cart)session.getAttribute("cart");
        if (cart != null) {
            Map<String,TradeUnit> unitMap = cart.getTradeUnitMap();
            TradeUnit unit = unitMap.get(productId);
            if (unit != null) {
                switch (action) {
                    case "1":
                        unit.setQuantity(unit.getQuantity() + 1);
                        break;
                    case "-1":
                        if (unit.getQuantity() > 1) {
                            unit.setQuantity(unit.getQuantity() - 1);
                        } else {
                            unitMap.remove(productId);
                        }
                        break;
                    case "0":
                        unitMap.remove(productId);
                        break;
                }
            }
            cart.calculateAmount();
        }

        req.getRequestDispatcher("cart.jsp").forward(req,resp);
    }
}
