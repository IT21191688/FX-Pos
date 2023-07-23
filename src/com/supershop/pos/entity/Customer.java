package com.supershop.pos.entity;

public class Customer {


    private String email;
    private String name;
    private String contact_no;
    private double salary;

    public Customer() {
    }

    public Customer(String email, String name, String contact_no, double salary) {
        this.email = email;
        this.name = name;
        this.contact_no = contact_no;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", salary=" + salary +
                '}';
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

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
