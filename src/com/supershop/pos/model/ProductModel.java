package com.supershop.pos.model;

public class ProductModel {


    private int code;

    private double unitPrice;
    private String discription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;



    public ProductModel() {


    }


    public ProductModel(int code, double unitPrice, String discription, String name) {
        this.code = code;
        this.unitPrice = unitPrice;
        this.discription = discription;
        this.name = name;
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



}
