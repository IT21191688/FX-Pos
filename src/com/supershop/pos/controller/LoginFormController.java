package com.supershop.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.supershop.pos.dao.DatabaseAccessCode;
import com.supershop.pos.entity.User;
import com.supershop.pos.model.UserModel;
import com.supershop.pos.util.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginFormController {

    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXTextField txtPassword;
    public JFXButton btnLogin;
    public JFXButton btnSignUp;

    public void btnLoginOnAction(ActionEvent event) throws ClassNotFoundException {

        try {

            User user=new DatabaseAccessCode().findUser(txtEmail.getText());

            if(user!=null){

                if(PasswordManager.checkPassword(user.getPassword(),txtPassword.getText())){
                    //login success
                    new Alert(Alert.AlertType.CONFIRMATION,"Login Success").show();

                    setUi("DashboardForm");
                }
                else{
                    //login password not correct
                    new Alert(Alert.AlertType.WARNING,"Password Incorrect").show();
                    txtPassword.clear();
                }


            }else{
                new Alert(Alert.AlertType.WARNING,"User Email Not Found").show();
                txtEmail.clear();
                txtPassword.clear();
            }



        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void btnSignUpOnAction(ActionEvent event) throws IOException {


        setUi("SignupForm");


    }

    private void setUi(String url) throws IOException {

        Stage stage=(Stage)context.getScene().getWindow();

        stage.setScene(
                new Scene(FXMLLoader.load(getClass().getResource("../view/"+url+".fxml")))
        );

        stage.centerOnScreen();

    }

}
