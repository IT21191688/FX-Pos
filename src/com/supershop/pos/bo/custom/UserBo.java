package com.supershop.pos.bo.custom;

import com.supershop.pos.dao.custom.CustomerDao;
import com.supershop.pos.dao.custom.UserDao;

import java.util.List;

public interface UserBo {


    public boolean saveUser(UserDao userDao);

    public boolean updateUser(UserDao userDao);

    public boolean deleteUser(String email);

    public UserDao findUser(String email);

    public List<UserDao> findAllUsers();



}
