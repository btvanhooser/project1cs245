/***************************************************************
* file: Hangman.java
* @author: Andrew Olaveson
* @author: Melanie Giusti
* 
* class: CS 245.01 – Programming Graphical User Interfaces
*
* date last modified:
* purpose: 
****************************************************************/
package cs245_project1.model;

import cs245_project1.controller.Keyboard;
import cs245_project1.view.GameView;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 * 
 */
public class Hangman {
    
    GameView view;
    Keyboard controller;
    
    public Hangman(GameView view, Keyboard controller) {
        this.controller = controller;
        this.view = view;
        addActionListenersToKeyboardButtons();
    }
    
    
    public void update(String buttonText) {
        view.update(buttonText);
    }
    
    
    private void addActionListenersToKeyboardButtons() {
        for (JButton button : controller.keyList) {
            button.addActionListener((ActionEvent e) -> {
                update(button.getText());
                button.setEnabled(false);
            });
        }
    }
    
}
