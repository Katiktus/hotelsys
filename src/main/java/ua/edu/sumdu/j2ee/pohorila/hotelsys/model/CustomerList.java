package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "CustomerList{" +
                "customers=" + customers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerList that = (CustomerList) o;
        return Objects.equals(customers, that.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers);
    }
}
