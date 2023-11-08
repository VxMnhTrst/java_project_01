package GUI;

import javax.swing.*;
import java.awt.*;

public class historyWindow extends JFrame {
    private JList historyList;
    public historyWindow(String  historyTitle, int width, int height, String[] searchHistory)
    {
        this.setDefaultLookAndFeelDecorated(true);
        this.setTitle(historyTitle);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel dictPanel = new JPanel();
        dictPanel.setLayout(new BoxLayout(dictPanel,BoxLayout.PAGE_AXIS));

        this.historyList = new JList(searchHistory);
        historyList.setFont(new Font("Consolas", Font.BOLD, 18));
        JScrollPane dictScroll = new JScrollPane(this.historyList);
        dictPanel.add(dictScroll);

        this.setContentPane(dictPanel);
        this.setMaximumSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));
        this.pack();
        this.setVisible(true);
    }
}
