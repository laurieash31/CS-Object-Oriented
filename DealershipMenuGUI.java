package dealership;

/**
 * GUI.java
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;

/**
 * GUI class that implements the GUI functionality
 *
 * @author Laura Garcia
 * @author Austin Stamper
 */
public class DealershipMenuGUI extends JFrame implements ItemListener {
    
    //Initialize the logger
    private static final Logger logger = Logger.getLogger(DealershipMenuGUI.class.getName());
    
    //Create the arrays to hold the vehicle and user records
    private ArrayList<Vehicle> vehicleRecords = new ArrayList <>();
    private ArrayList<User> userRecords = new ArrayList <>();
    
    //Variable for card panels
    private JPanel cards;
    
    //Create the strings to hold menu drop-down options
    private final static String VEHICLE_MANAGEMENT_OPTION = "Vehicle Managment";
    private final static String USER_MANAGEMENT_OPTION = "User Management";
    private final static String TRANSACTION_MANAGEMENT_OPTION = "Transaction Management";
    
    //Vehicle Managment Radio Buttons and Submit Button
    private JRadioButton displayVehiclesButton;
    private JRadioButton addVehicleButton;
    private JRadioButton deleteVehicleButton;
    private JRadioButton searchVehicleButton;
    private JRadioButton searchVehiclePriceButton;
    private JButton submitVMButton;
    
    //User Management Radio Buttons and Submit Button
    private JRadioButton displayUsersButton;
    private JRadioButton addUserButton;
    private JRadioButton deleteUserButton;
    private JRadioButton updateUserButton;
    private JButton submitUMButtom;
    
    //Transaction Management Radio Buttons and Submit Button
    private JRadioButton displayTransactionsButton;
    private JRadioButton addTransactionButton;
    private JButton submitTMButton;
    
    
    /**
     * Constructor
     * 
     * @throws HeadlessException 
     */
    public DealershipMenuGUI() throws HeadlessException {
        super("Dealership");
        
        try{
            InitializeGUI();
            initializeEvents();
            
        }catch(Exception ex){
           logger.log(Level.WARNING, "Initialization failed.", ex); 
        }

    }
    
