package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class dictionaryWindow extends JFrame {
    private JTable dictTable;
    private static dictionaryWindow instance = null;
    private dictionaryWindow(String dictTitle,int width, int height) {
        this.setDefaultLookAndFeelDecorated(true);
        this.setTitle(dictTitle);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },

        };
        String[] columnNames = { "Name", "Roll Number", "Department" };

        this.dictTable = new JTable(data,columnNames);

        this.setContentPane(dictTable);
        this.setMinimumSize(new Dimension(width, height));
        this.pack();
        this.setVisible(true);
    }
    private dictionaryWindow() {
    }
    public static dictionaryWindow getInstance(String dictTitle,int width, int height) {
        if(instance == null) {
            instance = new dictionaryWindow(dictTitle,width,height);
        }else {
            instance = resetInstance(dictTitle,width,height);
        }
        return instance;
    }
    public static dictionaryWindow resetInstance(String dictTitle,int width, int height)
    {
        return new dictionaryWindow(dictTitle,width,height);
    }
}
