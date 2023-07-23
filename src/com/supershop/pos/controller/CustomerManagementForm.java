package com.supershop.pos.controller;

import com.jfoenix.controls.JFXTextField;
import com.supershop.pos.dao.DatabaseAccessCode;
import com.supershop.pos.entity.Customer;
import com.supershop.pos.model.CustomerModel;
import com.supershop.pos.view.tm.CustomerTm;
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

import static javafx.application.Application.launch;

public class CustomerManagementForm {


    public AnchorPane customerContentArea;
    public AnchorPane contentArea;
    public TableColumn<Object, Object> colId;
    public TableColumn colEmail;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colSalary;
    public JFXTextField txtSearch;
    public TableView<CustomerTm> tblView;
    public TableColumn colUpdate;
    public TableColumn colDelete;


    private String searchText="";


    public void initialize() throws SQLException, ClassNotFoundException {


        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("updateBtn"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));

        loadAllCustomer(searchText);


        tblView.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {

            if(newValue!=null){
                setData(newValue);
            }
        }));

        txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {

            searchText=newValue;

            try {
                loadAllCustomer(searchText);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }));



    }

    private void setData(CustomerTm newValue) {



    }

    private void loadAllCustomer(String searchText) throws SQLException, ClassNotFoundException {

        ObservableList<CustomerTm> observableList= FXCollections.observableArrayList();

        int counter=1;

        for(Customer customer:searchText.length()>0? new DatabaseAccessCode().searchCustomers(searchText):new DatabaseAccessCode().findAllCustomers()){

            javafx.scene.control.Button deleteBtn=new Button("delete");
            javafx.scene.control.Button updateBtn=new Button("update");

            CustomerTm tm=new CustomerTm(counter,customer.getEmail(),customer.getName(),customer.getContact_no(),customer.getSalary(),deleteBtn,updateBtn);

            observableList.add(tm);
            counter++;



            deleteBtn.setOnAction((e)->{

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?",ButtonType.YES,ButtonType.NO);

                Optional<ButtonType> selectedButtonType=alert.showAndWait();
                System.out.println(customer.getEmail());


                try {

                     boolean success=new DatabaseAccessCode().deleteCustomer(customer.getEmail());

                    if(success){
                        new Alert(Alert.AlertType.CONFIRMATION,"Success").show();
                        loadAllCustomer(searchText);
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

    public void addNewCustomerOnAction(ActionEvent event) throws IOException {

        setUi("AddCustomerForm");

    }

    private void setUi(String url) throws IOException {
        Parent newContent = FXMLLoader.load(getClass().getResource("../view/" + url + ".fxml"));
        contentArea.getChildren().setAll(newContent);
    }

    public void btnRefreshOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        loadAllCustomer(searchText);

    }
}
