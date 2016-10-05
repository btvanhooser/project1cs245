/***************************************************************
* file: GameView.java
* @author: Andrew Olaveson
* @author: Melanie Giusti
* class: CS 245.01 – Programming Graphical User Interfaces
*
* date last modified:
* purpose: 
****************************************************************/
package cs245_project1.view;

import cs245_project1.controller.Keyboard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 * 
 */
public class GameView extends JPanel {
    
    /* --- Constants --- */
    private final Keyboard controller;
    
    /* --- Variables --- */
    private JPanel hangmanPanel;
    private JPanel keyboardPanel;
    private JPanel headerPanel;
    private JPanel wordPanel;
    private JLabel scoreLabel;
    private JLabel headerLabel;
    private JLabel clockTextArea;
    private JTextArea testUpdate;
    private JButton skipButton;
    
    private LinkedList <JLabel> currentWordList;
    private String currentWord;
    private DateFormat dateFormat;
    private Date time;
    private Timer timer;
    
   
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public GameView(Keyboard controller) {
        this.controller = controller;
        createWordPanel();
        createHangmanPanel();
        createKeyboardPanel();
        createHeaderPanelItems();
        startClock();
        addPanels();
    }
 
    //MHG
    public void update(String wordState, int wrongGuesses, int score) {
        currentWord = wordState;
        testUpdate.setText("wordState: " + wordState + " wrongGuesses: " + wrongGuesses + " score: " + score);
        updateScore(Integer.toString(score));
        updateWord();
    }
    

    /* --- Helper Methods --- */
    
    private void addPanels() {
        setLayout(new BorderLayout());
        add(keyboardPanel,BorderLayout.SOUTH);
        add(hangmanPanel,BorderLayout.CENTER);
        headerPanel = new JPanel();
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        headerPanel.setLayout(new GridLayout(0,5));

        headerPanel.add(clockTextArea);
        headerPanel.add(new JLabel());
        headerPanel.add(headerLabel);
        headerPanel.add(new JLabel());
        headerPanel.add(new JLabel());
        headerPanel.add(scoreLabel);
        headerPanel.add(new JLabel());
        headerPanel.add(new JLabel());
        headerPanel.add(new JLabel());
        headerPanel.add(skipButton);

        add(headerPanel,BorderLayout.NORTH);
    }
    
    private void createHangmanPanel() {
        hangmanPanel = new JPanel();
        hangmanPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        testUpdate = new JTextArea();
        hangmanPanel.add(wordPanel);
    }
    
    private void createKeyboardPanel() {
        keyboardPanel = new JPanel();
        keyboardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        keyboardPanel.setLayout(new GridLayout(2,13,5,5));
        for (int ii = 0; ii < controller.getSize(); ++ii ) {
            keyboardPanel.add(controller.keyList.get(ii));
        }
    }
    
    private void createHeaderPanelItems() {
        headerLabel = new JLabel("HANGMAN");
        scoreLabel = new JLabel(" Score: ---");
        
        skipButton = new JButton("Skip");
        skipButton.setMargin(new Insets(1,1,1,1));
        
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        clockTextArea = new JLabel(dateFormat.format(new Date()));
    }
    
    private void createWordPanel() {
        currentWord = "---";
        wordPanel = new JPanel();
        wordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        currentWordList = new LinkedList<>();

        updateWord();
    }
        
    private void startClock() {
        timer = new Timer(1000, (ActionEvent e) -> {
            clockTextArea.setText(dateFormat.format(new Date()));
        });
        timer.start();
    }
    
    private void updateScore(String score) {
        scoreLabel.setText(" Score: "+ score);
    }
    
    private void updateWord() {
        wordPanel.removeAll();

        for (int ii = 0; ii < currentWord.length(); ++ii) {
            currentWordList.add(new JLabel(currentWord.charAt(ii)+ " "));
            wordPanel.add(currentWordList.get(ii));
            currentWordList.get(ii).setText(currentWord.charAt(ii) + " ");
        }
    }
}
