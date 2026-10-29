package com.rest.services;
import com.rest.models.menu;
import com.rest.repo.MenuRepo;
import java.util.List;
import com.rest.models.Order;
import com.rest.repo.OrderRepo;

public class OrderSrvice {
    private final OrderRepo repository;
    public OrderSrvice(){
        repository=new OrderRepo();
    }
    public List<Order> getAll(){
        return repository.getOrders();
    }
    public String addOrder1(Order o){
        if(o==null){
            return "Invalid order";
        }
        for(Order o1:repository.getOrders()){
            int id = 0;
            if(o1.getId()==id){
                repository.getOrders().remove(o1);
                return "Order removed successfully";
            }
        }
        return "Order not found";
    }
    public String updateOrderStatus(int id, Order.Status status){
        if(id <=0 ){
            return "Invalid id";
        }
        for(Order o:repository.getOrders()){
            if(o.getId()==id){
                o.setStatus(status);
                return "Order status updated successfully";
            }
        }
        return "Order not found";
    }
    public String addOrder(Order o){
        if(o==null){
            return "Invalid order";
        }
        repository.addOrder(o);
        return "Order added successfully";
    }
    public Order getOrderById(int id){
        if(id <=0 ){
            return null;
        }
        for(Order o:repository.getOrders()){
            if(o.getId()==id){
                return o;
            }
        }
        return null;
    }
    
    
}
