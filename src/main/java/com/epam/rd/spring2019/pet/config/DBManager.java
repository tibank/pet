package com.epam.rd.spring2019.pet.config;

import com.epam.rd.spring2019.pet.exceptions.ApplicationException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    public static Connection getDBConnection() throws SQLException, NamingException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("jdbc/PetDB");

        return ds.getConnection();
    }

    public static Connection getConnection(Properties properties) {
        try {
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new ApplicationException("Failed to open the DB connection", e);
        }
    }
}
