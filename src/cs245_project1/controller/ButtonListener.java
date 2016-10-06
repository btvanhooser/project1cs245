/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245_project1.controller;

/***************************************************************
* file: ButtonListener.java
* author: Brian Van Hooser
* class: CS 245 - Intro to GUI
*
* assignment: Project 1 (Hangman)
* date last modified: 10/6/2016
*
* purpose: This interface is designed to help facilitate the
* switching of panels from within the MainFrame class.
*
****************************************************************/

public interface ButtonListener {
    
    // Method: btnClicked
    // Purpose: This is the required function that MainFrame will 
    // need to have each 'attached' panel to have.
    
    public void btnClicked (String buttonName);
}
