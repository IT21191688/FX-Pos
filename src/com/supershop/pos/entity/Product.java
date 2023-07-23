package com.supershop.pos.entity;

public class Product {

    private int code;
    private String discription;
    private double unit_price;
    private String product_name;

    public Product(int code, String discription, double unit_price, String product_name) {
        this.code = code;
        this.discription = discription;
        this.unit_price = unit_price;
        this.product_name = product_name;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
