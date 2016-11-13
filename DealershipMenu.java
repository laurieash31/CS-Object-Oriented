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
    JPanel cards; //a panel that uses CardLayout
    
    //Names for each card
    final static String VEHICLEMANAGEMENTPANEL = "Vehicle Management";
    final static String TEXTPANEL = "Card with JTextField";

    
    public void addComponentToPane(Container pane) {
        
        //Put the JComboBox in a JPanel to switch between menus
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { VEHICLEMANAGEMENTPANEL, TEXTPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        //Add buttons to button group
        ButtonGroup radioButtonGroup = new ButtonGroup();
        JRadioButton displayButton = new JRadioButton("Display all vehicles");
        radioButtonGroup.add(displayButton);
        JRadioButton addButton = new JRadioButton("Add a vehicle");
        radioButtonGroup.add(addButton);
        JRadioButton deleteButton = new JRadioButton("Delete a vehicle");
        radioButtonGroup.add(deleteButton);
        JRadioButton searchButton = new JRadioButton("Search for a vehicle");
        radioButtonGroup.add(searchButton);
        JRadioButton priceSearchButton = new JRadioButton("Search price range");
        radioButtonGroup.add(priceSearchButton);
        
        //Add the action listeners to the radio buttons here later!!!!!!
        
        //Create the "cards" panels
        JPanel card1 = new JPanel(new GridLayout(0,1));
        card1.add(displayButton);
        card1.add(addButton);
        card1.add(deleteButton);
        card1.add(searchButton);
        card1.add(priceSearchButton);
        
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, VEHICLEMANAGEMENTPANEL);
        cards.add(card2, TEXTPANEL);
        
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
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        DealershipMenu demo = new DealershipMenu();
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
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
    }
}
