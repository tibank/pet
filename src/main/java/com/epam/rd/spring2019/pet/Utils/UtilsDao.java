package com.epam.rd.spring2019.pet.Utils;

import java.sql.SQLException;

public class UtilsDao {
    public static String getSQLErrorString(SQLException e) {
        return System.lineSeparator() +
                "SQLState(" + e.getSQLState() + ") " +
                "SQLErrorCode(" + e.getErrorCode() + ") " +
                "SQLMessage: " + e.getMessage();
    }
}
