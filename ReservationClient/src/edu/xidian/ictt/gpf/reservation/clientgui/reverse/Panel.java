package edu.xidian.ictt.gpf.reservation.clientgui.reverse;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.xidian.ictt.gpf.reservation.clientgui.share.GlobalVar;

import javax.swing.JComboBox;

public class Panel extends JPanel {
    
    public Panel() {
        String[] dateList = {"tomorrow", "the day after tomorrow"};
        GlobalVar.dateComboBox = new JComboBox<String>(dateList);
        add(new JLabel("date:"));
        add(GlobalVar.dateComboBox);

        String[] departmentList = {"internal medicine", "surgery"};
        GlobalVar.departmentComboBox = new JComboBox<String>(departmentList);
        add(new JLabel("department:"));
        add(GlobalVar.departmentComboBox);
        
        add(new Button());
    }

}
