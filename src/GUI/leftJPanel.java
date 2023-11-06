package GUI;

import Utils.Utils;

import javax.swing.*;
import java.awt.*;

public class leftJPanel extends JPanel {
    public leftJPanel()
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel randomWord = new JLabel("Đây là random word");
        randomWord.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel randomDef = new JLabel("Đây là random definition. Đây là random definition.");
        randomDef.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JButton  randomButton = new JButton("Random");

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(randomWord,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(Box.createRigidArea(new Dimension(0,5)),gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(randomDef,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(Box.createRigidArea(new Dimension(0,20)),gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(randomButton,gbc);
    }
}
