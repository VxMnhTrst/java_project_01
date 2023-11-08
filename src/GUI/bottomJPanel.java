package GUI;

import Data.dataBase;
import FunctionalHandling.randomSlang;
import Utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class bottomJPanel extends JPanel implements ActionListener {
    private JButton quizWordButton;
    private JButton quizDefButton;
    private JLabel quizQuestion;
    private JComboBox quizAnswersList;
    private JButton quizSubmit;
    private String[] quizAnswers;
    private randomSlang randomFunctional;
    private JLabel noti;
    private dataBase userDataBase;
    private boolean choiceQuiz;
    public bottomJPanel(dataBase userDataBase)
    {
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        JPanel quizChoices = new JPanel();
        quizChoices.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.quizWordButton = new JButton("Start quiz by word");
        this.quizDefButton = new JButton("Start quiz by definition");
        quizChoices.add(quizWordButton);
        quizChoices.add(quizDefButton);


        JPanel bottomQuizPanel = new JPanel();
        bottomQuizPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.quizQuestion = new JLabel("This is quiz question.");
        quizQuestion.setFont(new Font("Consolas",Font.PLAIN,20));
        this.quizAnswers = new String[]{"This is A", "This is BThis is BThis is B", "This is C", "This is D"};
        this.quizAnswersList = new JComboBox(quizAnswers);
        quizAnswersList.setFont(new Font("Consolas",Font.PLAIN,20));
        this.quizSubmit = new JButton("Submit answer");

        bottomQuizPanel.add(quizQuestion);
        bottomQuizPanel.add(quizAnswersList);
        bottomQuizPanel.add(quizSubmit);

        JPanel notiQuizPanel = new JPanel();
        notiQuizPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.noti = new JLabel("Choose your answer");
        noti.setFont(new Font("Consolas",Font.PLAIN,20));
        notiQuizPanel.add(noti);

        this.add(quizChoices);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(bottomQuizPanel);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(notiQuizPanel);

        this.userDataBase = userDataBase;
        this.randomFunctional = new randomSlang(userDataBase);

        this.quizWordButton.addActionListener(this);
        this.quizDefButton.addActionListener(this);
        this.quizSubmit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.quizWordButton)
        {
            this.quizAnswers = new String[4];
            this.quizAnswersList.removeAllItems();
            for(int i = 0; i < 4; ++i) {
                this.quizAnswers[i] = randomFunctional.getRandomSlang(this.userDataBase)[0];
                this.quizAnswersList.addItem(this.quizAnswers[i]);
            }
            int randQuestion = new Random().nextInt(this.quizAnswers.length);
            this.quizQuestion.setText(String.join(" | ",
                    userDataBase.getUserDictionary().get(quizAnswers[randQuestion])));
            this.noti.setForeground(Color.BLACK);
            this.noti.setText("Choose your answer");
            this.choiceQuiz = false;
        }
        if(e.getSource() == this.quizDefButton)
        {
            String[] quizAnswersDef = new String[4];
            this.quizAnswers = new String[4];
            this.quizAnswersList.removeAllItems();

            for(int i = 0; i < 4; ++i) {
                String[] quiz = randomFunctional.getRandomSlang(this.userDataBase);
                this.quizAnswers[i] = quiz[0];
                quizAnswersDef[i] = quiz[1];
                this.quizAnswersList.addItem(this.quizAnswers[i]);
            }

            int randQuestion = new Random().nextInt(this.quizAnswers.length);
            this.quizQuestion.setText(quizAnswersDef[randQuestion]);
            this.noti.setForeground(Color.BLACK);
            this.noti.setText("Choose your answer");
            this.choiceQuiz = true;
        }
        if(e.getSource() == this.quizSubmit)
        {
            if(!this.quizQuestion.getText().equals("This is quiz question."))
            {
                if(!this.choiceQuiz)
                {
                    String answer = String.valueOf(this.quizAnswersList.getSelectedItem());
                    String question = String.join(" | ",
                            this.userDataBase.getUserDictionary().get(answer));
                    if(question.equals(this.quizQuestion.getText()))
                    {
                        this.noti.setForeground(Color.GREEN);
                        this.noti.setText("Correct answer.");
                    }else
                    {
                        this.noti.setForeground(Color.RED);
                        this.noti.setText("Incorrect answer");
                    }
                }else {
                    String answer = String.valueOf(this.quizAnswersList.getSelectedItem());
                    String answerDef = String.join(" | ",
                            this.userDataBase.getUserDictionary().get(answer));
                    if(this.quizQuestion.getText().equals(answerDef))
                    {
                        this.noti.setForeground(Color.GREEN);
                        this.noti.setText("Correct answer.");
                    }else
                    {
                        this.noti.setForeground(Color.RED);
                        this.noti.setText("Incorrect answer");
                    }
                }
            }
        }
    }
}
