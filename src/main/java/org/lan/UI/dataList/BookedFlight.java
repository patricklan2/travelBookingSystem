package org.lan.UI.dataList;

import org.lan.pojo.Flight;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

@Component("bookedFlight")
public class BookedFlight extends JPanel {
    public JTable jTable = new JTable();
    JScrollPane jScrollPane = new JScrollPane(jTable);
    DefaultTableModel tableModel;
    String[] names = {"flight number","from city","to city","time"};

    public BookedFlight(List<Flight> flights) {
        super();
        setData(flights);
        jScrollPane.setPreferredSize(new Dimension(400,150));
        add(jScrollPane);
    }


    public BookedFlight() {
        super();
        jScrollPane.setPreferredSize(new Dimension(400,150));
        add(jScrollPane);
    }

    public void setData(List<Flight> flights) {
        tableModel = new DefaultTableModel(names, 0);
        for (Flight flight:flights) {
            tableModel.addRow(trans(flight));
        }
        jTable.setModel(tableModel);
    }

    public String getKey() throws Exception {
        int selectedRow = jTable.getSelectedRow();
        if(selectedRow == -1){
            throw new Exception("未选择要取消的预约");
        }
        return (String) jTable.getValueAt(selectedRow, 0);
    }

    public String[] trans(Flight flight) {
        String[] strings = new String[4];
        String[] strings1 = flight.toList();
        strings[0] = strings1[0];
        strings[1] = strings1[4];
        strings[2] = strings1[5];
        strings[3] = strings1[6];
        return strings;
    }
}
