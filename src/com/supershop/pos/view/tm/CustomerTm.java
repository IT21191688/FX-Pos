package com.supershop.pos.view.tm;

import javafx.scene.control.Button;

import java.awt.*;

public class CustomerTm {

    private int id;
    private String email;
    private String name;
    private String contact;
    private double salary;
    private javafx.scene.control.Button deleteBtn;

    private javafx.scene.control.Button updateBtn;


    public CustomerTm() {
    }
    public CustomerTm(int id, String email, String name, String contact, double salary , javafx.scene.control.Button deleteBtn, javafx.scene.control.Button updateBtn) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.contact = contact;
        this.salary = salary;
        this.deleteBtn = deleteBtn;
        this.updateBtn = updateBtn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public javafx.scene.control.Button getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(javafx.scene.control.Button deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public javafx.scene.control.Button getUpdateBtn() {
        return updateBtn;
    }

    public void setUpdateBtn(Button updateBtn) {
        this.updateBtn = updateBtn;
    }



}
