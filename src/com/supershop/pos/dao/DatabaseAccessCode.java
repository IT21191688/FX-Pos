package com.supershop.pos.dao;

import com.supershop.pos.dao.custom.CustomerDao;
import com.supershop.pos.dao.custom.ProductDao;
import com.supershop.pos.dao.custom.UserDao;
import com.supershop.pos.dao.custom.implimentation.CustomerDaoImpl;
import com.supershop.pos.dao.custom.implimentation.ProductDaoImpl;
import com.supershop.pos.dao.custom.implimentation.UserDaoImpl;
import com.supershop.pos.entity.Customer;
import com.supershop.pos.entity.Product;
import com.supershop.pos.entity.User;

import java.sql.*;
import java.util.List;

public class DatabaseAccessCode {


    CustomerDao customerDao=new CustomerDaoImpl();

    ProductDao productDao=new ProductDaoImpl();

    UserDao userDao=new UserDaoImpl();



    public boolean createUser(String email,String password) throws ClassNotFoundException, SQLException {

        return userDao.saveUser(new User(email,password));

    }


    public User findUser(String email) throws ClassNotFoundException, SQLException {

        return userDao.findUser(email);


    }



    ///customer Management


    public boolean createCustomer(String email, String name, String contact, double salary) throws ClassNotFoundException, SQLException {

        return customerDao.saveCustomer(new Customer(email,name,contact,salary));

    }

    public  boolean updateCustomer(String email,String name,String contact,double salary) throws ClassNotFoundException, SQLException {

        return customerDao.updateCustomer(new Customer(email,name,contact,salary));

    }

    public Customer getOneCustomer(String email) throws ClassNotFoundException, SQLException {

        return customerDao.findCustomer(email);

    }


    public boolean deleteCustomer(String email) throws ClassNotFoundException, SQLException {

        return customerDao.deleteCustomer(email);

    }


    public List<Customer> findAllCustomers() throws ClassNotFoundException, SQLException {

        return customerDao.findAllCustomer();

    }


    public List<Customer> searchCustomers(String txtSearch) throws ClassNotFoundException, SQLException {

        return customerDao.searchCustomer(txtSearch);

    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //product management


    public boolean createProduct(int code,double unitPrice,String discription,String productName) throws ClassNotFoundException, SQLException {


       return productDao.saveProduct(new Product(code,discription,unitPrice,productName));


    }


    public boolean deleteProduct(int code) throws ClassNotFoundException, SQLException {

        return productDao.deleteProduct(code);

    }


    public List<Product> findAllProducts() throws ClassNotFoundException, SQLException {

        return productDao.findAllProduct();
    }


    public List<Product> searchProducts(String txtSearch) throws ClassNotFoundException, SQLException {


        return productDao.searchProduct(txtSearch);

    }


}
