package org.lan.UI.control;

import jakarta.annotation.Resource;
import org.lan.UI.dataList.BookedCustomer;
import org.lan.UI.dataList.CustomerTable;
import org.lan.UI.dataList.DataPanel;
import org.lan.UI.util.MyLayerManager;
import org.lan.pojo.Reservation;
import org.lan.service.CheckService;
import org.lan.service.InsertService;
import org.lan.service.SelectService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;

@Component("customerControl")
public class CustomerControl extends JPanel {
    @Resource(name = "checkService")
    public CheckService checkService;
    @Resource(name = "bookedCustomer")
    public BookedCustomer bookedCustomer;
    @Resource(name = "hotelControl")
    public HotelControl hotelControl;
    @Resource(name = "busControl")
    public BusControl busControl;
    @Resource(name = "flightControl")
    public FlightControl flightControl;
    @Resource(name = "selectedCustomer")
    public SelectedCustomer selectedCustomer;

    @Resource(name = "dataPanel")
    public DataPanel dataPanel;

    @Resource(name = "insertService")
    public InsertService insertService;

    @Resource(name = "customerTable")
    public CustomerTable customerTable;

    public Group customerName = new Group("customerName");
    public Group customerID = new Group("customerID");
    public JButton insertButton = new JButton("添加");
    public JButton deleteButton = new JButton("删除");
    public JButton chooseButton = new JButton("选择");

    public void init() {
        MyLayerManager myLayerManager = new MyLayerManager();
        setLayout(myLayerManager);
        add(customerName);
        add(customerID);
        add(insertButton);
        add(deleteButton);
        add(chooseButton);
        add(bookedCustomer);
        insertButton.addActionListener(e -> insert());
        deleteButton.addActionListener(e -> delete());
        chooseButton.addActionListener(e -> choose());
        up();
    }

    public void up() {
        String customerName = selectedCustomer.getCustomerName();
        List<List<String>> bookByCustomerName = checkService.getBookByCustomerName(customerName);
        bookedCustomer.setData(bookByCustomerName);
    }

    public void insert() {
        try {
            String name = customerName.get();
            String ID = customerID.get();
            if(name.equals("") | ID.equals("")){
                throw new Exception("不为空");
            }
            insertService.insertCustomer(name,ID);
            dataPanel.selectCustomer();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "不能为空\n输入不合法\n顾客名字已存在", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete() {
        try {
            String key = customerTable.getKey();
            insertService.deleteCustomer(key);
            dataPanel.selectCustomer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void choose() {
        try {
            String key = customerTable.getKey();
            selectedCustomer.setCustomerName(key);
            selectedCustomer.updateUI();
            flightControl.up();
            busControl.up();
            hotelControl.up();
            up();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
