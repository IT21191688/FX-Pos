package com.supershop.pos.bo.custom.impl;

import com.supershop.pos.bo.custom.UserBo;
import com.supershop.pos.dao.custom.UserDao;

import java.util.List;

public class UserBoImpl implements UserBo {

    //we can use thi layer call the dao layer
    @Override
    public boolean saveUser(UserDao userDao) {
        return false;
    }

    @Override
    public boolean updateUser(UserDao userDao) {
        return false;
    }

    @Override
    public boolean deleteUser(String email) {
        return false;
    }

    @Override
    public UserDao findUser(String email) {
        return null;
    }

    @Override
    public List<UserDao> findAllUsers() {
        return null;
    }
}
