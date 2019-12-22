package ru.kpfu.itis.gallows.ui.panels;

import ru.kpfu.itis.gallows.ui.interfaces.IClientView;
import ru.kpfu.itis.gallows.ui.interfaces.IViewClient;
import ru.kpfu.itis.gallows.ui.interfaces.PanelManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements IClientView {

    private IViewClient iViewClient;
    private PanelManager manager;
    private JPanel alphabetPanel;
    private GallowsPanel gallowsPanel;
    private JPanel wordsPanel;
    private JPanel infoPanel;
    private JPanel[] wordPanel;
    private JLabel usedWordsLabel;
    private JLabel lengthLabel;
    private JLabel triesLabel;
    private int tries = 12;
    private int secretWordLength;
    private final char[] words = {'a', 'b', 'c', 'd', 'e', 'f', 'j',
                                  'h', 'i', 'j', 'k', 'l', 'm', 'n',
                                  'o', 'p', 'q', 'r', 's', 't', 'u',
                                  'v', 'w', 'x', 'y', 'z', ' '};

    public GamePanel(PanelManager manager, int secretWordLength, IViewClient iViewClient) {
        this.secretWordLength = secretWordLength;
        this.iViewClient = iViewClient;
        this.manager = manager;
        this.setSize(600, 400);
        this.setLayout(new GridBagLayout());
        alphabetPanel = new JPanel(new GridBagLayout());
        wordsPanel = new JPanel(new FlowLayout());
        wordPanel = new JPanel[this.secretWordLength];
        gallowsPanel = new GallowsPanel();

        infoPanel = new JPanel(new GridBagLayout());
        lengthLabel = new JLabel("Length: " + this.secretWordLength);
        usedWordsLabel = new JLabel("Used: ");
        triesLabel = new JLabel("Tries: " + tries);
        lengthLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        usedWordsLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        triesLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        for (int i = 0; i < this.secretWordLength; i++) {
            wordPanel[i] = new JPanel();
            wordPanel[i].setSize(50, 50);
            wordPanel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
            JLabel space = new JLabel("  ");
            space.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
            wordPanel[i].add(space);
            wordsPanel.add(wordPanel[i]);
        }
        GridBagConstraints constraints = new GridBagConstraints(
                0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 10, 5, 10), 0, 0
        );
        for (int i = 0; i < 27; i++) {
            JButton word = new JButton(words[i] + "");
            word.setSize(50, 50);
            word.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
            char w = words[i];
            int j = i;
            word.addActionListener(event -> {
                //тут надо сказать, что "я нажал на такую-то букву, скажи всем"
                //ну и нужно проверить есть ли эта буква в слове ли она или нет
                //а вот что возвращать ты мне будешь, ето прям хз
                this.iViewClient.sendWord(w);
            });
            if (i < 9) {
                constraints.gridx = i;
            } else if (i < 18){
                constraints.gridx = i - 9;
                constraints.gridy = 1;
            } else {
                constraints.gridx = i - 18;
                constraints.gridy = 2;
            }
            if (i == 26) word.setEnabled(false);
            alphabetPanel.add(word, constraints);
        }
        gallowsPanel = new GallowsPanel();
        gallowsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
        infoPanel.add(triesLabel, new GridBagConstraints(
                0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 1)
        );
        infoPanel.add(lengthLabel, new GridBagConstraints(
                0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 5, 0, 5), 0, 0)
        );
        infoPanel.add(usedWordsLabel, new GridBagConstraints(
                0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 0, 5), 0, 0)
        );
        JPanel gamePanel = new JPanel(new GridBagLayout());
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.add(this.infoPanel, BorderLayout.CENTER);

        gamePanel.add(infoPanel,  new GridBagConstraints(
                0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                new Insets(5, 0, 5, 205), 0, 0));

        gamePanel.add(gallowsPanel,  new GridBagConstraints(
                1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 0, 5, 0), 300, 300));
        this.add(gamePanel, new GridBagConstraints(
                0, 0,1,1,1.0,0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(10,1,10,1), 0,0
        ));
        this.add(wordsPanel, new GridBagConstraints(
                0, 1,1,1,1.0,0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(1,1,1,1), 416,10
        ));
        this.add(alphabetPanel,  new GridBagConstraints(
                0, 2,1,1,1.0,0.0, GridBagConstraints.PAGE_END, GridBagConstraints.NONE,
                new Insets(10,0,10,0), 0,0
        ));
        this.setVisible(true);
    }


    @Override
    public void repaintView(boolean isRight, char[] secretWord, int mistake, char[] usedWords) {
        repaintUsedWords(usedWords);
        repaintMistake(mistake);
        if (isRight) {
            repaintSecretWord(secretWord);
        } else {
            repaintSecretWord(secretWord);
            gallowsPanel.repaintView(mistake);
        }
    }

    @Override
    public void gameOver() {
        this.setVisible(false);
        manager.switchTo(new GameOverPanel());
    }

    private void repaintSecretWord(char[] secretWord) {
        for (int i = 0; i < secretWord.length; i++) {
            if (secretWord[i] != 0) {
                JLabel label = new JLabel(secretWord[i] + "");
                label.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
                wordPanel[i].removeAll();
                wordPanel[i].add(label);
                wordPanel[i].revalidate();
                wordPanel[i].repaint();
            }
        }
    }

    private void repaintMistake(int mistake) {
        tries -= mistake;
        triesLabel.setText("Tries: " + tries);
        infoPanel.revalidate();
        infoPanel.repaint();
    }

    private void repaintUsedWords(char[] usedWords) {
        String used = "";
        for (int i = 0; i < usedWords.length; i++) {
            used += usedWords[i] + "";
        }
        usedWordsLabel.setText("Used: " + used);
        infoPanel.revalidate();
        infoPanel.repaint();
    }
}
