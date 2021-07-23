package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Customer;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.CustomerList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerDao {
    CustomerDao instance = new CustomerDaoImpl();

    static CustomerDao getInstance(){
        return instance;
    }

    void addCustomer(String name, String phoneNumber);
    CustomerList getAllCustomer();
    void updateCustomerPhone(int id, String phone);
    void removeCustomer(int id);
    Customer parseCustomer(ResultSet resultSet) throws SQLException;

}
