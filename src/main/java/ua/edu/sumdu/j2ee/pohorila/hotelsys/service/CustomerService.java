package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.CustomerList;

@Service
public interface CustomerService {
    CustomerService instance = new CustomerServiceImpl();

    void addCustomer(String name, String phoneNumber);
    CustomerList getAllCustomer();
    void updateCustomerPhone(int id, String phone);
    void removeCustomer(int id);
}
