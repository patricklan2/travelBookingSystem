package org.lan.UI.control;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component("selectedCustomer")
public class SelectedCustomer extends JPanel {

    JLabel jLabel = new JLabel("当前顾客:");

    JLabel customerName = new JLabel("未选择");

    public void init() {
        add(jLabel);
        add(customerName);
    }

    public String getCustomerName() {
        if (customerName.getText().equals("未选择")){
            return null;
        }
        return customerName.getText();
    }

    public void setCustomerName(String _customerName) {
        customerName.setText(_customerName);
    }

}
