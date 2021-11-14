package edu.xidian.ictt.gpf.reservation.clientgui.main;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import edu.xidian.ictt.gpf.reservation.ClientInterface;
import edu.xidian.ictt.gpf.reservation.clientgui.share.GlobalVar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelButton extends JButton {

    public CancelButton() {
        setText("Cancel");
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loop:
                while (true) {
                    String phoneNumebr = JOptionPane.showInputDialog(GlobalVar.mainFrame, "phone number:");
                    if (phoneNumebr == null) {
                        break;
                    }
                    switch (ClientInterface.cancel(phoneNumebr)) {
                        case 0:
                            JOptionPane.showMessageDialog(GlobalVar.mainFrame, "Phone number length error.", "cancel result", JOptionPane.ERROR_MESSAGE);
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(GlobalVar.mainFrame, "Phone number has no reservation.", "cancel result", JOptionPane.ERROR_MESSAGE);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(GlobalVar.mainFrame, "Success.", "cancel result", JOptionPane.INFORMATION_MESSAGE);
                            break loop;
                        default:
                            JOptionPane.showMessageDialog(GlobalVar.mainFrame, "Unknown error.", "cancel result", JOptionPane.ERROR_MESSAGE);
                            break;          
                    }
                }
            }
        });
    }

}
