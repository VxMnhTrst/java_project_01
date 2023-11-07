package GUI;

import javax.swing.*;

public class rightJPanel extends JPanel {
    public rightJPanel()
    {
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        JLabel historyLabel = new JLabel("Search History");
        String[] history = {"Word A", "Word B", "Word C", "Word D"};
        JList historyList = new JList(history);
        JScrollPane historySroll = new JScrollPane(historyList);

        this.add(historyLabel);
        this.add(historySroll);
    }
}
