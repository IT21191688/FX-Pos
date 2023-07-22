package com.supershop.pos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {


    //create database & tables

    private static DbConnection dbconnection;

    private Connection connection;

    private DbConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_pos","root","1234");

    }

    public static  DbConnection getInstance() throws SQLException, ClassNotFoundException {

        return (dbconnection==null)?dbconnection=new DbConnection():dbconnection;
    }


    public Connection getConnection(){
        return connection;
    }

}
