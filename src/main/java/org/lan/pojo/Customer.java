package org.lan.pojo;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;

    private String customerId;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }

    public String[] toList() {
        String[] strings = new String[2];
        strings[0] = customerName;
        strings[1] = customerId;
        return strings;
    }

    public Customer(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }
}