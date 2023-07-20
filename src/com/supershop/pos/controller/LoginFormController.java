package com.supershop.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXTextField txtPassword;
    public JFXButton btnLogin;
    public JFXButton btnSignUp;

    public void btnLoginOnAction(ActionEvent event) {
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
