/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Laura Garcia
 * @author Austin Stamper
 */
public class SearchCarGUI extends JFrame{
    
    //Variables
    private JPanel panel;
    private JLabel messageLabel;
    private JButton searchButton;
    private JTextField vinToSearch;
    
    /**
     * Constructor
     */
    public SearchCarGUI() {
        //Set the title of the SearchCarGUI frame
        setTitle("Search Cars");
        
        //Specify the action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Build the panel to hold text field
        buildPanel();
        
        //Add the panel to the frame
        add(panel, BorderLayout.CENTER);
        
        //Adjust the scale
        pack();
        
        //Set the visibility
        setVisible(true);
    }

    private void buildPanel() {
        //Create the label and text field
        messageLabel = new JLabel("Enter the vehicle VIN to search: "); 
        vinToSearch = new JTextField(5);
        searchButton = new JButton("Search");
        
        //Create a panel and add the components to it
        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(vinToSearch);
        panel.add(searchButton);
    }
    
    public static void main(String[] args)
    {
        new SearchCarGUI();
    }
}
