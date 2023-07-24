package com.supershop.pos.bo.custom;

import com.supershop.pos.dao.custom.CustomerDao;
import com.supershop.pos.dao.custom.ProductDao;

import java.util.List;

public interface ProductBo {


    public boolean saveProduct(ProductDao productDao);

    public boolean updateProduct(ProductDao productDao);

    public boolean deleteProduct(int code);

    public ProductDao findProduct(String product_name);

    public List<ProductDao> findAllCustomers();

}
