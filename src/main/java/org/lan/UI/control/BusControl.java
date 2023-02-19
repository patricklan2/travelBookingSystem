package org.lan.UI.control;

import jakarta.annotation.Resource;
import org.lan.UI.dataList.BookedBus;
import org.lan.UI.dataList.BusTable;
import org.lan.UI.dataList.DataPanel;
import org.lan.UI.util.MyLayerManager;
import org.lan.pojo.Bus;
import org.lan.pojo.Reservation;
import org.lan.service.BookService;
import org.lan.service.InsertService;
import org.lan.service.SelectService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;

@Component("busControl")
public class BusControl extends  JPanel{
    @Resource(name = "selectService")
    SelectService selectService;
    @Resource(name = "bookedBus")
    public BookedBus bookedBus;
    @Resource(name = "bookService")
    public BookService bookService;
    @Resource(name = "selectedCustomer")
    public SelectedCustomer selectedCustomer;
    @Resource(name = "dataPanel")
    public DataPanel dataPanel;
    @Resource(name = "busTable")
    public BusTable busTable;
    @Resource(name = "insertService")
    public InsertService insertService;
    public Group location = new Group("location");
    public Group price = new Group("price");
    public Group num_of_bus = new Group("num of bus");
    public Group num_of_seats = new Group("num of seats");
    public JButton insertButton = new JButton("添加");
    public JButton deleteButton = new JButton("删除");
    public JButton bookButton = new JButton("预约");
    public JButton cancelButton = new JButton("取消预约");


    public void init() {
        MyLayerManager myLayerManager = new MyLayerManager();
        setLayout(myLayerManager);
        add(location);
        add(price);
        add(num_of_bus);
        add(num_of_seats);
        add(insertButton);
        add(deleteButton);
        add(bookButton);
        add(bookedBus);
        add(cancelButton);
        insertButton.addActionListener(e -> insert());
        deleteButton.addActionListener(e -> delete());
        bookButton.addActionListener(e -> book());
        cancelButton.addActionListener(e -> cancel());
        up();
    }
    public void insert() {
        try {
            String _location = location.get();
            Integer _price = Integer.valueOf(price.get());
            Integer _num_of_bus = Integer.valueOf(num_of_bus.get());
            Integer _num_of_seats = Integer.valueOf(num_of_seats.get());
            if(_location.equals("")){
                throw new Exception("不为空");
            }
            insertService.insertBus(_location,_price,_num_of_bus,_num_of_seats);
            dataPanel.selectBus();
        }catch (Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "不能为空\n输入不合法\nlocation已存在", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete() {
        try {
            String key = busTable.getKey();
            insertService.deleteBus(key);
            dataPanel.selectBus();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void book(){
        try {
            String key = busTable.getKey();
            bookService.bookBus(selectedCustomer.getCustomerName(), key);
            dataPanel.selectBus();
            up();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void up() {
        String customerName = selectedCustomer.getCustomerName();
        final List<Bus> buses = selectService.selectBusByCustomer(customerName);
        bookedBus.setData(buses);
    }

    public void cancel() {
        try {
            String key = bookedBus.getKey();
            String customerName = selectedCustomer.getCustomerName();
            List<Reservation> reservations = selectService.selectOne(customerName, 3, key);
            Reservation reservation = reservations.get(0);
            bookService.cancelByKey(reservation);
            up();
            dataPanel.selectBus();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
