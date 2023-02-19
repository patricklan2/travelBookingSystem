package org.lan.UI.control;

import jakarta.annotation.Resource;
import org.lan.UI.dataList.DataPanel;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component("control")
public class Control extends JPanel {

    @Resource(name = "dataPanel")
    DataPanel dataPanel;
    JPanel selected = null;
    @Resource(name = "customerControl")
    CustomerControl customerControl;
    @Resource(name = "flightControl")
    FlightControl flightControl;
    @Resource(name = "busControl")
    BusControl busControl;
    @Resource(name = "hotelControl")
    HotelControl hotelControl;

    public Control() {
        super();
    }

    public void init(){
        customerControl.init();
        flightControl.init();
        busControl.init();
        hotelControl.init();
        customerControl.setPreferredSize(new Dimension(400,900));
        flightControl.setPreferredSize(new Dimension(400,900));
        busControl.setPreferredSize(new Dimension(400,900));
        hotelControl.setPreferredSize(new Dimension(400,900));
        selectCustomer();
    }

    public void selectCustomer() {
        if (selected != null) {
            remove(selected);
        }
        selected = customerControl;
        add(customerControl);
        updateUI();
    }

    public void selectFlight() {
        if (selected != null) {
            remove(selected);
        }
        selected = flightControl;
        add(flightControl);
        updateUI();
    }

    public void selectBus() {
        if (selected != null) {
            remove(selected);
        }
        selected = busControl;
        add(busControl);
        updateUI();
    }

    public void selectHotel() {
        if (selected != null) {
            remove(selected);
        }
        selected = hotelControl;
        add(hotelControl);
        updateUI();
    }
}
