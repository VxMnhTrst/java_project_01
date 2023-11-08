package GUI;

import Data.dataBase;
import Utils.Utils;
import FunctionalHandling.randomSlang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class leftJPanel extends JPanel implements ActionListener {
    private JLabel randomWord;
    private JLabel randomDef;
    private JButton randomButton;
    private randomSlang random;
    private dataBase userDataBase;
    public leftJPanel(dataBase userDataBase)
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.randomWord = new JLabel("Random word");
        this.randomWord.setFont(new Font("Consolas",Font.PLAIN,20));
        randomWord.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.randomDef = new JLabel("Definition");
        this.randomDef.setFont(new Font("Consolas",Font.PLAIN,15));
        randomDef.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        randomDef.setPreferredSize(new Dimension(300, 25));
        this.randomButton = new JButton("Random");
        this.randomButton.addActionListener(this);

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

        this.random = new randomSlang(userDataBase);
        this.userDataBase = userDataBase;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.randomButton)
        {
            String[] newRandomSlang = this.random.getRandomSlang(userDataBase);
            this.randomWord.setText(newRandomSlang[0]);
            this.randomDef.setText(newRandomSlang[1]);
        }
    }
}
