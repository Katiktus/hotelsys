package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.dao.CustomerDao;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.CustomerList;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    public CustomerDao customerDao;
    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public void addCustomer(String name, String phoneNumber) {
        logger.info("addCustomer: "+name+", "+phoneNumber);
        customerDao.addCustomer(name, phoneNumber);
    }

    @Override
    public CustomerList getAllCustomer() {
        logger.info("getAllCustomers");
        return customerDao.getAllCustomer();
    }

    @Override
    public void updateCustomerPhone(int id, String phone) {
        logger.info("updateCustomerPhone id:"+id+", phone:"+phone);
        customerDao.updateCustomerPhone(id, phone);
    }

    @Override
    public void removeCustomer(int id) {
        logger.info("removeCustomer" +id);
        customerDao.removeCustomer(id);
    }
}
