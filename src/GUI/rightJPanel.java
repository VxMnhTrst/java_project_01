package GUI;

import Data.dataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rightJPanel extends JPanel implements ActionListener {
    private JButton historyButton;
    private dataBase userDataBase;
    public rightJPanel(dataBase userDataBase)
    {
        this.userDataBase = userDataBase;

        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        JLabel historyLabel = new JLabel("Search History");
        this.historyButton = new JButton("View history");

        this.add(historyLabel);
        this.add(historyButton);


        this.historyButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.historyButton)
        {
            this.userDataBase.saveHSearchHistory();
            historyWindow historyList = new historyWindow("Search history",200,
                    200,this.userDataBase.getSearchHistory());
        }
    }
}
