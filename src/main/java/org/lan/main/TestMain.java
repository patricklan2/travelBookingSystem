package org.lan.main;

import org.lan.UI.control.Control;
import org.lan.UI.control.Group;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class TestMain {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(200,200,900,600);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");



        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
