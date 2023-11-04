package GUI;

import Utils.Utils;

import javax.swing.*;
import java.awt.*;

public class centerJPanel extends JPanel {
    public centerJPanel()
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel wordFormLabel = new JLabel("Word:");
        JTextField wordFormBar = new JTextField();
        wordFormBar.setPreferredSize(new Dimension(300,25));

        JLabel defFormLabel = new JLabel("Definition:");
        JTextField defFormBar = new JTextField();
        defFormBar.setPreferredSize(new Dimension(300,25));

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

        JButton addButton = new JButton("Add new word");
        JButton editButton = new JButton("Edit existing word");
        JButton deleteButton = new JButton("Delete existing word");
        JButton resetButton = new JButton("Reset dictionary");


        centerPanelButton.add(addButton);
        centerPanelButton.add(editButton);
        centerPanelButton.add(deleteButton);
        centerPanelButton.add(resetButton);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(centerPanelButton,gbc);
    }
}
