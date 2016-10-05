/***************************************************************
* file: Hangman.java
* @author: Andrew Olaveson
* @author: Melanie Giusti
* 
* class: CS 245.01 – Programming Graphical User Interfaces
*
* date last modified: 10/05/16 12:52 a.m.  
* purpose:            Defines the game rules for Hangman
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
    
    /*Variables*/
    GameView               view;
    Keyboard               controller;
    private  String        guessWord;
    private  StringBuilder wordState;
    private  int           wrongGuesses;
    private  int           score;
    
    /*Constants*/
    private final int    MAX_SCORE        = 100;
    private final int    POINTS_TO_DEDUCT = 10;
    private final String WORD_LIST []     = {"ABSTRACT","CEMETERY","NURSE",
                                             "PHARMACY","CLIMBING"};
    
    /* Model constructor*/
    public Hangman(GameView view, Keyboard controller) {
        
        this.controller = controller;
        this.view = view;
        addActionListenersToKeyboardButtons();
        
        // Set initial game state
        score        = MAX_SCORE;
        wrongGuesses = 0;
        guessWord    = getRandomWord();
        wordState    = new StringBuilder(guessWord.length());
        
        for(int i = 0; i < guessWord.length(); i++){wordState = wordState.append("_");}
        
    }
    
    /*Updates game state based upon letter guessed*/
    public void update(String buttonText) {
        
        if(guessWord.contains(buttonText)){ // If the word contains the guessed letter
            int index = 0;
            while(index > -1){              // Fill in all instances of that letter 
                if((index = guessWord.indexOf(buttonText,index)) > -1){
                    wordState.replace(index,index+1,buttonText);                 
                    index++;
                }
            }
        }
        else{                               // Otherwise decrement the score
            score -= POINTS_TO_DEDUCT;
            wrongGuesses++;
        }
        
        view.update(wordState.toString(),wrongGuesses,score);
    }
    
    /* Adds action listeners to our virtual keyboard*/
    private void addActionListenersToKeyboardButtons() {
        
        for (JButton button : controller.keyList) {
            button.addActionListener((ActionEvent e) -> {
                update(button.getText());
                button.setEnabled(false);
            });
        }
    }
    
    /*Returns a random word from our word list*/
    private String getRandomWord(){
        return WORD_LIST[(int)(Math.random()*WORD_LIST.length)];
    }
    
}
