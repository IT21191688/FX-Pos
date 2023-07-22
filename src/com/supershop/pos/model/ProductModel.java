package com.supershop.pos.model;

public class ProductModel {


    private int code;

    private double unitPrice;
    private String discription;



    public ProductModel() {


    }


    public ProductModel(int code, double unitPrice, String discription) {
        this.code = code;
        this.unitPrice = unitPrice;
        this.discription = discription;
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
