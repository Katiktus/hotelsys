package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Customer;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.CustomerList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    public CustomerDaoImpl(){
        super();
    }

    @Autowired
    public HotelsysDao hotelsysDao;
    private PreparedStatement preparedStatement = null;
    Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

    @Override
    public void addCustomer(String name, String phoneNumber) {
        Connection connection = hotelsysDao.connect();
        try {
            String sql = "select LAB3_EP_CUSTOMER_SEQUENCE.nextval from DUAL";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int id = 0;
            if(rs.next())
                id = rs.getInt(1);
            preparedStatement = connection.prepareStatement("insert into LAB3_EP_CUSTOMER values (?, ?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.execute();
            logger.info("addCustomer "+name+", "+phoneNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }

    @Override
    public CustomerList getAllCustomer() {
        Connection connection = hotelsysDao.connect();
        CustomerList customerList = new CustomerList();
        try {
            preparedStatement = connection.prepareStatement("select * from LAB3_EP_CUSTOMER");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                customerList.add(parseCustomer(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
        logger.info("getAllCustomers");
        return customerList;
    }

    @Override
    public Customer parseCustomer(ResultSet resultSet) throws SQLException {
        int customerid = resultSet.getInt("LAB3_EP_CUSTOMER_ID");
        String name = resultSet.getString("LAB3_EP_CUSTOMER_NAME");
        String phoneNumber = resultSet.getString("LAB3_EP_CUSTOMER_PHONE_NUMBER");
        Customer customer = new Customer(customerid, name, phoneNumber);
        logger.info("parseCustomer");
        return customer;
    }

    @Override
    public void updateCustomerPhone(int id, String phone) {
        Connection connection = hotelsysDao.connect();
        try {
            preparedStatement = connection.prepareStatement("update LAB3_EP_CUSTOMER set LAB3_EP_CUSTOMER_PHONE_NUMBER = ? where " +
                    "LAB3_EP_CUSTOMER_ID = ? ");
            preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            logger.info("updateCustomerPhone id:"+id+", phone:"+phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }


    @Override
    public void removeCustomer(int id) {
        Connection connection = hotelsysDao.connect();
        try {
            preparedStatement = connection.prepareStatement("delete from LAB3_EP_CUSTOMER where LAB3_EP_CUSTOMER_ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("removeCustomer" +id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }

}
