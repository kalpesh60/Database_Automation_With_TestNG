package com.Testing.Selenium;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest extends Base {

    public static  int count;

    @Test(priority = 1)
    public void getTableData() throws SQLException {
        connection = this.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            String password = resultSet.getString(4);
            System.out.println(id + " " +name + " " +email + " " +password);
            count++;
        }
    }

    @Test(priority = 2)
    public void insertDataInTable () throws SQLException {
        connection = this.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(?,?,?,?)");
        preparedStatement.setInt(1,count+100);
        preparedStatement.setString(2,"ajay1");
        preparedStatement.setString(3,"ajay160@gmail.com");
        preparedStatement.setString(4,"78689");
        preparedStatement.executeUpdate();
        getTableData();
    }

    @Test(priority = 3)
    public void updateDataInTable () throws SQLException {
        connection = this.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update user set user_name = ? where user_id = ?");
        preparedStatement.setString(1,"rahul");
        preparedStatement.setInt(2,103);
        preparedStatement.executeUpdate();
        getTableData();
    }

    @Test(priority = 4)
    public void deleteDataFromTable () throws SQLException {
        connection = this.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from user where user_id = ?");
        preparedStatement.setInt(1,7);
        preparedStatement.executeUpdate();
        getTableData();
    }
}
