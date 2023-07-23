package com.supershop.pos.dao.custom;

import com.supershop.pos.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {


    public boolean saveProduct(Product product) throws SQLException, ClassNotFoundException;

    public boolean updateProduct(Product product);

    public boolean deleteProduct(int code) throws SQLException, ClassNotFoundException;

    public Product findProduct(String product_name);

    public List<Product> findAllProduct() throws SQLException, ClassNotFoundException;

    public List<Product> searchProduct(String txtSearch) throws SQLException, ClassNotFoundException;

}
