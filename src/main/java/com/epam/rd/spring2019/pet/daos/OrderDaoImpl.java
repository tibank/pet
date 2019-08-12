package com.epam.rd.spring2019.pet.daos;

import com.epam.rd.spring2019.pet.Utils.UtilsDao;
import com.epam.rd.spring2019.pet.config.DBManager;
import com.epam.rd.spring2019.pet.exceptions.ApplicationException;
import com.epam.rd.spring2019.pet.models.Order;
import com.epam.rd.spring2019.pet.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import java.sql.*;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private final static Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
    private static final String ORDER_INSERT_QUERY =
            "INSERT orders(numberdoc, datedoc, status_id, user_id, total)" +
                    "VALUES (?,curdate(),1,?,?)";

    @Override
    public Order getOrderById(Long id) throws SQLException, NamingException {
        return null;
    }


    @Override
    public Order addOrder(Order order) throws SQLException, NamingException {
        try (Connection conn = DBManager.getDBConnection();
             PreparedStatement st = conn.prepareStatement(ORDER_INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {


            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                order.setId(rs.getLong(1));
            }
        } catch (SQLException ex) {
            log.error("SQL Error add new user " + UtilsDao.getSQLErrorString(ex));
            throw new ApplicationException("Failed to insert new order into DB", ex);
        } catch (NamingException ex) {
            log.error("Failed to connect to DB " + ex);
            throw new ApplicationException("Failed to connect to DB", ex);
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByUser(User user) throws SQLException, NamingException {
        return null;
    }
}
