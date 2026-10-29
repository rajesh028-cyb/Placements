package com.rest.models;
import java.util.List;
import java.util.ArrayList;
public class Order {
    private int id;
    private String custName;
    private List<menu> items = new ArrayList<>();
     public enum Status {
         PENDING,
         CONFIRMED,
         CANCELLED
     }
     private Status status = Status.PENDING;
     public Order(int id, String custName, List<menu> items) {
         this.id = id;
         this.custName = custName;
         this.items = items;
     }
     public int getId() {
         return id;
     }
     public void setId(int id) {
         this.id = id;
     }
     public String getCustName() {
         return custName;
     }
     public void setCustName(String custName) {
         this.custName = custName;
     }
     public List<menu> getItems() {
         return items;
     }
     public void setItems(List<menu> items) {
         this.items = items;
     }
     public Status getStatus() {
         return status;
     }
     public void setStatus(Status status) {
         this.status = status;
     }

    }