package edu.xidian.ictt.gpf.reservation.clientgui.main;

import javax.swing.JFrame;

import java.awt.FlowLayout;

public class Frame extends JFrame {
    
    public Frame() {
        setTitle("ReservationClient");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());
        setContentPane(new Panel());
        setVisible(true);
    }

}
