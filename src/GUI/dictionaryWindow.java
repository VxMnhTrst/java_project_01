package GUI;

import javax.swing.*;
import java.awt.*;

public class dictionaryWindow extends JFrame {
    private JTable dictTable;
    private static dictionaryWindow instance = null;
    public dictionaryWindow(String dictTitle, int width, int height) {
        this.setDefaultLookAndFeelDecorated(true);
        this.setTitle(dictTitle);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Kundan Kumar Jha", "4031", "CSE" }
        };
        String[] columnNames = { "Name", "Roll Number", "Department" };

        this.dictTable = new JTable(data,columnNames);

        this.setContentPane(dictTable);
        this.setMinimumSize(new Dimension(width, height));
        this.pack();
        this.setVisible(true);
    }
}
