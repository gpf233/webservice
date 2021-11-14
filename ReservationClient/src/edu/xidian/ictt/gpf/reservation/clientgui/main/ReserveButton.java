package edu.xidian.ictt.gpf.reservation.clientgui.main;

import javax.swing.JButton;

import edu.xidian.ictt.gpf.reservation.clientgui.reverse.Dialog;
import edu.xidian.ictt.gpf.reservation.clientgui.share.GlobalVar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReserveButton extends JButton {

    public ReserveButton() {
        setText("Reserve");
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GlobalVar.cancleDialog = new Dialog();
            }
        });
    }

}
