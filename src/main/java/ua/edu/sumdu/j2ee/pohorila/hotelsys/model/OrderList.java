package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import java.util.ArrayList;

public class OrderList {
    ArrayList<Order> orders;

    public OrderList(){
        this.orders = new ArrayList<Order>();
    }

    public void add(Order parseOrder) {
        orders.add(parseOrder);
    }

    public ArrayList<Order> getArr(){
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
