package org.lan.UI.dataList;

import org.lan.pojo.Customer;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

@Component("customerTable")
public class CustomerTable extends JScrollPane {

    public JTable jTable = new JTable();
    DefaultTableModel tableModel;
    String[] names = {"customerName","customerID"};

    public CustomerTable(List<Customer> customers) {
        super();
        setData(customers);
        setViewportView(jTable);
    }

    public CustomerTable() {
        super();
        setViewportView(jTable);
    }

    public void setData(List<Customer> customers) {
        tableModel = new DefaultTableModel(names, 0);
        for (Customer customer : customers) {
            tableModel.addRow(customer.toList());
        }
        jTable.setModel(tableModel);
    }

    public String getKey() throws Exception {
        int selectedRow = jTable.getSelectedRow();
        if(selectedRow == -1) {
            throw new Exception("未选择顾客");
        }
        return (String) jTable.getValueAt(selectedRow,0);
    }
}
