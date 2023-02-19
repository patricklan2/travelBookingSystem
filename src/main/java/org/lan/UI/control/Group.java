package org.lan.UI.control;

import javax.swing.*;

public class Group extends JPanel {
    JLabel jLabel;

    JTextField jTextField;

    public Group(String name){
        jLabel = new JLabel(name);
        jTextField = new JTextField(15);
        this.add(jLabel);
        this.add(jTextField);
    }

    public String get() {
        return jTextField.getText();
    }
}
