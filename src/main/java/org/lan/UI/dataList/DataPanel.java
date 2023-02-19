package org.lan.UI.dataList;

import jakarta.annotation.Resource;
import org.lan.pojo.Bus;
import org.lan.pojo.Customer;
import org.lan.pojo.Flight;
import org.lan.pojo.Hotel;
import org.lan.service.SelectService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;
@Component("dataPanel")
public class DataPanel extends JPanel {

    @Resource(name = "selectService")
    public SelectService selectService;

    @Resource(name = "customerTable")
    private CustomerTable customerTable;

    @Resource(name = "flightTable")
    private FlightTable flightTable;

    @Resource(name = "busTable")
    private BusTable busTable;

    @Resource(name = "hotelTable")
    private HotelTable hotelTable;

    private JScrollPane selected = null;

    public DataPanel() {
        super();
    }

    public void init() {
        selectCustomer();
//        selectFlight();
    }


    public void selectCustomer() {
        List<Customer> customers = selectService.selectAllCustomer();
        customerTable.setData(customers);
        if (selected != null) {
            remove(selected);
        }
        selected = customerTable;
        add(customerTable);
        updateUI();
    }

    public void selectFlight() {
        List<Flight> flights = selectService.selectAllFlight();
        flightTable.setData(flights);
        if (selected != null) {
            remove(selected);
        }
        selected = flightTable;
        add(flightTable);
        updateUI();
    }

    public void selectBus() {
        List<Bus> buses = selectService.selectAllBus();
        busTable.setData(buses);
        if (selected != null) {
            remove(selected);
        }
        selected = busTable;
        add(busTable);
        updateUI();
    }

    public void selectHotel() {
        final List<Hotel> hotels = selectService.selectAllHotel();
        hotelTable.setData(hotels);
        if (selected != null) {
            remove(selected);
        }
        selected = hotelTable;
        add(hotelTable);
        updateUI();
    }
}
