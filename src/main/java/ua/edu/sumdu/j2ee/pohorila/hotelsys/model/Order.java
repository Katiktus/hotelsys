package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

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

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
