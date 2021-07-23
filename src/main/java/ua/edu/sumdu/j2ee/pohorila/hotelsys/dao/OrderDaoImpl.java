package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Order;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.OrderList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class OrderDaoImpl implements OrderDao{
    public OrderDaoImpl(){
        super();
    }

    @Autowired
    public HotelsysDao hotelsysDao;
    private PreparedStatement preparedStatement = null;
    Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);


    @Override
    public void addOrder(int customerId, int roomNum) {
        Connection connection = hotelsysDao.connect();
        try {
            String sql = "select LAB3_EP_CUSTOMER_SEQUENCE.nextval from DUAL";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int id = 0;
            if(rs.next())
                id = rs.getInt(1);
            preparedStatement = connection.prepareStatement("insert into LAB3_EP_ORDER values (?, ?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, customerId);
            preparedStatement.setInt(3, roomNum);
            preparedStatement.execute();
            logger.info("addOrder: "+customerId+", "+roomNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }

    @Override
    public OrderList getAllOrders() {
        Connection connection = hotelsysDao.connect();
        OrderList orderList = new OrderList();
        try {
            preparedStatement = connection.prepareStatement("select * from LAB3_EP_ORDER");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                orderList.add(parseOrder(resultSet));
            }
            logger.info("getAllOrders");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
        return orderList;
    }

    @Override
    public Order parseOrder(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("LAB3_EP_ORDER_ID");
        int customerId = resultSet.getInt("LAB3_EP_ORDER_CUSTOMER_ID");
        int roomNumber = resultSet.getInt("LAB3_EP_ROOM_NUMBER");
        Order order = new Order(id, customerId, roomNumber);
        logger.info("parseOrder");
        return order;
    }

    @Override
    public void removeOrder(int id) {
        Connection connection = hotelsysDao.connect();
        try {
            preparedStatement = connection.prepareStatement("delete from LAB3_EP_ORDER where LAB3_EP_ORDER_ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("removeOrder "+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }
}
