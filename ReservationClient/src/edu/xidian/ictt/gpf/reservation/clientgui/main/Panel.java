package edu.xidian.ictt.gpf.reservation.clientgui.main;

import javax.swing.JPanel;

public class Panel extends JPanel {

    public Panel() {
        add(new ReserveButton());
        add(new CancelButton());
    }

}
