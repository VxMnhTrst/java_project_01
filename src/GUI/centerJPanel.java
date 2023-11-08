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
    private JLabel noti;
    private JComboBox dupChoiceList;
    private JButton dupSubmitButton;
    private JPanel dupNotiPanel;
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


        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(centerPanelButton,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(Box.createRigidArea(new Dimension(0,15)),gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        this.noti = new JLabel("Dictionary operation");
        noti.setFont(new Font("Consolas",Font.PLAIN,20));
        this.add(this.noti,gbc);

        this.dupNotiPanel = new JPanel();
        this.dupNotiPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel dupLabel = new JLabel("Adding new slang duplicate?");
        this.dupChoiceList = new JComboBox<>(new String[]{"Yes", "No"});
        this.dupSubmitButton = new JButton("Submit");

        this.dupNotiPanel.add(dupLabel);
        this.dupNotiPanel.add(this.dupChoiceList);
        this.dupNotiPanel.add(this.dupSubmitButton);

        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(this.dupNotiPanel,gbc);
        this.dupNotiPanel.setVisible(false);

        this.addButton.addActionListener(this);
        this.editButton.addActionListener(this);
        this.deleteButton.addActionListener(this);
        this.resetButton.addActionListener(this);
        this.dupSubmitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.resetButton)
        {
            String resetResult = userDictOperate.resetUSerDictionary();
            this.noti.setText(resetResult);
        }

        if(e.getSource() == this.editButton)
        {
            String editSlang = this.wordFormBar.getText();
            String editDef = this.defFormBar.getText();

            String editResult = userDictOperate.editSlang(editSlang,editDef);
            if(editResult.contains("not"))
            {
                this.noti.setForeground(Color.RED);
            }else{
                this.noti.setForeground(Color.BLACK);
            }
            this.noti.setText(editResult);
        }

        if(e.getSource() == this.deleteButton)
        {
            String deleteSlang = this.wordFormBar.getText();

            String resultDelete = userDictOperate.deleteSlang(deleteSlang);
            if(resultDelete.contains("not"))
            {
                this.noti.setForeground(Color.RED);
            }else{
                this.noti.setForeground(Color.BLACK);
            }
            this.noti.setText(resultDelete);
        }

        if(e.getSource() == this.addButton)
        {
            String newSlang = this.wordFormBar.getText();
            String newDef = this.defFormBar.getText();

            String addResult = userDictOperate.addSlang(newSlang,newDef,false);
            if(addResult.contains("existed"))
            {
                this.dupNotiPanel.setVisible(true);
            }
            this.noti.setForeground(Color.BLACK);
            this.noti.setText(addResult);
        }
        if(e.getSource() == this.dupSubmitButton)
        {
            this.dupNotiPanel.setVisible(false);
            String dupChoice = String.valueOf(this.dupChoiceList.getSelectedItem());
            if(dupChoice.equals("Yes"))
            {
                String newSlang = this.wordFormBar.getText();
                String newDef = this.defFormBar.getText();

                String addResult = this.userDictOperate.addSlang(newSlang,newDef,true);
                this.noti.setForeground(Color.BLACK);
                this.noti.setText(addResult);
            }
        }
    }
}
