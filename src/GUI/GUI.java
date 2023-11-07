package GUI;

import FunctionalHandling.randomSlang;
import FunctionalHandling.dictionary;
import Utils.Utils;

import javax.swing.*;

import java.awt.*;

public class GUI extends JFrame {
    private JPanel mainJP;
    private topJPanel topPanel;
    private centerJPanel centerPanel;
    private leftJPanel leftPanel;
    private rightJPanel rightPanel;
    private bottomJPanel bottomPanel;
    private dictionaryWindow dictionary;

    public GUI(String title, int width, int height, dictionary userDictionary, randomSlang userRandom) {
        this.setDefaultLookAndFeelDecorated(true);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.mainJP = new JPanel();
        this.mainJP.setLayout(new BorderLayout());

        this.topPanel = new topJPanel(userDictionary);

        this.centerPanel = new centerJPanel();

        this.leftPanel = new leftJPanel(userRandom);

        this.rightPanel = new rightJPanel();

        this.bottomPanel = new bottomJPanel();

        this.mainJP.add(Utils.setPadding(topPanel, 20, 10, true), BorderLayout.PAGE_START);
        this.mainJP.add(Utils.setPadding(this.centerPanel, 50, 10, true), BorderLayout.CENTER);
        this.mainJP.add(Utils.setPadding(this.leftPanel, 50, 10, true), BorderLayout.WEST);
        this.mainJP.add(Utils.setPadding(this.rightPanel,50,10,true),BorderLayout.EAST);
        this.mainJP.add(Utils.setPadding(this.bottomPanel, 50, 10, true), BorderLayout.PAGE_END);

        this.setContentPane(mainJP);
        this.setMinimumSize(new Dimension(width, height));
        this.pack();
        this.setVisible(true);
    }

}