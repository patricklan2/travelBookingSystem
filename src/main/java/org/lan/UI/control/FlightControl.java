package org.lan.UI.control;

import jakarta.annotation.Resource;
import org.lan.UI.dataList.BookedFlight;
import org.lan.UI.dataList.DataPanel;
import org.lan.UI.dataList.FlightTable;
import org.lan.UI.util.MyLayerManager;
import org.lan.pojo.Flight;
import org.lan.pojo.Reservation;
import org.lan.service.BookService;
import org.lan.service.InsertService;
import org.lan.service.SelectService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;

@Component("flightControl")
public class FlightControl extends JPanel {
    @Resource(name = "selectService")
    SelectService selectService;
    @Resource(name = "bookedFlight")
    public BookedFlight bookedFlight;
    @Resource(name = "bookService")
    public BookService bookService;
    @Resource(name = "selectedCustomer")
    public SelectedCustomer selectedCustomer;
    @Resource(name = "flightTable")
    public FlightTable flightTable;
    @Resource(name = "dataPanel")
    public DataPanel dataPanel;
    @Resource(name = "insertService")
    InsertService insertService;
    public Group flight_num = new Group("flight number");
    public Group price = new Group("price");
    public Group number_seats = new Group("number of seats");
    public Group from_city = new Group("from city");
    public Group to_city = new Group("to city");
    public Group time = new Group("time");
    public JButton insertButton = new JButton("插入");
    public JButton deleteButton = new JButton("删除");
    public JButton bookButton = new JButton("预约");
    public JButton cancelButton = new JButton("取消预约");

    public void init() {
        MyLayerManager myLayerManager = new MyLayerManager();
        setLayout(myLayerManager);
        add(flight_num);
        add(price);
        add(number_seats);
        add(from_city);
        add(to_city);
        add(time);
        add(insertButton);
        add(deleteButton);
        add(bookButton);
        add(bookedFlight);
        add(cancelButton);
        insertButton.addActionListener(e -> insert());
        deleteButton.addActionListener(e -> delete());
        bookButton.addActionListener(e -> book());
        cancelButton.addActionListener(e -> cancel());
        up();
    }

    public void insert() {
        try {
            String _flight_num = flight_num.get();
            Integer _price = Integer.valueOf(price.get());
            Integer _number_seat = Integer.valueOf(number_seats.get());
            String _from_city = from_city.get();
            String _to_city = to_city.get();
            String _time = time.get();
            if(_flight_num.equals("") | _from_city.equals("") | _to_city.equals("") | _time.equals("")){
                throw new Exception("不为空");
            }
            insertService.insertFlight(_flight_num,_price,_number_seat,_from_city,_to_city,_time);
            dataPanel.selectFlight();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "不能为空\n或者输入不合法\n编号已存在", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete() {
        try {
            String key  = flightTable.getKey();
            insertService.deleteFlight(key);
            dataPanel.selectFlight();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void book(){
        try {
            String key = flightTable.getKey();
            bookService.bookFlight(selectedCustomer.getCustomerName(), key);
            dataPanel.selectFlight();
            up();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void up(){
        String customerName = selectedCustomer.getCustomerName();
        List<Flight> flights = selectService.selectFlightByCustomer(customerName);
        bookedFlight.setData(flights);
    }

    public void cancel() {
        try {
            String key = bookedFlight.getKey();
            final String customerName = selectedCustomer.getCustomerName();
            List<Reservation> reservations = selectService.selectOne(customerName, 1, key);
            Reservation reservation = reservations.get(0);
            bookService.cancelByKey(reservation);
            up();
            dataPanel.selectFlight();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
