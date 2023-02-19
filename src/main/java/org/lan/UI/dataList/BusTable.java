package org.lan.UI.dataList;

import org.lan.pojo.Bus;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

@Component("busTable")
public class BusTable extends JScrollPane {
    public JTable jTable = new JTable();
    DefaultTableModel tableModel;
    String[] names = {"location","price","number of bus","number of seat","number of avail"};

    public BusTable(List<Bus> buses) {
        super();
        setData(buses);
        setViewportView(jTable);
    }

    public BusTable() {
        super();
        setViewportView(jTable);
    }

    public void setData(List<Bus> buses) {
        tableModel = new DefaultTableModel(names, 0);
        for (Bus bus:buses) {
            tableModel.addRow(bus.toList());
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
