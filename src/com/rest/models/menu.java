package com.rest.models;

public class menu {
    
    public enum Type {
        FOOD, DRINK, DESSERT, STARTERS
    }

    private int id;
    private String foodname;
    private double price;
    private Type type;

    public menu(int id, String custName, double price, Type type) {
        this.id = id;
        this.foodname = custName;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return foodname; 
    }

    public void setName(String custName) {
        this.foodname = custName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}