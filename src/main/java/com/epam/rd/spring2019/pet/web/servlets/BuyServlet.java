package com.epam.rd.spring2019.pet.web.servlets;

import com.epam.rd.spring2019.pet.models.Cart;
import com.epam.rd.spring2019.pet.models.TradeUnit;
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
import java.util.Map;

@WebServlet(name = "BuyServlet", urlPatterns = "/buy")
public class BuyServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String productId = req.getParameter("productId");
        HttpSession session = req.getSession();

        Cart cart = (Cart)session.getAttribute("cart");
        if (cart != null) {
            Map<String,TradeUnit> unitMap = cart.getTradeUnitMap();
            TradeUnit unit = unitMap.get(productId);
            if (unit == null) {
                ProductViewDto productViewDto = productService.getProductById(Long.valueOf(productId));
                unit = new TradeUnit(productViewDto,1,productViewDto.getPrice());
                unitMap.put(productId, unit);
            } else {
                unit.setQuantity(unit.getQuantity() + 1);
            }
            cart.calculateAmount();
        }

        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
