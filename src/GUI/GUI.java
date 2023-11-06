package GUI;

import Utils.Utils;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JPanel mainJP;
    private topJPanel topPanel;
    private centerJPanel centerPanel;
    private leftJPanel leftPanel;
    private bottomJPanel bottomPanel;
    private dictionaryWindow dictionary;

    public GUI(String title, int width, int height) {
        this.setDefaultLookAndFeelDecorated(true);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.mainJP = new JPanel();
        this.mainJP.setLayout(new BorderLayout());

        this.topPanel = new topJPanel();

        this.centerPanel = new centerJPanel();

        this.leftPanel = new leftJPanel();

        this.bottomPanel = new bottomJPanel();

        this.mainJP.add(Utils.setPadding(topPanel, 20, 10, true), BorderLayout.PAGE_START);
        this.mainJP.add(Utils.setPadding(this.centerPanel, 50, 10, true), BorderLayout.CENTER);
        this.mainJP.add(Utils.setPadding(this.leftPanel, 50, 10, true), BorderLayout.WEST);
        this.mainJP.add(Utils.setPadding(this.bottomPanel, 50, 10, true), BorderLayout.PAGE_END);

        this.setContentPane(mainJP);
        this.setMinimumSize(new Dimension(width, height));
        this.pack();
        this.setVisible(true);
    }
}