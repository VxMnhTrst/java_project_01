package GUI;

import Data.dataBase;
import FunctionalHandling.dictOperate;
import Utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class centerJPanel extends JPanel implements ActionListener {
    private JTextField wordFormBar;
    private JTextField defFormBar;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton resetButton;
    private dictOperate userDictOperate;
    private dataBase userDataBase;
    public centerJPanel(dataBase userDataBase)
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel wordFormLabel = new JLabel("Word:");
        this.wordFormBar = new JTextField();
        this.wordFormBar.setPreferredSize(new Dimension(300,25));

        JLabel defFormLabel = new JLabel("Definition:");
        this.defFormBar = new JTextField();
        this.defFormBar.setPreferredSize(new Dimension(300,25));


        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(wordFormLabel,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(wordFormBar,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(defFormLabel,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(defFormBar,gbc);

        JPanel centerPanelButton = new JPanel();
        centerPanelButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.addButton = new JButton("Add new word");
        this.editButton = new JButton("Edit existing word");
        this.deleteButton = new JButton("Delete existing word");
        this.resetButton = new JButton("Reset dictionary");
        this.userDictOperate = new dictOperate(userDataBase);
        this.userDataBase = userDataBase;

        centerPanelButton.add(this.addButton);
        centerPanelButton.add(this.editButton);
        centerPanelButton.add(this.deleteButton);
        centerPanelButton.add(this.resetButton);

        this.addButton.addActionListener(this);
        this.editButton.addActionListener(this);
        this.deleteButton.addActionListener(this);
        this.resetButton.addActionListener(this);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(centerPanelButton,gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.resetButton)
        {
            userDictOperate.resetUSerDictionary();
        }
        if(e.getSource() == this.addButton)
        {
            String newSlang = this.wordFormBar.getText();
            String newDef = this.defFormBar.getText();
            //adding new slang
        }
        if(e.getSource() == this.editButton)
        {
            String editSlang = this.wordFormBar.getText();
            String editDef = this.defFormBar.getText();

            String editResult = userDictOperate.editSlang(editSlang,editDef);
        }
        if(e.getSource() == this.deleteButton)
        {
            String deleteSlang = this.wordFormBar.getText();

            String result = userDictOperate.deleteSlang(deleteSlang);
        }
    }
}
