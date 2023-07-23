package com.supershop.pos.controller;

import com.jfoenix.controls.JFXTextField;
import com.supershop.pos.dao.DatabaseAccessCode;
import com.supershop.pos.entity.Product;
import com.supershop.pos.view.tm.ProductTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class ProductManagementForm {


    public AnchorPane customerContentArea;
    public AnchorPane contentArea;
    public TableView<ProductTm> tblView;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colCode;
    public TableColumn colDis;
    public TableColumn colDelete;
    public JFXTextField txtSearchProduct;


    private String searchText="";


    public void initialize() throws SQLException, ClassNotFoundException {


        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDis.setCellValueFactory(new PropertyValueFactory<>("discription"));

        colDelete.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));

        loadAllProducts(searchText);

        tblView.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {

            if(newValue!=null){
                setData(newValue);
            }
        }));

        txtSearchProduct.textProperty().addListener(((observable, oldValue, newValue) -> {

            searchText=newValue;

            System.out.println(newValue);

            try {
                loadAllProducts(searchText);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }));



    }

    private void setData(ProductTm newValue) {



    }

    private void loadAllProducts(String searchText) throws SQLException, ClassNotFoundException {

        ObservableList<ProductTm> observableList= FXCollections.observableArrayList();

        int counter=1;

        for(Product product:searchText.length()>0?new DatabaseAccessCode().searchProducts(searchText):new DatabaseAccessCode().findAllProducts()){

            javafx.scene.control.Button deleteBtn=new Button("delete");

            ProductTm tm=new ProductTm(counter,product.getCode(),product.getProduct_name(),product.getUnit_price(),product.getDiscription(),deleteBtn);

            observableList.add(tm);
            counter++;



            deleteBtn.setOnAction((e)->{

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?",ButtonType.YES,ButtonType.NO);

                Optional<ButtonType> selectedButtonType=alert.showAndWait();



                try {

                    boolean success=new DatabaseAccessCode().deleteProduct(product.getCode());

                    if(success){
                        new Alert(Alert.AlertType.CONFIRMATION,"Success").show();
                        loadAllProducts(searchText);
                    }else{
                        new Alert(Alert.AlertType.ERROR,"UnSuccess").show();
                    }

                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

/*
                if(selectedButtonType.equals(ButtonType.YES)){
                    try {


                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

*/

            });
        }

        tblView.setItems(observableList);

    }






    public void newProductOnAction(ActionEvent event) throws IOException {

        setUi("AddProductForm");

    }

    public void backProductOnAction(ActionEvent event) {
    }

    public void newBatchOnAction(ActionEvent event) {
    }


    private void setUi(String url) throws IOException {
        Parent newContent = FXMLLoader.load(getClass().getResource("../view/" + url + ".fxml"));
        contentArea.getChildren().setAll(newContent);
    }
}
