package com.rest.repo;
import com.rest.models.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
    private  final List<Order> orders = new ArrayList<>();
    public OrderRepo(){
        orders.add(new Order(1,"John",null));
        orders.add(new Order(2,"Alice",null));
        orders.add(new Order(3,"Bob",null));
    }
    public List<Order> getOrders(){
        return orders;
    }
    public boolean addOrder(Order o){
        return orders.add(o);
    }


}
