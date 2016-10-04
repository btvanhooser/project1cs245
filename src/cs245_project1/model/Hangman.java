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

/**
 * 
 */
public class Hangman {
    
    Keyboard controller;
    
    public Hangman(Keyboard controller) {
        this.controller = controller;
    }
    
    public void update() {
        
    }
    
    public Keyboard getController() {
        return controller;
    }
    
}
