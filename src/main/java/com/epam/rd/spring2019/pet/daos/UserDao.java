package com.epam.rd.spring2019.pet.daos;


import com.epam.rd.spring2019.pet.models.User;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface UserDao {

    User getUserByEmail(String email) throws SQLException, NamingException;
    User addUser(User user) throws SQLException, NamingException;
    User updateUser(User user) throws SQLException, NamingException;
}
