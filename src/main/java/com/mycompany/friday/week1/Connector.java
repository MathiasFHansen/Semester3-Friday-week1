package com.mycompany.friday.week1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/startcode?serverTimezone=Europe/Rome";
    private static final String USERNAME = "dev";
    private static final String PASSWORD = "ax2";

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
       if ((singleton == null) || singleton.isClosed()) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }
    
    
}