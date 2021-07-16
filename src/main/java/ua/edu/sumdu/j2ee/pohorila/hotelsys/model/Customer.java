package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

public class Customer {
    int customerId;
    String name;
    String phoneNumber;

    public Customer(int customerId, String name, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(name, customer.name) && Objects.equals(phoneNumber, customer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, phoneNumber);
    }

    public static Comparator<Customer> idComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            int first = o1.getCustomerId();
            int second = o2.getCustomerId();
            return first- second;
        }
    };

    public static Comparator<Customer> nameComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            String first = o1.getName().toUpperCase(Locale.ROOT);
            String second = o2.getName().toUpperCase(Locale.ROOT);
            return first.compareTo(second);
        }
    };

    public static Comparator<Customer> phoneComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            String first = o1.getPhoneNumber().toUpperCase(Locale.ROOT);
            String second = o2.getPhoneNumber().toUpperCase(Locale.ROOT);
            return first.compareTo(second);
        }
    };
}
