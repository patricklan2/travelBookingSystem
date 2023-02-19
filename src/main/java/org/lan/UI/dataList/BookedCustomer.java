package org.lan.UI.dataList;

import org.lan.pojo.Bus;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

@Component("bookedCustomer")
public class BookedCustomer extends JPanel {
    public JTable jTable = new JTable();
    JScrollPane jScrollPane = new JScrollPane(jTable);
    DefaultTableModel tableModel;
    String[] names = {"目的地","飞机","旅馆","巴士"};

    public BookedCustomer(List<List<String>> reservationList) {
        super();
        setData(reservationList);
        jScrollPane.setPreferredSize(new Dimension(400,150));
        add(jScrollPane);
    }


    public BookedCustomer() {
        super();
        jScrollPane.setPreferredSize(new Dimension(400,150));
        add(jScrollPane);
    }

    public void setData(List<List<String>> reservationList) {
        tableModel = new DefaultTableModel(names, 0);
        for (List<String> reservation:reservationList) {
            tableModel.addRow(reservation.toArray());
        }
        jTable.setModel(tableModel);
    }
}
