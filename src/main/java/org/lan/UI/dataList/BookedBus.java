package org.lan.UI.dataList;

import org.lan.pojo.Bus;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

@Component("bookedBus")
public class BookedBus extends JPanel {
    public JTable jTable = new JTable();
    JScrollPane jScrollPane = new JScrollPane(jTable);
    DefaultTableModel tableModel;
    String[] names = {"location","number of bus"};

    public BookedBus(List<Bus> buses) {
        super();
        setData(buses);
        jScrollPane.setPreferredSize(new Dimension(400,150));
        add(jScrollPane);
    }


    public BookedBus() {
        super();
        jScrollPane.setPreferredSize(new Dimension(400,150));
        add(jScrollPane);
    }

    public void setData(List<Bus> buses) {
        tableModel = new DefaultTableModel(names, 0);
        for (Bus bus:buses) {
            tableModel.addRow(trans(bus));
        }
        jTable.setModel(tableModel);
    }

    private String[] trans(Bus bus) {
        String[] strings = new String[2];
        String[] strings1 = bus.toList();
        strings[0] = strings1[0];
        strings[1] = strings1[2];
        return strings;
    }

    public String getKey() throws Exception {
        int selectedRow = jTable.getSelectedRow();
        if(selectedRow == -1){
            throw new Exception("未选择要取消的预约");
        }
        return (String) jTable.getValueAt(selectedRow, 0);
    }
}
