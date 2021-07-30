package com.Testing.Selenium;

import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base {
    public static Connection connection;

    @BeforeTest
    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify?useSSL=false", "root", "root");
        System.out.println("connection is successful:" + connection);
        return connection;
    }
}
