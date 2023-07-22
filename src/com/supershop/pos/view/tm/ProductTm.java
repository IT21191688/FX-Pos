package com.supershop.pos.view.tm;

import javafx.scene.control.Button;

public class ProductTm {


    private int id;
    private int code;

    private String name;
    private double unitPrice;
    private String discription;
    private Button deleteBtn;

    public ProductTm(int id, int code, String name, double unitPrice, String discription, Button deleteBtn) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.discription = discription;
        this.deleteBtn = deleteBtn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductTm() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(Button deleteBtn) {
        this.deleteBtn = deleteBtn;
    }




}
