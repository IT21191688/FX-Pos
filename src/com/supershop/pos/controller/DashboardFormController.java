package com.supershop.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {


    public AnchorPane contentArea;

    public void btnHomeOnAction(ActionEvent event) throws IOException {
        setUi("HomePageForm");
    }
    public void btnCustomerOnAction(ActionEvent event) throws IOException {
        setUi("CustomerManagementForm");
    }

    public void btnProductOnAction(ActionEvent event) throws IOException {
        setUi("ProductManagementForm");
    }

    public void btnPlaceOrderOnAction(ActionEvent event) throws IOException {
        setUi("PlaceOrderForm");
    }

    public void btnOrderDetailsOnAction(ActionEvent event) throws IOException {
        setUi("OrderDetailsForm");
    }

    public void btnIncomeReportsOnAction(ActionEvent event) throws IOException {
        setUi("IncomeReportsForm");
    }


    private void setUi(String url) throws IOException {
        Parent newContent = FXMLLoader.load(getClass().getResource("../view/" + url + ".fxml"));
        contentArea.getChildren().setAll(newContent);
    }


}
