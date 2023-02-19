package org.lan.UI.dataList;

import org.lan.pojo.Flight;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import java.util.List;

@Component("flightTable")
public class FlightTable extends JScrollPane {
    public JTable jTable = new JTable();
    DefaultTableModel tableModel;
    String[] names = {"flight number","price","number of seats","number for arrive","from city","to city","time"};

    public FlightTable(List<Flight> flights) {
        super();
        setData(flights);
        setViewportView(jTable);
    }


    public FlightTable() {
        super();
        setViewportView(jTable);
    }

    public void setData(List<Flight> flights) {
        tableModel = new DefaultTableModel(names, 0);
        for (Flight flight:flights) {
            tableModel.addRow(flight.toList());
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
