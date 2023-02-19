package org.lan.main;

import org.lan.UI.dataList.DataPanel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        MyFrame frame = applicationContext.getBean("frame", MyFrame.class);
        frame.init();
        frame.setVisible(true);
    }
}
