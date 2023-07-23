package com.supershop.pos.dao.custom;



import com.supershop.pos.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {


    public boolean saveUser(User user) throws SQLException, ClassNotFoundException;

    public boolean updateUser(User user);

    public boolean deleteUser(String email);

    public User findUser(String email) throws SQLException, ClassNotFoundException;

    public List<User> findAllCustomer();
}
