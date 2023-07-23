package com.supershop.pos.controller;

import com.jfoenix.controls.JFXTextField;
import com.supershop.pos.dao.DatabaseAccessCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class AddProductForm {
    public JFXTextField txtProductName;
    public AnchorPane contentArea;
    public JFXTextField txtProductCode;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtDescription;

    public void btnSubmitProductOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        boolean success= new DatabaseAccessCode().createProduct(Integer.parseInt(txtProductCode.getText()),Double.parseDouble(txtUnitPrice.getText()),txtDescription.getText(),txtProductName.getText());

        if(success){

            new Alert(Alert.AlertType.CONFIRMATION,"Customer Add Success").show();
            setUi("ProductManagementForm");

        }else{


            new Alert(Alert.AlertType.ERROR,"Try Again").show();
            setUi("ProductManagementForm");

        }



    }

    public void backCancelOnAction(ActionEvent event) {
    }



    private void setUi(String url) throws IOException {
        Parent newContent = FXMLLoader.load(getClass().getResource("../view/" + url + ".fxml"));
        contentArea.getChildren().setAll(newContent);
    }
}
