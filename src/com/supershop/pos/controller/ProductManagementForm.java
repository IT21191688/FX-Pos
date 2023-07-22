package com.supershop.pos.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ProductManagementForm {


    public AnchorPane contentArea;
    public AnchorPane customerContentArea;
    public TableView tblView;
    public TableColumn colId;
    public TableColumn colDescription;
    public TableColumn colShowMore;
    public TableColumn colDelete;
    public JFXTextField txtSearchProduct;
    public JFXTextArea txtProductDescription;
    public JFXTextField txtProductCode;
    public JFXTextField txtProductCode1;
    public JFXTextArea txtProductDiscription1;
    public TableView tblView1;
    public TableColumn tbl_B_Id;
    public TableColumn tbl_B_Quty;
    public TableColumn tbl_B_Sprice;
    public TableColumn tbl_B_Bprice;
    public TableColumn tbl_B_Dav;
    public TableColumn tbl_B_Showprice;
    public TableColumn tbl_B_Delete;
    public JFXTextArea txtProductDiscription;
    public TableColumn colDiscription;
    public JFXTextField txtUnitPrice;

    public void backProductOnAction(ActionEvent event) {
    }

    public void saveProductOnAction(ActionEvent event) {
    }

    public void newProductOnAction(ActionEvent event) {
    }

    public void newBatchOnAction(ActionEvent event) {
    }
}
