package com.example.rentalsystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class  DBConnection  {

    public Connection conn;

    public Connection getConn() {

        // JDBC URL, username, and password of MySQL server

        String url = "jdbc:mysql://localhost:3306/lamda";
        String user = "root";
        String password = "*******:wq";
        //String databaseName = "lamda";

        // JDBC variables for opening, closing, and managing connection


        try {

            conn = DriverManager.getConnection(url, user, password);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return conn;
    }
}