    /**
     * Initializes the GUI and sets all the components to it
     */
    private void InitializeGUI() {
        
        //Create the content pane
        Container pane = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create the panel that contains the "cards"
        cards = new JPanel(new CardLayout());
        
        //Create a ComboBox for drop-down menu
        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = { VEHICLE_MANAGEMENT_OPTION, USER_MANAGEMENT_OPTION, TRANSACTION_MANAGEMENT_OPTION };
        
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        /* Create all of the cards and their layout */
        
        //Vehicle Management Panel
        JPanel vehicleManagementPanel = new JPanel(new GridLayout(0, 1));
        displayVehiclesButton =  new JRadioButton("Display vehicles");
        displayVehiclesButton.setSelected(true);
        addVehicleButton = new JRadioButton("Add a vehicle");
        deleteVehicleButton = new JRadioButton("Delete a vehicle");
        searchVehicleButton = new JRadioButton("Search for a vehicle by VIN");
        searchVehiclePriceButton = new JRadioButton("Search for vehicles by price");
        
        //Create a button group to hold vehicle management buttons, add each button
        ButtonGroup group = new ButtonGroup();
        group.add(displayVehiclesButton);
        group.add(addVehicleButton);
        group.add(deleteVehicleButton);
        group.add(searchVehicleButton);
        group.add(searchVehiclePriceButton);
        
        //Add the buttons to the Vehicle Management Panel
        vehicleManagementPanel.add(displayVehiclesButton);
        vehicleManagementPanel.add(addVehicleButton);
        vehicleManagementPanel.add(deleteVehicleButton);
        vehicleManagementPanel.add(searchVehicleButton);
        vehicleManagementPanel.add(searchVehiclePriceButton);
        
        //Initialize the submitVM buttom and add to Vehicle Management Panel
        submitVMButton = new JButton("Submit");
        vehicleManagementPanel.add(submitVMButton);
        
        
        
        //User Management Panel
        JPanel userManagementPanel = new JPanel(new GridLayout(0, 1));
        displayUsersButton =  new JRadioButton("Display users");
        displayUsersButton.setSelected(true);
        addUserButton = new JRadioButton("Add a user");
        deleteUserButton = new JRadioButton("Delete a user");
        updateUserButton = new JRadioButton("Update a user's information");
        
        //Create a button group to hold user management buttons, add each button
        ButtonGroup userRadioGroup = new ButtonGroup();
        userRadioGroup.add(displayUsersButton);
        userRadioGroup.add(addUserButton);
        userRadioGroup.add(deleteUserButton);
        userRadioGroup.add(updateUserButton);
        
        //Add the buttons to the User Management Panel
        userManagementPanel.add(displayUsersButton);
        userManagementPanel.add(addUserButton);
        userManagementPanel.add(deleteUserButton);
        userManagementPanel.add(updateUserButton);
        
        //Initialize the submitVM buttom and add to User Management Panel
        submitUMButtom = new JButton("Submit");
        userManagementPanel.add(submitUMButtom);
        
        
        
        //Transaction Management Panel
        JPanel transManagementPanel = new JPanel(new GridLayout(0, 1));
        displayTransactionsButton =  new JRadioButton("Display transactions");
        displayTransactionsButton.setSelected(true);
        addTransactionButton = new JRadioButton("Add a transaction");
        
        //Create a button group to hold transaction management buttons, add each button
        ButtonGroup transRadioGroup = new ButtonGroup();
        transRadioGroup.add(displayTransactionsButton);
        transRadioGroup.add(addTransactionButton);
        
        //Add the buttons to the Transaction Management Panel
        transManagementPanel.add(displayTransactionsButton);
        transManagementPanel.add(addTransactionButton);
        
        //Initialize the submitTM buttom and add to Transaction Management Panel
        submitTMButton = new JButton("Submit");
        transManagementPanel.add(submitTMButton);
        
        
        
        //Add each Management Panel to the cards
        cards.add(vehicleManagementPanel, VEHICLE_MANAGEMENT_OPTION);
        cards.add(userManagementPanel, USER_MANAGEMENT_OPTION);
        cards.add(transManagementPanel, TRANSACTION_MANAGEMENT_OPTION);
        
        
        //Add the Combo Box and layout to frame
        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(cards, BorderLayout.CENTER);
    }
    
    /**
     * <CODE>initializeEvents()</CODE> calls the functions based on which button
     * is clicked. 
     * Uses <CODE>ActionListener()</CODE> to do so. 
     * Calls the functions to implement the actions
     */
    private void initializeEvents() {
        
        //Adds the action listener to the Vehicle Management Button
        submitVMButton.addActionListener(new ActionListener () { 
            
            public void actionPerformed(ActionEvent e) {
                if (displayVehiclesButton.isSelected()) {
                    showAllVehicles();
                }
                else if (addVehicleButton.isSelected()) {
                    addNewVehicle();
                }
                else if (deleteVehicleButton.isSelected()) {
                    deleteVehicle();
                }
                else if (searchVehicleButton.isSelected()) {
                    searchVehicleByVin();
                }
                else if (searchVehiclePriceButton.isSelected()) {
                    searchVehicleByPrice();
                }
            }
        });
        
        //Adds the action listener to the User Management Button
        submitUMButtom.addActionListener(new ActionListener () { 
            
            public void actionPerformed(ActionEvent e) {
                
                if (displayUsersButton.isSelected()) {
                    showAllUsers();
                }
                else if (addUserButton.isSelected()) {
                    addNewUser();
                }
                else if (deleteUserButton.isSelected()) {
                    deleteUser();
                }
                else if (updateUserButton.isSelected()) {
                    updateUser();
                }
            }
        });
        
        //Adds the action listener to the Transaction Management Button
        submitTMButton.addActionListener(new ActionListener () { 
            
        public void actionPerformed(ActionEvent e) {

                if (displayTransactionsButton.isSelected()) {
                    showAllTransactions();
                }
                else if (addTransactionButton.isSelected()) {
                    addNewTransaction();
                }
            }
        });
    }
    
