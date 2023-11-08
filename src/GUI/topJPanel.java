package GUI;

import Data.dataBase;
import FunctionalHandling.dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class topJPanel extends JPanel implements ActionListener {
    private JLabel searchBarLabel;
    private JTextField searchBar;
    private String[] searchChoices;
    private JComboBox searchChoicesList;
    private JButton searchButton;
    private dictionary searchFunctional;
    private dataBase userDataBase;
    public topJPanel(dataBase userDataBase) {
        this.searchBarLabel = new JLabel(
                "Keyword");
        this.searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(500,25));
        searchBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.searchChoices = new String[]{"Word", "Definition"};
        this.searchChoicesList = new JComboBox(searchChoices);
        this.searchButton = new JButton("Search");
        this.searchButton.addActionListener(this);

        this.add(this.searchBarLabel);
        this.add(this.searchBar);
        this.add(this.searchChoicesList);
        this.add(this.searchButton);

        this.searchFunctional = new dictionary();
        this.userDataBase = userDataBase;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.searchButton)
        {
            String[] colNames = {"Word", "Definitions"};
            String[][] data;
            String search = this.searchBar.getText();
            if(this.searchChoicesList.getSelectedItem().equals("Word"))
            {
                this.userDataBase.addingSearchHistory(search);
                data = searchFunctional.searchWord(this.userDataBase,search);
            }else{
                data = searchFunctional.searchDef(this.userDataBase,search);
            }
            dictionaryWindow dictTable = new dictionaryWindow("Dictionary",900,600,colNames,data);
        }
    }
}