package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Order;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.OrderList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDao {

    OrderDao instance = new OrderDaoImpl();

    static OrderDao getInstance(){
        return instance;
    }

    void addOrder(int customerId, int roomNum);
    OrderList getAllOrders();
    Order parseOrder(ResultSet resultSet) throws SQLException;
    void removeOrder(int id);
}
