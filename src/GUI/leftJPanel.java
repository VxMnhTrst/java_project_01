package GUI;

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
    public leftJPanel(randomSlang random)
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.randomWord = new JLabel("Đây là random word");
        randomWord.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.randomDef = new JLabel("Đây là random definition. Đây là random definition.");
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

        this.random = random;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.randomButton)
        {
            String[] newRandomSlang = this.random.getRandomSlang();
            this.randomWord.setText(newRandomSlang[0]);
            this.randomDef.setText(newRandomSlang[1]);
        }
    }
}
