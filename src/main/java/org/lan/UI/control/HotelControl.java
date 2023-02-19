package org.lan.UI.control;

import jakarta.annotation.Resource;
import org.lan.UI.dataList.BookedHotel;
import org.lan.UI.dataList.DataPanel;
import org.lan.UI.dataList.HotelTable;
import org.lan.UI.util.MyLayerManager;
import org.lan.pojo.Hotel;
import org.lan.pojo.Reservation;
import org.lan.service.BookService;
import org.lan.service.InsertService;
import org.lan.service.SelectService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;

@Component("hotelControl")
public class HotelControl extends JPanel {
    @Resource(name = "selectService")
    SelectService selectService;
    @Resource(name = "bookedHotel")
    public BookedHotel bookedHotel;
    @Resource(name = "bookService")
    public BookService bookService;
    @Resource(name = "selectedCustomer")
    public SelectedCustomer selectedCustomer;
    @Resource(name = "hotelTable")
    public HotelTable hotelTable;
    @Resource(name = "dataPanel")
    public DataPanel dataPanel;
    @Resource(name = "insertService")
    public InsertService insertService;
    public Group location = new Group("location");
    public Group price = new Group("price");
    public Group num_of_rooms = new Group("num of rooms");
    public JButton insertButton = new JButton("添加");
    public JButton deleteButton = new JButton("删除");
    public JButton bookButton = new JButton("预约");
    public JButton cancelButton = new JButton("取消预约");


    public void init() {
        MyLayerManager myLayerManager = new MyLayerManager();
        setLayout(myLayerManager);
        add(location);
        add(price);
        add(num_of_rooms);
        add(insertButton);
        add(deleteButton);
        add(bookButton);
        add(bookedHotel);
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
            Integer _num_of_rooms = Integer.valueOf(num_of_rooms.get());
            if(_location.equals("")){
                throw new Exception("不为空");
            }
            insertService.insertHotel(_location,_price,_num_of_rooms);
            dataPanel.selectHotel();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "不能为空\n输入不合法\nlocation已存在", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete() {
        try {
            String key = hotelTable.getKey();
            insertService.deleteHotel(key);
            dataPanel.selectHotel();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void book() {
        try {
            String key = hotelTable.getKey();
            bookService.bookHotel(selectedCustomer.getCustomerName(), key);
            dataPanel.selectHotel();
            up();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void up() {
        String customerName = selectedCustomer.getCustomerName();
        List<Hotel> hotels = selectService.selectHotelByCustomerName(customerName);
        bookedHotel.setData(hotels);
    }

    public void cancel() {
        try {
            String key = bookedHotel.getKey();
            String customerName = selectedCustomer.getCustomerName();
            List<Reservation> reservations = selectService.selectOne(customerName, 2, key);
            Reservation reservation = reservations.get(0);
            bookService.cancelByKey(reservation);
            up();
            dataPanel.selectHotel();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
