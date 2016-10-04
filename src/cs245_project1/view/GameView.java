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
import cs245_project1.model.Hangman;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 */
public class GameView extends JPanel {
    
    /* --- Variables --- */
    private JPanel hangman;
    private JPanel keyboard;
    private JTextArea testUpdate;
    private Hangman model;
    private Keyboard controller;
    
    public String updateString = "";
    
   
    public GameView(Hangman model) {
        this.model = model;
        controller = model.getController();
        

        createHangmanPanel();
        createKeyboardPanel();
        setPanelAttributes();
    }
 
    public void update() {
        testUpdate.setText(updateString);
    }
    
    
    /* --- Helper Methods --- */
    
    private void setPanelAttributes() {
        setLayout(new BorderLayout());
        add(keyboard,BorderLayout.SOUTH);
        add(hangman,BorderLayout.NORTH);
        
    }
    
    private void createHangmanPanel() {
        testUpdate = new JTextArea("HANGMAN");
        hangman = new JPanel();
        hangman.add(testUpdate);
    }
    
    private void createKeyboardPanel() {
        keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(2,13,5,5));
        for (int ii = 0; ii < controller.getSize(); ++ii ) {
            keyboard.add(controller.keyList.get(ii));
        }
    }
}