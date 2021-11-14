package edu.xidian.ictt.gpf.reservation.clientgui.reverse;

import edu.xidian.ictt.gpf.reservation.clientgui.share.GlobalVar;
import javax.swing.JDialog;

public class Dialog extends JDialog {
    
    public Dialog() {
        super(GlobalVar.mainFrame, "ReverseDialog", true);
        setSize(300, 150);
        setContentPane(new Panel());
        setVisible(true); 
    }

}
