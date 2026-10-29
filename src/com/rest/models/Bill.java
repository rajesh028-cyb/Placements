
package com.rest.models;

public class Bill {
    private int id;
    private String custName;
    private double totalPrice;

    
    public Bill(int id, String custName, double totalPrice) {
        this.id = id;
        this.custName = custName;
        this.totalPrice = totalPrice;
    }


    public int getId() {
        return id;
    }

    public String getCustName() {
        return custName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Display bill details
    @Override
    public String toString() {
        return "Bill ID: " + id
                + ", Customer Name: " + custName
                + ", Total Price: " + String.format("%.2f", totalPrice);
    }
}