    /**
     * <CODE>itemStateChanged()</CODE> detects when changing cards
     * @param evt 
     */
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    
    
    
    
    /**
     * The <CODE>showAllVehicles()</CODE> method prints out all the vehicle 
     * currently in the inventory, in a formatted manner on a JTable.
     */
    private void showAllVehicles() {
        
        //Create a panel for the headers
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        //Create the columns
        String columns[] = {"VIN", "MAKE", "MODEL", "YEAR", "MILEAGE", "PRICE", "EXTRA INFO 1", "EXTRA INFO 2"};
      
        //Create an array to hold the vehicle data
        int size = vehicleRecords.size();
        String dataValues[][] = new String[size][];
        
        int counter = 0;
        for (Vehicle v : vehicleRecords) {
            
            String splitData[] = v.getFormattedText().split(" ");
            
            if(splitData.length == 7){
                
                String temp[]= new String[8];
                
                System.arraycopy(splitData, 0, temp, 0, 7);
                
                temp[7] = "None";
                
                dataValues[counter] = temp;
            }
            else{
                dataValues[counter] = splitData;
            }
            counter++;
        }
        
        // Create a new table instance
        JTable table = new JTable(dataValues, columns);
        table.setFillsViewportHeight(true);

        //Add the table to a scrolling pane
        JScrollPane scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(this, topPanel, "Vehicle Information", JOptionPane.PLAIN_MESSAGE);
    }
    
    
    /**
     * <CODE>addNewVehicle()</CODE> takes the input from the text fields and 
     * adds it to the ArrayList
     */
    private void addNewVehicle() {
        
        //Create a new panel for Add Vehicle
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new FormLayout());
        
        //Add a label and text field to the panel
        panel.add(new JLabel("VIN"));
        JTextField vinField = new JTextField(5);
        panel.add(vinField);
        
        panel.add(new JLabel("Make"));
        JTextField makeField = new JTextField(20);
        panel.add(makeField);
        
        panel.add(new JLabel("Model"));
        JTextField modelField = new JTextField(20);
        panel.add(modelField);
        
        panel.add(new JLabel("Year"));
        JTextField yearField = new JTextField(4);
        panel.add(yearField);
       
        
        panel.add(new JLabel("Mileage"));
        JTextField mileageField = new JTextField(6);
        panel.add(mileageField);
       
        
        panel.add(new JLabel("Price"));
        JTextField priceField = new JTextField(8);
        panel.add(priceField);
       
        //Create a label to select the type of vehicle
        panel.add(new JLabel("Vehicle type:"));
        
        
        //Create radio buttons for each type of vehicle
        JRadioButton carButton = new JRadioButton("Passenger Car");
        carButton.setSelected(true);
        JRadioButton truckButton = new JRadioButton("Truck");
        JRadioButton motorcycleButton = new JRadioButton("Motorcycle");
        
        //Create a button group for the 3 vehicle types, add the buttons
        ButtonGroup group = new ButtonGroup();
        group.add(carButton);
        group.add(truckButton);
        group.add(motorcycleButton);
        
        
        //Create a panel to hold the vehicle type buttons
        JPanel vehicleTypePanel = new JPanel(new FlowLayout());
        vehicleTypePanel.add(carButton);
        vehicleTypePanel.add(truckButton);
        vehicleTypePanel.add(motorcycleButton);
        
        //Add the vehicle type panel to the current panel
        panel.add(vehicleTypePanel);
        
        //Add a label and text field for more vehicle information
        panel.add(new JLabel("More information 1"));
        JTextField moreInfoField1 = new JTextField(20);
        panel.add(moreInfoField1);
     
        panel.add(new JLabel("More information 2"));
        JTextField moreInfoField2 = new JTextField(20);
        panel.add(moreInfoField2);
        
