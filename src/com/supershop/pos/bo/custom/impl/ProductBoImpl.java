package com.supershop.pos.bo.custom.impl;

import com.supershop.pos.bo.custom.ProductBo;
import com.supershop.pos.dao.custom.ProductDao;

import java.util.List;

public class ProductBoImpl implements ProductBo {
    @Override
    public boolean saveProduct(ProductDao productDao) {
        return false;
    }

    @Override
    public boolean updateProduct(ProductDao productDao) {
        return false;
    }

    @Override
    public boolean deleteProduct(int code) {
        return false;
    }

    @Override
    public ProductDao findProduct(String product_name) {
        return null;
    }

    @Override
    public List<ProductDao> findAllCustomers() {
        return null;
    }
}
