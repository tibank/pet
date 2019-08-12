package com.epam.rd.spring2019.pet.daos;

import com.epam.rd.spring2019.pet.models.Order;
import com.epam.rd.spring2019.pet.models.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {

    Order getOrderById(Long id) throws SQLException, NamingException;
    Order addOrder(Order order) throws SQLException, NamingException;
    List<Order> getOrdersByUser(User user) throws SQLException, NamingException;
}
