package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import java.util.ArrayList;

public class CustomerList {

    public CustomerList() {
        this.customers = new ArrayList<Customer>();
    }

    ArrayList<Customer> customers;

    public void add(Customer parseCustomer) {
        customers.add(parseCustomer);
    }

    public ArrayList<Customer> getArr(){
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

}
