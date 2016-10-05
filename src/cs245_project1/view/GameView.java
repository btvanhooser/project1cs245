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
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 */
public class GameView extends JPanel {
    
    /* --- Variables --- */
    private JPanel hangmanPanel;
    private JPanel keyboardPanel;
    private JTextArea testUpdate;
    private Keyboard controller;
    
    public String updateString = "";
    
   
    public GameView(Keyboard controller) {
        this.controller = controller;
        

        createHangmanPanel();
        createKeyboardPanel();
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
        add(hangmanPanel,BorderLayout.NORTH);
        
    }
    
    private void createHangmanPanel() {
        testUpdate = new JTextArea("HANGMAN");
        hangmanPanel = new JPanel();
        hangmanPanel.add(testUpdate);
       
    }
    
    private void createKeyboardPanel() {
        keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new GridLayout(2,13,5,5));
        for (int ii = 0; ii < controller.getSize(); ++ii ) {
            keyboardPanel.add(controller.keyList.get(ii));
        }
    }
}