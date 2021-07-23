package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.OrderList;

@Service
public interface OrderService {
    OrderService instance = new OrderServiceImpl();

    void addOrder(int customerId, int roomNum);
    OrderList getAllOrders();
    void removeOrder(int id);
}
