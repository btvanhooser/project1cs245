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
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    /* --- Variables --- */
    private JPanel hangmanPanel;
    private JPanel keyboardPanel;
    private JPanel northPanel;
    private JLabel clockTextArea;
    private JTextArea testUpdate;
    private JButton skipButton;
    private final Keyboard controller;
    DateFormat dateFormat;
    Date time;
    Timer timer;
    
   
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public GameView(Keyboard controller) {
        this.controller = controller;
        createHangmanPanel();
        createKeyboardPanel();
        createSkipButton();
        createClock();
        updateClock();
        setPanelAttributes();
    }
 
    //MHG
    public void update(String wordState, int wrongGuesses, int score) {
        testUpdate.setText("wordState: " + wordState + " wrongGuesses: " + wrongGuesses + " score: " + score);
    }
    
    //MHG - DEPRECATED
    /*public void update(String buttonText) {
        testUpdate.setText(buttonText);
    }*/
    
    
    /* --- Helper Methods --- */
    
    private void setPanelAttributes() {
        setLayout(new BorderLayout());
        add(keyboardPanel,BorderLayout.SOUTH);
        add(hangmanPanel,BorderLayout.CENTER);
        northPanel = new JPanel();
        northPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        northPanel.setLayout(new GridLayout(2,5));
        northPanel.add(clockTextArea);
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel("HANGMAN"));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(" Score: ---"));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(skipButton);
        add(northPanel,BorderLayout.NORTH);
    }
    
    private void createHangmanPanel() {
        hangmanPanel = new JPanel();
        hangmanPanel.setSize(600, 300);
        hangmanPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        testUpdate = new JTextArea();
        hangmanPanel.add(testUpdate);
       
    }
    
    private void createKeyboardPanel() {
        keyboardPanel = new JPanel();
        keyboardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        keyboardPanel.setLayout(new GridLayout(2,13,5,5));
        for (int ii = 0; ii < controller.getSize(); ++ii ) {
            keyboardPanel.add(controller.keyList.get(ii));
        }
    }
    
    private void createSkipButton() {
        skipButton = new JButton("Skip");
        skipButton.setMargin(new Insets(1,1,1,1));
    }
    
    private void createClock() {
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        clockTextArea = new JLabel(dateFormat.format(new Date()));
    }
        
    public void updateClock() {
        timer = new Timer(1000, (ActionEvent e) -> {
            clockTextArea.setText(dateFormat.format(new Date()));
        });
        timer.start();
    }
    
    public void updateScore() {
        
    }
}
