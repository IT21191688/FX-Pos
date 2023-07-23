package com.supershop.pos.dao.custom.implimentation;

import com.supershop.pos.dao.custom.ProductDao;
import com.supershop.pos.db.DbConnection;
import com.supershop.pos.entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean saveProduct(Product product) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO product (code,discription,unit_price,product_name) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setInt(1,product.getCode());
        preparedStatement.setString(2, product.getDiscription());
        preparedStatement.setDouble(3, product.getUnit_price());
        preparedStatement.setString(4, product.getProduct_name());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int code) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM product WHERE code=?";

        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setInt(1,code);

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public Product findProduct(String product_name) {
        return null;
    }

    @Override
    public List<Product> findAllProduct() throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM product";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));

        ResultSet set=preparedStatement.executeQuery();

        List<Product> productModels=new ArrayList<>();
        while (set.next()){

            Product product=new Product(set.getInt(1),set.getString(2),set.getDouble(3),set.getString(4));

            productModels.add(product);


        }

        return productModels;
    }

    @Override
    public List<Product> searchProduct(String txtSearch) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM product WHERE product_name LIKE ? || discription LIKE ?";

        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement((sql));

        preparedStatement.setString(1, txtSearch);
        preparedStatement.setString(2, txtSearch);

        ResultSet set = preparedStatement.executeQuery();

        List<Product> productModels = new ArrayList<>();
        while (set.next()) {

            Product product = new Product(set.getInt(1), set.getString(2), set.getDouble(3), set.getString(4));

            productModels.add(product);

        }

        return productModels;
    }
}
