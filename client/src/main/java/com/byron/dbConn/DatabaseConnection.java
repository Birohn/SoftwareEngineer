package com.byron.dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection { //links database
    private static final String userName = "dbuser";
    private static final String password = "dbpassword";
    private static final String connect = "jdbc:mysql://localhost/login";
    private static final String sqConnect = "jdbc:sqlite:mydb.db";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(sqConnect);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