        //Show the option pane and added the ability to Okay or Cancel
        JOptionPane.showOptionDialog(this, panel, "Add a new vehicle", 
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
        
        /* Create the variables to hold the user input from the form */
        
        String vin = vinField.getText();
        vin = vin.toUpperCase();
        
        //Check for duplicate VIN in the database
        for (Vehicle s : vehicleRecords){
            if (s.toString().contains(vin) == true){
                JOptionPane.showMessageDialog(null, "This VIN exists! Car is stolen. Call Police! ");
                return;
            }
        }
        
        String make = makeField.getText();
        String model = modelField.getText();
        
        String year = yearField.getText();
        //Check year greater than 2016
        if (Integer.parseInt(year) > 2016){
            JOptionPane.showMessageDialog(null, "This dealership does not accept concept cars.");
            return;
        }
        
        String mileage = mileageField.getText();
        //Check that the mileage is greater than 0
        if (Integer.parseInt(mileage) < 0){
            JOptionPane.showMessageDialog(null, "Vehicle cannot have negative miles. Try again.");
            return;
        }
        
        String price = priceField.getText();
        //Check that the mileage is greater than 0
        if (Float.parseFloat(price) < 0){
            JOptionPane.showMessageDialog(null, "Vehicle cannot have a negative price. "
                    + "It would bankrupt the dealership. Try again.");
            return;
        }
        
        String moreInfo1 = moreInfoField1.getText();
        String moreInfo2 = moreInfoField2.getText();
        
        //If the car radio buttom is selected, format data for car and add to record
        if(carButton.isSelected()){
            
            try{
                
                int yr  = Integer.parseInt(year);
                int mil  = Integer.parseInt(mileage);
                float pr  = Float.parseFloat(price);
                
                PassengerCar temp = new PassengerCar(vin, make, model, yr, mil, 
                        pr, moreInfo1);
                
                vehicleRecords.add(temp);
                
            }catch(Exception ex){
                logger.log(Level.SEVERE, "Number Format Exception", ex); 
            }

        }
        
        //If the truck radio buttom is selected, format data for truck and add to record
        if(truckButton.isSelected()){
            
            try{
                
                int yr  = Integer.parseInt(year);
                int mil  = Integer.parseInt(mileage);
                float pr  = Float.parseFloat(price);
                float loadWeight = Float.parseFloat(moreInfo1);
                float length = Float.parseFloat(moreInfo2);
                Truck temp = new Truck(vin, make, model, yr, mil, pr, 
                        loadWeight, length);
                
                vehicleRecords.add(temp);
                
            }catch(Exception ex){
                logger.log(Level.SEVERE, "Number Format Exception", ex);
            }
        }
        
        //If the truck radio buttom is selected, format data for truck and add to record
        if(motorcycleButton.isSelected()){
            
            try{
                
                int yr  = Integer.parseInt(year);
                int mil  = Integer.parseInt(mileage);
                float pr  = Float.parseFloat(price);
                int eng = Integer.parseInt(moreInfo2);
                
                Motorcycle temp = new Motorcycle(vin,
                        make, model, yr, mil, pr, moreInfo1, eng);

                vehicleRecords.add(temp);
                
            }catch(Exception ex){
                logger.log(Level.SEVERE, "Number Format Exception", ex);
            }
        }
    }
    
    
    /**
     * <CODE>deleteVehicle()</CODE> removes the specified vehicle from the ArrayList
     */
    private void deleteVehicle() {
        
        //Create the Delete Vehicle panel
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new FormLayout());
        
        //Create a label and text field to add to the panel
        panel.add(new JLabel("Enter the VIN to delete"));
        JTextField toDelete = new JTextField(5);
        panel.add(toDelete);
        
        //Message at top of panel
        JOptionPane.showMessageDialog(this, panel, "Delete vehicle", JOptionPane.PLAIN_MESSAGE);
        
        //Get the VIN to delete and delete the vehicle record
        String vinToDelete = toDelete.getText();
        
