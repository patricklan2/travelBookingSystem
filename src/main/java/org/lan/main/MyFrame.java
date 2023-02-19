package org.lan.main;

import jakarta.annotation.Resource;
import org.lan.UI.control.Control;
import org.lan.UI.control.SelectedCustomer;
import org.lan.UI.dataList.DataPanel;
import org.lan.UI.menu.Menu;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component("frame")
public class MyFrame extends JFrame {
    @Resource(name = "selectedCustomer")
    SelectedCustomer selectedCustomer;

    @Resource(name = "dataPanel")
    public DataPanel dataPanel;

    @Resource(name = "menu")
    public Menu menu;

    @Resource(name = "control")
    public Control control;

    public MyFrame() {
        super("travel booking system");
        this.setBounds(100,100,900,600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void init() {
        dataPanel.init();
        control.init();
        menu.init();
        selectedCustomer.init();
        add(dataPanel,BorderLayout.WEST);
        add(menu,BorderLayout.NORTH);
        add(control,BorderLayout.EAST);
        add(selectedCustomer,BorderLayout.SOUTH);
    }
}
