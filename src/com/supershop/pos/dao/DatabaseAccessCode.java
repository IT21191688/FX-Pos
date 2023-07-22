package com.supershop.pos.dao;

import com.supershop.pos.db.DbConnection;
import com.supershop.pos.model.CustomerModel;
import com.supershop.pos.model.ProductModel;
import com.supershop.pos.model.UserModel;
import com.supershop.pos.util.PasswordManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccessCode {



    public static boolean createUser(String email,String password) throws ClassNotFoundException, SQLException {


        String sql="INSERT INTO user VALUES (?,?)";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1,email);
        preparedStatement.setString(2, PasswordManager.encriptPassword(password));


        return preparedStatement.executeUpdate()>0;


    }


    public static UserModel findUser(String email) throws ClassNotFoundException, SQLException {



        String sql="SELECT * FROM user WHERE email=?";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1,email);


        ResultSet set=preparedStatement.executeQuery();

        if(set.next()){

            UserModel user=new UserModel(set.getString(1),set.getString(2));

            return user;

        }

        return null;

    }



    ///customer Management


    public static boolean createCustomer(String email,String name,String contact,double salary) throws ClassNotFoundException, SQLException {


        String sql="INSERT INTO customer (email, name, contact_no, salary) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1,email);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, contact);
        preparedStatement.setDouble(4, salary);


        return preparedStatement.executeUpdate()>0;



    }

    public static boolean updateCustomer(String email,String name,String contact,double salary) throws ClassNotFoundException, SQLException {



        String sql="UPDATE customer SET name=?, contact_no=?,salary=? WHERE email=? ";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, contact);
        preparedStatement.setDouble(3, salary);
        preparedStatement.setString(4,email);

        return preparedStatement.executeUpdate()>0;


    }

    public static CustomerModel getOneCustomer(String email) throws ClassNotFoundException, SQLException {




        String sql="SELECT * FROM customer WHERE email=?";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1,email);


        ResultSet set=preparedStatement.executeQuery();

        if(set.next()){

            CustomerModel customer=new CustomerModel(set.getString(1),set.getString(2),set.getString(3),set.getDouble(4));

            return customer;

        }

        return null;

    }


    public static boolean deleteCustomer(String email) throws ClassNotFoundException, SQLException {



        String sql="DELETE FROM customer WHERE email=?";

        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1,email);

        return preparedStatement.executeUpdate()>0;

    }


    public static List<CustomerModel> findAllCustomers() throws ClassNotFoundException, SQLException {


        String sql="SELECT * FROM customer";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));

        ResultSet set=preparedStatement.executeQuery();

        List<CustomerModel> customerModels=new ArrayList<>();
        while (set.next()){

            CustomerModel customer=new CustomerModel(set.getString(1),set.getString(2),set.getString(3),set.getDouble(4));

            customerModels.add(customer);


        }

        return customerModels;


    }


    public static List<CustomerModel> searchCustomers(String txtSearch) throws ClassNotFoundException, SQLException {

        txtSearch="%"+txtSearch+"%";


        String sql="SELECT * FROM customer WHERE email LIKE ? || name LIKE ?";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));

        preparedStatement.setString(1,txtSearch);
        preparedStatement.setString(2,txtSearch);

        ResultSet set=preparedStatement.executeQuery();

        List<CustomerModel> customerModels=new ArrayList<>();
        while (set.next()){

            CustomerModel customer=new CustomerModel(set.getString(1),set.getString(2),set.getString(3),set.getDouble(4));

            customerModels.add(customer);

        }

        return customerModels;

    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //product management


    public static boolean createProduct(int code,double unitPrice,String discription) throws ClassNotFoundException, SQLException {

        String sql="INSERT INTO product (code, discription, unit_price) VALUES (?,?,?)";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setInt(1,code);
        preparedStatement.setDouble(2, unitPrice);
        preparedStatement.setString(3, discription);

        return preparedStatement.executeUpdate()>0;

    }


    public static boolean deleteProduct(int code) throws ClassNotFoundException, SQLException {

        String sql="DELETE FROM product WHERE code=?";

        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setInt(1,code);

        return preparedStatement.executeUpdate()>0;

    }


    public static List<ProductModel> findAllProducts() throws ClassNotFoundException, SQLException {


        String sql="SELECT * FROM product";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));

        ResultSet set=preparedStatement.executeQuery();

        List<ProductModel> productModels=new ArrayList<>();
        while (set.next()){

            ProductModel product=new ProductModel(set.getInt(1),set.getDouble(2),set.getString(3));

            productModels.add(product);


        }

        return productModels;


    }


    public static List<ProductModel> searchProducts(int txtSearch) throws ClassNotFoundException, SQLException {



        String sql="SELECT * FROM product WHERE code LIKE ? || name LIKE ?";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));

        preparedStatement.setInt(1,txtSearch);
        preparedStatement.setInt(2,txtSearch);

        ResultSet set=preparedStatement.executeQuery();

        List<ProductModel> productModels=new ArrayList<>();
        while (set.next()){

            ProductModel product=new ProductModel(set.getInt(1),set.getDouble(2),set.getString(3));

            productModels.add(product);

        }

        return productModels;



    }


}
