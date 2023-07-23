package com.supershop.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.supershop.pos.dao.DatabaseAccessCode;
import com.supershop.pos.model.CustomerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class AddCustomerForm {
    public AnchorPane contentArea;
    public JFXTextField txtEmail;
    public JFXTextField txtName;
    public JFXTextField txtContact;
    public JFXTextField txtSalary;
    public JFXButton btnSubmitCustomer;

    public void backCancelOnAction(ActionEvent event) throws IOException {

        setUi("CustomerManagementForm");

    }




    public void btnSubmitCustomerOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        boolean success= new DatabaseAccessCode().createCustomer(txtEmail.getText(),txtName.getText(),txtContact.getText(),Double.parseDouble(txtSalary.getText()));


        if(success){

            new Alert(Alert.AlertType.CONFIRMATION,"Customer Add Success").show();
            setUi("CustomerManagementForm");

        }else{


            new Alert(Alert.AlertType.ERROR,"Try Again").show();
            setUi("CustomerManagementForm");

        }

    }


    private void setUi(String url) throws IOException {
        Parent newContent = FXMLLoader.load(getClass().getResource("../view/" + url + ".fxml"));
        contentArea.getChildren().setAll(newContent);
    }


}
