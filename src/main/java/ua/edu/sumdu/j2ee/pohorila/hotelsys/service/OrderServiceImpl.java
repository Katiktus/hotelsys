package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.dao.OrderDao;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.OrderList;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    public OrderDao orderDao;
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public void addOrder(int customerId, int roomNum) {
        logger.info("addOrder: "+customerId+", "+roomNum);
        orderDao.addOrder(customerId, roomNum);
    }

    @Override
    public OrderList getAllOrders() {
        logger.info("getAllOrders");
        return orderDao.getAllOrders();
    }

    @Override
    public void removeOrder(int id) {
        logger.info("removeOrder "+id);
        orderDao.removeOrder(id);
    }
}
