package com.supershop.pos.controller;

import com.jfoenix.controls.JFXTextField;
import com.supershop.pos.dao.DatabaseAccessCode;
import com.supershop.pos.util.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupFormController {


    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXTextField txtPassword;

    public void btnRegisterOnAction(ActionEvent event) {


        try {

            boolean success= new DatabaseAccessCode().createUser(txtEmail.getText(),txtPassword.getText());

            if(success){

                new Alert(Alert.AlertType.CONFIRMATION,"User Saved").show();
                txtEmail.clear();
                txtPassword.clear();

            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again").show();
                txtPassword.clear();
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }


    }

    public void btnLoginPageOnAction(ActionEvent event) throws IOException {

        setUi("LoginForm");

    }



    private void setUi(String url) throws IOException {

        Stage stage=(Stage)context.getScene().getWindow();
        stage.setScene(
                new Scene(FXMLLoader.load(getClass().getResource("../view/"+url+".fxml")))
        );
        stage.centerOnScreen();

    }
}