        for (Vehicle v : vehicleRecords) {
            
            if (v.getVin().equals(vinToDelete)) {
                
                vehicleRecords.remove(v);
                break;
            }
        }
    }
    
    
    
    /**
     * <CODE>searchVehicleByVin()</CODE> searches for the vehicle record with the
     * matching VIN input from the user.
     * It then creates a table to display the record of the vehicle.
     */
    private void searchVehicleByVin() {
        
        //Create the top panel to display the header
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);
        
        //Create the panel to display the form
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new FormLayout());
        
        //Create a label and text field to search for a VIN
        panel.add(new JLabel("Enter VIN to search"));
        JTextField toSearch = new JTextField(5);
        panel.add(toSearch);
        
        //Create message at top of pane
        JOptionPane.showMessageDialog(this, panel, "Search vehicle by VIN", JOptionPane.PLAIN_MESSAGE);
        
        //Get the user input
        String userVIN = toSearch.getText();
        
        //Create a temp ArrayList to store the matching VIN record to
        ArrayList<Vehicle> foundVehicle = new ArrayList<Vehicle>();
        
        for (Vehicle v : vehicleRecords) {
            
            if (v.getVin().equals(userVIN)) {
                foundVehicle.add(v);
            }
        }
        
        //Create column header
        String columnsHeader[] = {"VIN", "MAKE", "MODEL", "YEAR", "MILEAGE", "PRICE", "MORE INFO 1", "MORE INFO 2"};
      
        //Create an array to store and display record
        int size = foundVehicle.size();
        String vehicleData[][] = new String[size][];
        
        int counter = 0;
        
        for (Vehicle v : foundVehicle) {
            
            //Split the vehicle record to display
            String splitRecord[] = v.getFormattedText().split(" ");
            
            if(splitRecord.length == 7){
                
                String temp[]= new String[8];
                
                System.arraycopy(splitRecord, 0, temp, 0, 7);
                
                temp[7] = "None";
                
                vehicleData[counter] = temp;
            }
            else{
                vehicleData[counter] = splitRecord;
            }
            counter++;
        }
        
        //Create a table to display the data
        JTable table = new JTable(vehicleData, columnsHeader);
        table.setFillsViewportHeight(true);

        //Add the table to a scrolling pane
        JScrollPane scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(this, topPanel, "Search results", JOptionPane.PLAIN_MESSAGE);   
    }
    
    
    
    /**
     * <CODE>searchVehicleByPrice()</CODE> searches the database for vehicles
     * within a certain price range, as input by the user.
     */
    private void searchVehicleByPrice() {
        
        //Create the top panel to display the header
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);
        
        //Create the panel to display the form
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new FormLayout());
        
        
        //Create labels and text fields to search the price range for
        panel.add(new JLabel("Minimum price"));
        JTextField minimum = new JTextField(8);
        panel.add(minimum);
        panel.add(new JLabel("Maximum price"));
        JTextField maximum = new JTextField(8);
        panel.add(maximum);
        
        //Add label for Vehicle Type radio buttons
        panel.add(new JLabel("Vehicle type:"));
        
        //Create the radio buttons for the vehicle types
        JRadioButton carButton = new JRadioButton("Passenger Car");
        carButton.setSelected(true);
        JRadioButton truckButton = new JRadioButton("Truck");
        JRadioButton motorcycleButton = new JRadioButton("Motorcycle");
        
        //Create the button group to hold the vehicle type radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(carButton);
        group.add(truckButton);
        group.add(motorcycleButton);
        
        //Create a panel to hold the radio buttons and add the buttons
        JPanel vehicleTypePanel = new JPanel(new FlowLayout());
        vehicleTypePanel.add(carButton);
        vehicleTypePanel.add(truckButton);
        vehicleTypePanel.add(motorcycleButton);
        panel.add(vehicleTypePanel);
        
        //Create the message for the top of the panel
        JOptionPane.showMessageDialog(this, panel, "Search vehicles by price", JOptionPane.PLAIN_MESSAGE);
        
        //Create the variables to hold the minimum and maximum prices
        String min = minimum.getText();
        String max = maximum.getText();
        float minPrice = Float.parseFloat(min);
        float maxPrice = Float.parseFloat(max);
        
        //Check that the prices are greater than 0
        if (minPrice < 0 || maxPrice < 0) {
            
            JOptionPane.showMessageDialog(null, "Vehicle cannot have a negative price. "
                    + "It would bankrupt the dealership. Try again.");
            return;
        }
        
        //Create a temp ArrayList to store the matching VIN record to
        ArrayList<Vehicle> foundVehicles = new ArrayList<>();

        //If car button is selected, add the vehicle within the price range to the temp array
        if(carButton.isSelected()){
            
            for (Vehicle v : vehicleRecords) {
                
                if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
                    
                    if (v instanceof PassengerCar) {
                        foundVehicles.add(v); 
                    }           
                }
            }
        }
        
        //If truck button is selected, add the vehicle within the price range to the temp array
        if(truckButton.isSelected()){
            
            for (Vehicle v : vehicleRecords) {
                
                if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
                    
                    if (v instanceof Truck) {
                        foundVehicles.add(v);
                    }
                }
            }
        }
        
        //If motorcycle button is selected, add the vehicle within the price range to the temp array
        if(motorcycleButton.isSelected()){
            
            for (Vehicle v : vehicleRecords) {
                
                if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
                    
                    if (v instanceof Motorcycle) {
                        foundVehicles.add(v);
                    }
                }
            }   
        }
         
        //Create the column headers
        String columnsHeader[] = {"VIN", "MAKE", "MODEL", "YEAR", "MILEAGE", "PRICE", "MORE INFO 1", "MORE INFO 2"};//"EXTRA DETAILS 2"
      
        //Create a temp array to store the records
        int size = foundVehicles.size();
        String vehicleRecordData[][] = new String[size][];
        
        int counter = 0;
        
        //Split the vehicle record to display
        for (Vehicle v : foundVehicles) {
            
            String splitRecord[] = v.getFormattedText().split(" ");
            
            if(splitRecord.length == 7) {
                
                String temp[]= new String[8];
                
                System.arraycopy(splitRecord, 0, temp, 0, 7);
                
                temp[7] = "None";
                
                vehicleRecordData[counter] = temp;
            }
            else{
                vehicleRecordData[counter] = splitRecord;
            }
            counter++;
        }
        
        //Create a table to display the data
        JTable table = new JTable(vehicleRecordData, columnsHeader);
        table.setFillsViewportHeight(true);

        //Add the table to a scrolling pane
        JScrollPane scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(this, topPanel,"Search vehicles by price", JOptionPane.PLAIN_MESSAGE);
    }
    
    
    
    
    private void showAllUsers() {
        
        //Create a panel for the headers
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        //Create the columns
        String columns[] = {"User Type", "ID", "First Name", "Last Name", "Extra Information 1", "Extra Information 2"};
      
        //Create an array to hold the User data
        int size = userRecords.size();
        String dataValues[][] = new String[size][];
        
        int counter = 0;
        for (User u : userRecords) {
            
            String splitData[] = u.getFormattedText().split(" ");
            
            if(splitData.length == 7){
                
                String temp[]= new String[8];
                
                System.arraycopy(splitData, 0, temp, 0, 7);
                
                temp[7] = "None";
                
                dataValues[counter] = temp;
            }
            else{
                dataValues[counter] = splitData;
            }
            counter++;
        }
        
        // Create a new table instance
        JTable table = new JTable(dataValues, columns);
        table.setFillsViewportHeight(true);

        //Add the table to a scrolling pane
        JScrollPane scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(this, topPanel, "User Information", JOptionPane.PLAIN_MESSAGE);
        
    }
    
    
    
    
    private void addNewUser() {
        
        //Create a new panel for Add User
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new FormLayout());
        
        //Add a label and text field to the panel
        panel.add(new JLabel("ID"));
        JTextField idField = new JTextField(10);
        panel.add(idField);
        
        panel.add(new JLabel("First Name"));
        JTextField fNameField = new JTextField(20);
        panel.add(fNameField);
        
        panel.add(new JLabel("Last Name"));
        JTextField lNameField = new JTextField(20);
        panel.add(lNameField);
       
        //Create a label to select the type of vehicle
        panel.add(new JLabel("User type:"));       
        
        //Create radio buttons for each type of vehicle
        JRadioButton customerButton = new JRadioButton("Customer");
        customerButton.setSelected(true);
        JRadioButton employeeButton = new JRadioButton("Employee");
        
        //Create a button group for the 3 vehicle types, add the buttons
        ButtonGroup group = new ButtonGroup();
        group.add(customerButton);
        group.add(employeeButton);        
        
        //Create a panel to hold the vehicle type buttons
        JPanel userTypePanel = new JPanel(new FlowLayout());
        userTypePanel.add(customerButton);
        userTypePanel.add(employeeButton);
        
        //Add the vehicle type panel to the current panel
        panel.add(userTypePanel);
        
        //Add a label and text field for more vehicle information
        panel.add(new JLabel("More information 1"));
        JTextField moreInfoField1 = new JTextField(20);
        panel.add(moreInfoField1);
     
        panel.add(new JLabel("More information 2"));
        JTextField moreInfoField2 = new JTextField(20);
        panel.add(moreInfoField2);
        
        //Show the option pane and added the ability to Okay or Cancel
        JOptionPane.showOptionDialog(this, panel, "Add a new user", 
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
        
        /* Create the variables to hold the user input from the form */
        
        //Check for duplicate ID in the database
        //for (User s : userRecords){
        //    if (s.toString().contains(s) == true){
        //        JOptionPane.showMessageDialog(null, "This ID exists, maybe you already have an account?");
        //        return;
        //    }
        //}
        
        String ID = idField.getText();
        String fName = fNameField.getText();        
        String lName = lNameField.getText();
        
        String moreInfo1 = moreInfoField1.getText();
        String moreInfo2 = moreInfoField2.getText();
        
        //If the customer button is selected, format data for customer and add to record
        if(customerButton.isSelected()){
            
            try{
                int dLNum = Integer.parseInt(moreInfo2);
                int id = Integer.parseInt(ID);
                Customer temp = new Customer(id, fName, lName, moreInfo1, dLNum);
                
                userRecords.add(temp);
                
            }catch(Exception ex){
                logger.log(Level.SEVERE, "Number Format Exception", ex); 
            }

        }
        
        //If the employee radio buttom is selected, format data for employee and add to record
        if(employeeButton.isSelected()){
            
            try{
                float salary = Float.parseFloat(moreInfo1);
                int acctNum = Integer.parseInt(moreInfo2);                
                int id  = Integer.parseInt(ID);
                
                Employee temp = new Employee(id, fName, lName, salary, acctNum);
                
                userRecords.add(temp);
                
            }catch(Exception ex){
                logger.log(Level.SEVERE, "Number Format Exception", ex);
            }
        }   
    }
    
    private void deleteUser() {
        
        //Create the Delete Vehicle panel
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new FormLayout());
        
        //Create a label and text field to add to the panel
        panel.add(new JLabel("Enter the ID to delete"));
        JTextField toDelete = new JTextField(10);
        panel.add(toDelete);
        
        //Message at top of panel
        JOptionPane.showMessageDialog(this, panel, "Delete user", JOptionPane.PLAIN_MESSAGE);
        
        //Get the ID to delete and delete the vehicle record
        String id = toDelete.getText();
        int idToDelete = Integer.parseInt(id);
        
        for (User u : userRecords) {
            
            if (u.getId() == idToDelete) {
                userRecords.remove(u);
                break;
            } else {
            }
        }
    }

    
    
    private void updateUser() {
       

    }       

    
    private void showAllTransactions() {
        
    }   

    
    
    private void addNewTransaction() {
        
    }       
}
