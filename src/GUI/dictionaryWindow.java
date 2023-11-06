package GUI;

import javax.swing.*;
import java.awt.*;

public class dictionaryWindow extends JFrame {
    private JTable dictTable;
    public dictionaryWindow(String dictTitle, int width, int height, String[] colNames, String[][] data) {
        this.setDefaultLookAndFeelDecorated(true);
        this.setTitle(dictTitle);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel dictPanel = new JPanel();
        dictPanel.setLayout(new BoxLayout(dictPanel,BoxLayout.PAGE_AXIS));

        this.dictTable = new JTable(data,colNames);
        dictTable.setFont(new Font("Consolas", Font.BOLD, 18));
        dictTable.setRowHeight(dictTable.getRowHeight()+6);
        JScrollPane dictScroll = new JScrollPane(this.dictTable);
        dictPanel.add(dictScroll);

        this.setContentPane(dictPanel);
        this.setMaximumSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));
        this.pack();
        this.setVisible(true);
    }
}
