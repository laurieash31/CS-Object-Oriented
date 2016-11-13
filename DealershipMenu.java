/*
 * This is the basic menu for Assignment 5 Dealership Database GUI.
 */ 

package assignment5;

/*
 * CardLayoutDemo.java
 * @author Laura Garcia
 * @author Austin Stamper
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DealershipMenu implements ItemListener {
    
    //Make an instance of the Dealership class to call functions
    static Dealership dealer = new Dealership();
    
    //a panel that uses CardLayout
    JPanel cards = new JPanel(new CardLayout()); 
    
    //Names for each card
    final static String VEHICLE_MANAGEMENT_PANEL = "Vehicle Management";
    final static String USER_MANAGEMENT_PANEL = "User Management";
    final static String TRANSACTION_MANAGEMENT_PANEL = "Transaction Management";
    final static String DISPLAY_VEHICLE_RECORDS_PANEL = "Display vehicle records";
    
    //Variables for Card 1
    JRadioButton displayButton;
    JRadioButton addButton;
    JRadioButton deleteButton;
    JRadioButton searchButton;
    JRadioButton priceSearchButton;
    
    public void addComponentToPane(Container pane) {
        
        //Put the JComboBox in a JPanel to switch between menus
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { VEHICLE_MANAGEMENT_PANEL, USER_MANAGEMENT_PANEL, TRANSACTION_MANAGEMENT_PANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        

        //Create the "cards" panels for Card 1 - Vehicle Management
        JPanel card1 = new JPanel(new GridLayout(0,1));
        JPanel card1Display = new JPanel();
        
        //Add buttons to button group for card1
        ButtonGroup radioButtonGroup = new ButtonGroup();
        
        displayButton = new JRadioButton("Display all vehicles");
        radioButtonGroup.add(displayButton);
        
        addButton = new JRadioButton("Add a vehicle");
        radioButtonGroup.add(addButton);
        
        deleteButton = new JRadioButton("Delete a vehicle");
        radioButtonGroup.add(deleteButton);
        
        searchButton = new JRadioButton("Search for a vehicle");
        radioButtonGroup.add(searchButton);
        
        priceSearchButton = new JRadioButton("Search price range");
        radioButtonGroup.add(priceSearchButton);
        
        //Add the action listeners to the radio buttons for card1 here!!!!!
        displayButton.addActionListener(new RadioButtonListener());
        
        //Add the buttons to card1
        card1.add(displayButton);
        card1.add(addButton);
        card1.add(deleteButton);
        card1.add(searchButton);
        card1.add(priceSearchButton);
        
        
        //Creating a text field for Card1A - Display Vehicles
        JTextArea textArea = new JTextArea(20, 20);
        textArea.setText(dealer.displayRecords());
        card1Display.add(textArea);
        textArea.setEditable(false);
        
        
        //Add the card functions to the deck -DON'T KNOW IF I NEED THIS?????
        //cards.add(card1Display, "Display vehicles");
        
        
        
        //Create the "cards" panels for Card 2 - User Management
        JPanel card2 = new JPanel(new GridLayout(0,1));
        //Add buttons to button group for card1
        ButtonGroup radioButtonGroup2 = new ButtonGroup();
        JRadioButton displayUsersButton = new JRadioButton("Display users");
        radioButtonGroup2.add(displayUsersButton);
        JRadioButton addUserButton = new JRadioButton("Add a user");
        radioButtonGroup2.add(addUserButton);
        JRadioButton updateUserButton = new JRadioButton("Update user information");
        radioButtonGroup2.add(updateUserButton);
        
        //Add the action listeners to the radio buttons for card2 here later!!!!!!
        
        //Add the buttons to card2
        card2.add(displayUsersButton);
        card2.add(addUserButton);
        card2.add(updateUserButton);
        
        //Create the "cards" panels for Card 3 - Transaction Management
        JPanel card3 = new JPanel();
        card3.add(new JTextField("TextField", 20));
        
        //Create the panel that contains all the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, VEHICLE_MANAGEMENT_PANEL);
        cards.add(card2, USER_MANAGEMENT_PANEL);
        cards.add(card3, TRANSACTION_MANAGEMENT_PANEL);
        cards.add(card1Display, DISPLAY_VEHICLE_RECORDS_PANEL);
        
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Dealership Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        DealershipMenu demo = new DealershipMenu();
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        dealer.readRecords();
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        dealer.exportData();
    }

    private class RadioButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == displayButton){    
                CardLayout cardLayout = (CardLayout) cards.getLayout();
                cardLayout.show(cards, DISPLAY_VEHICLE_RECORDS_PANEL);
                
            }
        }
    }
}
