package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "OrderList{" +
                "orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderList orderList = (OrderList) o;
        return Objects.equals(orders, orderList.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders);
    }
}
