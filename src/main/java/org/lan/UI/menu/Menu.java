package org.lan.UI.menu;

import jakarta.annotation.Resource;
import org.lan.UI.control.Control;
import org.lan.UI.control.CustomerControl;
import org.lan.UI.dataList.DataPanel;
import org.lan.UI.util.MouseClick;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.MouseEvent;

@Component("menu")
public class Menu extends JMenuBar {
    @Resource(name = "customerControl")
    public CustomerControl customerControl;
    @Resource(name = "dataPanel")
    public DataPanel dataPanel;
    @Resource(name = "control")
    public Control control;

    JMenu jMenu1 = new JMenu("顾客");
    JMenu jMenu2 = new JMenu("飞机");

    JMenu jMenu3 = new JMenu("巴士");
    JMenu jMenu4 = new JMenu("旅馆");

    public void init() {
        add(jMenu1);
        add(jMenu2);
        add(jMenu3);
        add(jMenu4);

        jMenu1.addMouseListener(new MouseClick() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dataPanel.selectCustomer();
                control.selectCustomer();
                customerControl.up();
            }
        });
        jMenu2.addMouseListener(new MouseClick() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dataPanel.selectFlight();
                control.selectFlight();
            }
        });
        jMenu3.addMouseListener(new MouseClick() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dataPanel.selectBus();
                control.selectBus();
            }
        });
        jMenu4.addMouseListener(new MouseClick() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dataPanel.selectHotel();
                control.selectHotel();
            }
        });
    }

}
