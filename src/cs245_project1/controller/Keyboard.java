/***************************************************************
* file: Keyboard.java
* @author: Andrew Olaveson
* @author: Melanie Giusti
* 
* class: CS 245.01 – Programming Graphical User Interfaces
*
* date last modified:
* purpose: 
****************************************************************/
package cs245_project1.controller;

import java.awt.Insets;
import java.util.LinkedList;
import javax.swing.JButton;

/**
 *
 */
public class Keyboard {

    /* --- Constants--- */
    private final int FIRST_LETTER = 65;
    private final int LAST_LETTER = 90;
    
    /* --- Variables --- */
    public LinkedList<JButton> keyList;
    private JButton skipButton;
    
    public Keyboard() {
        super();
        keyList = new LinkedList<>();
        populateControllerButtons();
    }
    
    public int getSize() { return keyList.size(); }
    public LinkedList<JButton> getKeyboardList() {
        return keyList;
    }
    
    
    /* --- Helper Methods --- */
    
    public  JButton getSkipButton(){return skipButton;}
    
    private void populateControllerButtons() {
        skipButton = new JButton("Skip");
        skipButton.setMargin(new Insets(1,1,1,1));
        for (int ii = FIRST_LETTER; ii <= LAST_LETTER; ++ii) {
            keyList.add(new JButton(Character.toString((char)ii)));
            keyList.get(ii - FIRST_LETTER).setMargin(new Insets(1,1,1,1));
        }
    }
}
