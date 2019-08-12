package com.epam.rd.spring2019.pet.daos;

import com.epam.rd.spring2019.pet.Utils.UtilsDao;
import com.epam.rd.spring2019.pet.config.DBManager;
import com.epam.rd.spring2019.pet.config.PropertiesManager;
import com.epam.rd.spring2019.pet.exceptions.ApplicationException;
import com.epam.rd.spring2019.pet.exceptions.ValidationException;
import com.epam.rd.spring2019.pet.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import java.sql.*;

public class UserDaoImpl implements UserDao {
    private final static Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
    private PropertiesManager propertiesManager = new PropertiesManager();

    private static final String USER_INSERT_QUERY =
            "INSERT users(firstname, lastname, sex, birthDay, email, password, created)" +
                    "VALUES (?,?,?,?,?,?,curdate())";



    @Override
    public User addUser(User user) {

        //try (Connection conn = DBManager.getConnection(propertiesManager.getApplicationProperties());
        try (Connection conn = DBManager.getDBConnection();
             PreparedStatement st = conn.prepareStatement(USER_INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getSex());
            st.setString(4, user.getBirthDay().toString());
            st.setString(5, user.getEmail());
            st.setString(6, user.getPassword());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getLong(1));
            }
        } catch (SQLException ex) {
            log.error("SQL Error add new user " + UtilsDao.getSQLErrorString(ex));
            throw new ApplicationException("Failed to insert new user into DB", ex);
        } catch (NamingException ex) {
            log.error("Failed to connect to DB " + ex);
            throw new ApplicationException("Failed to connect to DB", ex);
        }

        return user;
    }

    private static final String USER_UPDATE_QUERY =
            "UPDATE users SET firstname=?, lastname=?, sex=?, " +
                    " birthDay=?, password=? WHERE email = ?";
    @Override
    public User updateUser(User user) throws SQLException, NamingException {
        try (Connection conn = DBManager.getDBConnection();
             PreparedStatement st = conn.prepareStatement(USER_UPDATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getSex());
            st.setString(4, user.getBirthDay().toString());
            st.setString(5, user.getPassword());
            st.setString(6, user.getEmail());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getLong(1));
            }
        } catch (SQLException ex) {
            log.error("SQL Error add new user " + UtilsDao.getSQLErrorString(ex));
            throw new ApplicationException("Failed to insert new user into DB", ex);
        } catch (NamingException ex) {
            log.error("Failed to connect to DB " + ex);
            throw new ApplicationException("Failed to connect to DB", ex);
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;

        String GET_USER_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = DBManager.getDBConnection();
             PreparedStatement st = conn.prepareStatement(GET_USER_BY_EMAIL_QUERY)) {
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user = getUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            log.error("SQL Error get user by E-mail " + UtilsDao.getSQLErrorString(ex));
            throw new ApplicationException("Failed to insert new user into DB", ex);
        } catch (NamingException ex) {
            log.error("Failed to connect to DB " + ex);
            throw new ApplicationException("Failed to connect to DB", ex);
        }

        if (user == null) {
            throw new ValidationException("User not found by E-mail");
        }
        return user;
    }

    private User getUserFromResultSet(ResultSet rs) throws SQLException {

        return new User.Builder()
                .setId(rs.getLong("id"))
                .setFirstName(rs.getString("firstname"))
                .setLastName(rs.getString("lastname"))
                .setSex(rs.getString("sex"))
                .setBirthDay(rs.getDate("birthday") != null
                        ? rs.getDate("birthday").toLocalDate()
                        : null)
                .setEmail(rs.getString("email"))
                .setPassword(rs.getString("password"))
                .setCreated(rs.getDate("created") != null ?
                        rs.getDate("created").toLocalDate()
                        : null)
                .setIsAdmin(rs.getBoolean("isadmin"))
                .setIsBlocked(rs.getBoolean("blocked"))
                .build();
    }
}
