package org.lan.UI.dataList;

import org.lan.pojo.Hotel;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

@Component("bookedHotel")
public class BookedHotel extends JPanel {
    public JTable jTable = new JTable();
    JScrollPane jScrollPane = new JScrollPane(jTable);
    DefaultTableModel tableModel;
    String[] names = {"location"};

    public BookedHotel(List<Hotel> hotels) {
        super();
        setData(hotels);
        jScrollPane.setPreferredSize(new Dimension(400,150));
        add(jScrollPane);
    }

    public BookedHotel() {
        super();
        jScrollPane.setPreferredSize(new Dimension(400,150));
        add(jScrollPane);
    }

    public void setData(List<Hotel> hotels) {
        tableModel = new DefaultTableModel(names, 0);
        for (Hotel hotel:hotels) {
            tableModel.addRow(trans(hotel));
        }
        jTable.setModel(tableModel);
    }

    private String[] trans(Hotel hotel) {
        String[] strings = new String[1];
        String[] strings1 = hotel.toList();
        strings[0] = strings1[0];
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
