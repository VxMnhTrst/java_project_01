package GUI;

import Utils.Utils;

import javax.swing.*;
import java.awt.*;

public class bottomJPanel extends JPanel {
    public bottomJPanel()
    {
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        JPanel quizChoices = new JPanel();
        quizChoices.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton quizWordButton = new JButton("Start quiz by word");
        JButton quizDefButton = new JButton("Start quiz by definition");
        quizChoices.add(quizWordButton);
        quizChoices.add(quizDefButton);

        JPanel bottomQuizPanel = new JPanel();
        bottomQuizPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel quizQuestion = new JLabel("Đây là câu hỏi của quiz");
        quizQuestion.setFont(new Font("Consolas",Font.PLAIN,20));
        String[] quizAnswers = {"This is A","This is BThis is BThis is B","This is C","This is D"};
        JComboBox quizAnswersList = new JComboBox(quizAnswers);
        quizAnswersList.setFont(new Font("Consolas",Font.PLAIN,20));
        JButton quizSubmit = new JButton("Submit answer");
        bottomQuizPanel.add(quizQuestion);
        bottomQuizPanel.add(quizAnswersList);
        bottomQuizPanel.add(quizSubmit);

        this.add(quizChoices);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(bottomQuizPanel);
    }
}
