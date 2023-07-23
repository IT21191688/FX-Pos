package com.supershop.pos.dao.custom.implimentation;

import com.supershop.pos.dao.custom.UserDao;
import com.supershop.pos.db.DbConnection;
import com.supershop.pos.entity.User;
import com.supershop.pos.model.UserModel;
import com.supershop.pos.util.PasswordManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean saveUser(User user) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO user VALUES (?,?)";

        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1,user.getEmail());
        preparedStatement.setString(2, PasswordManager.encriptPassword(user.getPassword()));


        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(String email) {
        return false;
    }

    @Override
    public User findUser(String email) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM user WHERE email=?";

        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement((sql));
        preparedStatement.setString(1,email);


        ResultSet set=preparedStatement.executeQuery();

        if(set.next()){

            User user=new User(set.getString(1),set.getString(2));

            return user;

        }

        return null;
    }

    @Override
    public List<User> findAllCustomer() {
        return null;
    }
}
