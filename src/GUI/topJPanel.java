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

    public String[][] searchWord()
    {
        String[][] data = new String[this.dictionary.keySet().size()][2];

        String searchKey = this.searchBar.getText();
        if(this.dictionary.containsKey(searchKey))
        {
            data[0][0] = searchKey;
            data[0][1] = String.join(" | ",this.dictionary.get(searchKey));
        }else
        {
            int i = 0;
            for(String key : this.dictionary.keySet())
            {
                data[i][0] = key;
                data[i][1] = String.join(" | ",this.dictionary.get(key));
                i++;
            }
        }
        return data;
    }

    public String[][] searchDef()
    {
        String[][] data = new String[this.dictionary.keySet().size()][2];

        String searchKey = this.searchBar.getText();

        int i = 0;
        for(String key : this.dictionary.keySet())
        {
            data[i][0] = key;
            data[i][1] = String.join(" | ",this.dictionary.get(key));
            i++;
        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.searchButton)
        {
            String[] colNames = {"Word", "Definitions"};
            String[][] data;
            if(this.searchChoicesList.getSelectedItem().equals("Word"))
            {
                data = searchWord();
            }else{
                data = searchDef();
            }
            dictionaryWindow dictTable = new dictionaryWindow("Dictionary",300,300,colNames,data);
        }
    }
}


