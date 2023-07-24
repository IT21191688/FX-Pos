package com.supershop.pos.bo.custom.impl;

import com.supershop.pos.bo.custom.CustomerBo;
import com.supershop.pos.dao.custom.CustomerDao;

import java.util.List;

public class CustomerBoImpl implements CustomerBo {
    @Override
    public boolean saveCustomer(CustomerDao customerDao) {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDao customerDao) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String email) {
        return false;
    }

    @Override
    public CustomerDao findCustomer(String email) {
        return null;
    }

    @Override
    public List<CustomerDao> findAllCustomers() {
        return null;
    }
}
