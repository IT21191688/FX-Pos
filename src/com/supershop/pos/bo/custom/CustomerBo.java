package com.supershop.pos.bo.custom;

import com.supershop.pos.dao.custom.CustomerDao;

import java.util.List;

public interface CustomerBo {


    public boolean saveCustomer(CustomerDao customerDao);

    public boolean updateCustomer(CustomerDao customerDao);

    public boolean deleteCustomer(String email);

    public CustomerDao findCustomer(String email);

    public List<CustomerDao> findAllCustomers();


}
