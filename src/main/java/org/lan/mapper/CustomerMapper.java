package org.lan.mapper;

import java.util.List;
import org.lan.pojo.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(String customerName);

    int insert(Customer row);

    Customer selectByPrimaryKey(String customerName);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer row);
}