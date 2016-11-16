/*
 * Dealership class responisble for running GUI in Main
 */

import javax.swing.JFrame;

/**
 *
 * @author Laura Garcia
 * @author Austin Stamper
 */
public class Dealership {

    /**
     * Void method to create and set GUI properties
     */
    private static void createDisplayGUI() {
        
        //Create the GUI from the GUI class and set its properties
        DealershipMenuGUI frame = new DealershipMenuGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    /*
     * Main function to run on thread that displays the GUI window
    */
    public static void main(String[] args) {
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createDisplayGUI();
            }
        });
    }
}
