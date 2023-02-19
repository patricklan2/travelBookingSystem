package org.lan.UI.dataList;

import org.lan.pojo.Hotel;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

@Component("hotelTable")
public class HotelTable extends JScrollPane {
    public JTable jTable = new JTable();
    DefaultTableModel tableModel;
    String[] names = {"location","price","number of rooms","number of avail"};

    public HotelTable(List<Hotel> hotels) {
        super();
        setData(hotels);
        setViewportView(jTable);
    }

    public HotelTable() {
        super();
        setViewportView(jTable);
    }

    public void setData(List<Hotel> hotels) {
        tableModel = new DefaultTableModel(names, 0);
        for (Hotel hotel:hotels) {
            tableModel.addRow(hotel.toList());
        }
        jTable.setModel(tableModel);
    }

    public String getKey() throws Exception {
        int selectedRow = jTable.getSelectedRow();
        if(selectedRow == -1) {
            throw new Exception("未选择预约");
        }
        return (String) jTable.getValueAt(selectedRow, 0);
    }
}
