/***************************************************************
* file: GameScreen.java
* @author: Andrew Olaveson
* @author: Melanie Giusti
* class: CS 245.01 – Programming Graphical User Interfaces
*
* date last modified:
* purpose: 
****************************************************************/
package cs245_project1.screens;

import cs245_project1.controller.Keyboard;
import cs245_project1.model.Hangman;
import cs245_project1.view.GameView;
import javax.swing.JFrame;

/**
 *
 */
public class GameScreen  extends JFrame {
    /* Variables */
    GameView view;
    Hangman  model;
    Keyboard controller;
    
    
    public GameScreen() {
        controller = new Keyboard();
        model = new Hangman(controller);
        view = new GameView(model);
        
        setFrameAttributes();
    }
    
    private void setFrameAttributes() {
        add(view);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
