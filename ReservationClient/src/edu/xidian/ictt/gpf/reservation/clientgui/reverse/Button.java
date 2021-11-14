package edu.xidian.ictt.gpf.reservation.clientgui.reverse;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import edu.xidian.ictt.gpf.reservation.ClientInterface;
import edu.xidian.ictt.gpf.reservation.clientgui.share.GlobalVar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {

    public Button() {
        setText("submit");
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean tomorrow = GlobalVar.dateComboBox.getSelectedIndex() == 0;
                boolean internal = GlobalVar.departmentComboBox.getSelectedIndex() == 0;
                if (ClientInterface.checkAvailable(tomorrow, internal)) {
                    while (true) {
                        String phoneNumber = JOptionPane.showInputDialog(GlobalVar.reverseDialog, "phone number:");
                        if (phoneNumber == null) {
                            break;
                        }
                        if (ClientInterface.checkPhoneNumber(tomorrow, internal, phoneNumber)) {
                            JOptionPane.showMessageDialog(GlobalVar.reverseDialog, "success.", "reverse result",
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;
                        } else {
                            JOptionPane.showMessageDialog(GlobalVar.reverseDialog,
                                    "Fail.\nPhone number length is not 11 or this phone number has been used to reserve.",
                                    "reverse result", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(GlobalVar.reverseDialog, "Fail.\nThere is no reservations.",
                            "reverse result", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
