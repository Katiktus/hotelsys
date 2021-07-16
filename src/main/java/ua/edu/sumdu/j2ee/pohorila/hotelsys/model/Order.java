package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import java.util.Comparator;
import java.util.Objects;

public class Order {
    int orderId;
    int customerId;
    int roomNumber;

    public Order(int orderId, int customerId, int roomNumber) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.roomNumber = roomNumber;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && customerId == order.customerId && roomNumber == order.roomNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, roomNumber);
    }

    public static Comparator<Order> idComparator = new Comparator<Order>() {
       //@Override
        public int compare(Order o1, Order o2) {
            int first = o1.getOrderId();
            int second = o2.getOrderId();
            return first- second;
        }
    };

    public static Comparator<Order> customerComparator = new Comparator<Order>() {
        //@Override
        public int compare(Order o1, Order o2) {
            int first = o1.getCustomerId();
            int second = o2.getCustomerId();
            return first- second;
        }
    };

    public static Comparator<Order> roomComparator = new Comparator<Order>() {
        //@Override
        public int compare(Order o1, Order o2) {
            int first = o1.getRoomNumber();
            int second = o2.getRoomNumber();
            return first- second;
        }
    };


}
