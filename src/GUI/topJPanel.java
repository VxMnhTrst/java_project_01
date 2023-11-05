package GUI;

import Data.Processing;

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
    private HashMap<String,String[]> dictionary;
    public topJPanel() {
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

        Processing dataProcess = new Processing();
        this.dictionary = dataProcess.getDictionary();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.searchButton && this.dictionary != null)
        {
            String[] colNames = {"Word", "Definitions"};
            String[][] data = new String[this.dictionary.keySet().size()][2];

            int i = 0;
            for(String key : this.dictionary.keySet())
            {
                data[i][0] = key;
                data[i][1] = String.join(" | ",this.dictionary.get(key));
                i++;
            }
            dictionaryWindow dictTable = new dictionaryWindow("Dictionary",300,300,colNames,data);
        }
    }
}


