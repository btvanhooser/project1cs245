/***************************************************************
* file: CS245_Project1.java
* @author: Andrew Olaveson
* @author: Melanie Giusti
* @author: Brian Van Hooser
* @author: Alfredo Ceballos
* class: CS 245.01 – Programming Graphical User Interfaces
*
* date last modified: 10/6/2016
* purpose: This is the file that contains the 'main' method which
* handles the usage of the SplashScreen, and then launches the 
* MainFrame after a set time.
****************************************************************/
package cs245_project1.controller;
import cs245_project1.screens.GameScreen;
import cs245_project1.screens.MainFrame;
import cs245_project1.screens.SplashScreen;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 */
public class CS245_Project1 {
    
    // Method: main
    // Purpose: This is the starting point for this project.
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                SplashScreen splash = new SplashScreen();
                Timer timer = new Timer(100, (ActionEvent e) -> {
                    splash.dispose();
                    new MainFrame();
                });
                timer.setRepeats(false);
                timer.setInitialDelay(3000);
                timer.start();
            }
        });
    }
}
