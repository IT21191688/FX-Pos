package com.supershop.pos.dao.custom.implimentation;

import com.supershop.pos.dao.custom.CustomerDao;
import com.supershop.pos.db.DbConnection;
import com.supershop.pos.entity.Customer;
import com.supershop.pos.model.CustomerModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO customer (email, name, contact_no, salary) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1,customer.getEmail());
        preparedStatement.setString(2, customer.getName());
        preparedStatement.setString(3, customer.getContact_no());
        preparedStatement.setDouble(4, customer.getSalary());

        return preparedStatement.executeUpdate()>0;

    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {


        String sql="UPDATE customer SET name=?, contact_no=?,salary=? WHERE email=? ";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2,customer.getContact_no());
        preparedStatement.setDouble(3, customer.getSalary());
        preparedStatement.setString(4,customer.getEmail());

        return preparedStatement.executeUpdate()>0;

    }

    @Override
    public boolean deleteCustomer(String email) throws SQLException, ClassNotFoundException {


        String sql="DELETE FROM customer WHERE email=?";

        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1,email);

        return preparedStatement.executeUpdate()>0;


    }

    @Override
    public Customer findCustomer(String email) throws SQLException, ClassNotFoundException {


        String sql="SELECT * FROM customer WHERE email=?";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1,email);


        ResultSet set=preparedStatement.executeQuery();

        if(set.next()){

            Customer customer=new Customer(set.getString(1),set.getString(2),set.getString(3),set.getDouble(4));

            return customer;

        }

        return null;


    }

    @Override
    public List<Customer> findAllCustomer() throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM customer";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));

        ResultSet set=preparedStatement.executeQuery();

        List<Customer> customerModels=new ArrayList<>();
        while (set.next()){

            Customer customer=new Customer(set.getString(1),set.getString(2),set.getString(3),set.getDouble(4));
            customerModels.add(customer);

        }
        return customerModels;
    }

    @Override
    public List<Customer> searchCustomer(String txtSearch) throws SQLException, ClassNotFoundException {
        txtSearch="%"+txtSearch+"%";


        String sql="SELECT * FROM customer WHERE email LIKE ? || name LIKE ?";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));

        preparedStatement.setString(1,txtSearch);
        preparedStatement.setString(2,txtSearch);

        ResultSet set=preparedStatement.executeQuery();

        List<Customer> customerModels=new ArrayList<>();
        while (set.next()){

            Customer customer=new Customer(set.getString(1),set.getString(2),set.getString(3),set.getDouble(4));

            customerModels.add(customer);

        }

        return customerModels;

    }
}
