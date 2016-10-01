 /**
 *
 * @author Laura Garcia
 * @author Austin Stamper
 * @version 2.0
 */
package assignment2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



/** The class Dealership contains the methods used in Main.java */
public class Dealership {
      
    //Constant values
    public static final int MAX_VIN = 5;
    public static final int MAX_YEAR = 2016;
    public static final int MIN_MILEAGE = 0;
    public static final int MIN_PRICE = 0;
    public static final int MIN_LOADWT = 0;
    public static final int MIN_LENGTH = 0;

    //Create an instance of classes	
    Vehicle carRecord = new Vehicle();
    Truck truckRecord = new Truck();
    Motorcycle motoRecord = new Motorcycle();
    PassengerCar pCarRecord = new PassengerCar();
    User userRecord = new User();
    Employee employeeRecord = new Employee();
    Customer customerRecord = new Customer();
    
   
         
 /** 
 * This method tests if 'pCarRecords', 'truckRecords', 'employeeRecords',
 * 'customerRecords, and 'motoRecords' files exist before reading in data. 
 */
    //This function tests if cars.txt exists and creates files if it doesn't
    public void fileCheck(){
        
        //Creates 'pCarRecords' file
        File pCarFile = new File("pCarRecords");
        if(!pCarFile.exists())
        {
            try {
                    pCarFile.createNewFile();
            } catch (IOException ex) {
                System.err.println("Problem creating 'pCarRecords' file.");
            }
        }
        
        //Creates 'truckRecords' file
        File truckFile = new File("truckRecords");
        if(!truckFile.exists())
        {
            try {
                truckFile.createNewFile();
            } catch (IOException ex) {
                System.err.println("Problem creating 'truckRecords' file.");
            }
        }
        
        //Creates 'motoRecords' file
        File motoFile = new File("motoRecords");
        if(!motoFile.exists())
        {
            try {
                    motoFile.createNewFile();
            } catch (IOException ex) {
                System.err.println("Problem creating 'motoRecords' file.");
            }
        }
        
        //Creates 'employeeRecords' file
        File employeeFile = new File("employeeRecords");
        if(!employeeFile.exists())
        {
            try {
                    employeeFile.createNewFile();
            } catch (IOException ex) {
                System.err.println("Problem creating 'employeeRecords' file.");
            }
        }
        
        //Creates 'customerRecords' file
        File customerFile = new File("customerRecords");
        if(!customerFile.exists())
        {
            try {
                    customerFile.createNewFile();
            } catch (IOException ex) {
                System.err.println("Problem creating 'customerRecords' file.");
            }
        }
           
        System.out.println("Importing recorded data... ");
        System.out.println();    
    }

    
 /** 
 * This method reads serialized data in from 'pCarRecords', 'truckRecords',
 * 'employeeRecords', 'customerRecords', and 'motoRecords' files.
 * Data is stored in the ArrayList for each type of vehicle.
 */
    //This function reads data in from the vehicleDatabase file if there are 
    //car records already in the file. It stores them into the ArrayList.
    public void readRecords(){
        //Read passenger car records from database
        try{
            FileInputStream fin = new FileInputStream("pCarRecords");
            ObjectInputStream ois = new ObjectInputStream(fin);
            pCarRecord = (PassengerCar) ois.readObject();
            ois.close();
            
	}catch (ClassNotFoundException e) {
            System.err.println("Could not cast the de-serialized object");
            
        }catch (FileNotFoundException e) {
            
        }catch(Exception ex){
            ex.printStackTrace();
	}
        
        //Read truck records from database
        try{
            FileInputStream fin = new FileInputStream("truckRecords");
            ObjectInputStream ois = new ObjectInputStream(fin);
            truckRecord = (Truck) ois.readObject();
            ois.close();  
            
	}catch (ClassNotFoundException e) {
            System.err.println("Could not cast the de-serialized object");
        
        }catch (FileNotFoundException e) {
            
        }
        
        catch(Exception ex){
            ex.printStackTrace();
	}
        
        //Read motorcycle records from database
        try{
            FileInputStream fin = new FileInputStream("motoRecords");
            ObjectInputStream ois = new ObjectInputStream(fin);
            motoRecord = (Motorcycle) ois.readObject();
            ois.close();  
	}catch (ClassNotFoundException e) {
            System.err.println("Could not cast the de-serialized object");
            
        }catch (FileNotFoundException e) {
  
        }
        
        catch (Exception ex){
            ex.printStackTrace();
	}
        
        //Read customer records from the database
        try{
            FileInputStream fin = new FileInputStream("customerRecords");
            ObjectInputStream ois = new ObjectInputStream(fin);
            customerRecord = (Customer) ois.readObject();
            ois.close();  
	}catch (ClassNotFoundException e) {
            System.err.println("Could not cast the de-serialized object");
            
        }catch (FileNotFoundException e) {
  
        }
        
        catch (Exception ex){
            ex.printStackTrace();
	}
        
        //Read Employee records from database
        try{
            FileInputStream fin = new FileInputStream("employeeRecords");
            ObjectInputStream ois = new ObjectInputStream(fin);
            employeeRecord = (Employee) ois.readObject();
            ois.close();  
	}catch (ClassNotFoundException e) {
            System.err.println("Could not cast the de-serialized object");
            
        }catch (FileNotFoundException e) {
  
        }
        
        catch (Exception ex){
            ex.printStackTrace();
	}
    
    }
    
/** 
 * This method serializes userRecords, pCarRecords, truckRecords, and motoRecords into
 * serialized object files.
 */
    //This function serializes the objects into 'vehicleDatabase' "
    public void exportData(){
        //Serialze the passenger car data into 'pCarRecords'
        try {
            FileOutputStream fos = new FileOutputStream("pCarRecords");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pCarRecord);
            oos.close();
            fos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        //Serialze the truck data into 'truckRecords'
        try {
            FileOutputStream fos = new FileOutputStream("truckRecords");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(truckRecord);
            oos.close();
            fos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        //Serialze the motorcycle data into 'motoRecords'
        try {
            FileOutputStream fos = new FileOutputStream("motoRecords");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(motoRecord);
            oos.close();
            fos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        //Assuming I can put this here?
        try {
            FileOutputStream fos = new FileOutputStream("customerRecords");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customerRecord);
            oos.close();
            fos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        try {
            FileOutputStream fos = new FileOutputStream("employeeRecords");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employeeRecord);
            oos.close();
            fos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
 /** 
 * This method prints the users from the database.
 */
    public void printUsers() {
        
        System.out.println("ID  FIRST   LAST  USER SPECIFIC");
        System.out.println("..........................................");
        for (String s : customerRecord.getRecord()){
               System.out.println(s);
        }
        for (String s : employeeRecord.getRecord()){
               System.out.println(s);
        }

        System.out.println();
        
    }
    
 /** 
 * This method adds new users to the database.
 */
    public void addUser(){
        Scanner input = new Scanner(System.in);
        
        //Variables
        String uPNumber;
        String uFName;
        String uLName;
        String recordLine;
        int uID = 0;
        int uDLNumber = 0;
        int uBankAcct = 0;
        Float uMSalary;
        
        //Have user enter user type until type matches
        int userType = 0;
        do{
            System.out.println("What type of user?");
            System.out.println("Enter 1 for Employee or 2 for Customer: ");
            userType = input.nextInt();
        }while(userType != 1 && userType != 2);
       
        switch(userType) {
                
        case 1:       
        {
            //Get Variables for Employee
            System.out.println("What is the user ID?");
            uID = input.nextInt();
            employeeRecord.setID(uID);
            System.out.println("What is the First Name?");
            uFName = input.nextLine();
            employeeRecord.setFirstName(uFName);
            System.out.println("What is the Last Name");
            uLName = input.nextLine();
            employeeRecord.setLastName(uLName);
            System.out.println("What is the Monthly Salary?");
            uMSalary = input.nextFloat();
            employeeRecord.setMonthSalary(uMSalary);
            System.out.println("What is the Direct Deposit Account Number?");
            uBankAcct = input.nextInt();
            employeeRecord.setAccountNum(uBankAcct);
            
            recordLine = employeeRecord.getID() + " " + employeeRecord.getFirstName() + " " 
                + employeeRecord.getLastName() + " " + employeeRecord.getAccountNum() + " " 
                + "$" + String.format(java.util.Locale.US,"%.2f", employeeRecord.getMonthSalary());

            employeeRecord.setRecord(recordLine);
            
           break;     
        }
        
        //Get Customer info
        case 2:
        {
            System.out.println("What is the user ID?");
            uID = input.nextInt();
            customerRecord.setID(uID);
            System.out.println("What is the First Name?");
            uFName = input.nextLine();
            customerRecord.setFirstName(uFName);
            System.out.println("What is the Last Name?");
            uLName = input.nextLine();
            customerRecord.setLastName(uLName);
            System.out.println("What is the Phone Number?");
            uPNumber = input.nextLine();
            customerRecord.setPNumber(uPNumber);
            System.out.println("What is the Driver's License Number?");
            uDLNumber = input.nextInt();
            customerRecord.setDLNumber(uDLNumber);
            
            recordLine = customerRecord.getID() + " " + customerRecord.getFirstName() + " " 
                + customerRecord.getLastName() + " " + customerRecord.getPNumber()+ " " 
                + customerRecord.getDLNumber();

            employeeRecord.setRecord(recordLine);
            
            break;
        }
        }
            
         System.out.println();
    }
    
    /**
    * This method gets the user input for each field, then converts it to a 
    * string.Then it puts the string into the ArrayList at the first index and 
    * so on.
    */
    public void addVehicle(){
        Scanner input = new Scanner(System.in);
        
        //Variables
        String userVIN;
        String userMake;
        String userModel;
        String recordLine;
        int strLength = 0;
        int userYear = 0;
        Float userPrice;
        int userMileage;
        
        //Have user enter vehicle type until type matches
        int vehicleType = 0;
        do{
            System.out.println("What type of vehicle?");
            System.out.println("Enter 1 for Car, 2 for Truck, or 3 for Motorcycle: ");
            vehicleType = input.nextInt();
        }while(vehicleType != 1 && vehicleType != 2 && vehicleType != 3);
        
        switch (vehicleType) {
            
            //Figure out if it is car, truck, or motorcycle and get data
            case 1:
                //Get VIN
                do {
                    System.out.println("Enter the VIN: " );
                    input.nextLine();
                    userVIN = input.nextLine();
                    strLength = userVIN.length();
                } while(strLength != MAX_VIN);
                
                //Check for duplicate VIN in each
                for (String s : pCarRecord.getRecord()){
                    if (s.contains(userVIN) == true){
                        System.out.println();
                        System.out.println("This VIN exists! Car is stolen. Call Police! ");
                        System.out.println();
                        return;
                    }
                }
                for (String s : truckRecord.getRecord()){
                    if (s.contains(userVIN) == true){
                        System.out.println();
                        System.out.println("This VIN exists! Car is stolen. Call Police! ");
                        System.out.println();
                        return;
                    }
                }
                for (String s : motoRecord.getRecord()){
                    if (s.contains(userVIN) == true){
                        System.out.println();
                        System.out.println("This VIN exists! Car is stolen. Call Police! ");
                        System.out.println();
                        return;
                    }
                }
                
                pCarRecord.setVIN(userVIN.toUpperCase());
                
                //Get Year
                do {
                    System.out.println("Enter the Year: " );
                    userYear = input.nextInt();
                } while(userYear > MAX_YEAR);
                pCarRecord.setYear(userYear);
            
                //Get Make
                System.out.println("Enter the Make: " );
                input.nextLine();
                userMake = input.nextLine();
                pCarRecord.setMake(userMake);
            
                //Get Model
                System.out.println("Enter the Model: " );
                userModel = input.nextLine();
                pCarRecord.setModel(userModel);
            
                //Get Mileage
                do {
                    System.out.println("Enter the Mileage: " );
                    userMileage = input.nextInt();
                } while(userMileage < MIN_MILEAGE);
                pCarRecord.setMileage(userMileage);
                
                //Get Body Style
                System.out.println("Enter the Body Style: " );
                input.nextLine();
                String bodyStyle = input.nextLine();
                pCarRecord.setBodyStyle(bodyStyle);
                
                //Get the Price
                do {
                    System.out.println("Enter the Price: " );
                    userPrice = input.nextFloat();
                } while(userPrice < MIN_PRICE);
                pCarRecord.setPrice(userPrice);
                
                //Add the data to the ArrayList
                recordLine = pCarRecord.getVIN() + " " + pCarRecord.getYear() + " " 
                + pCarRecord.getMake() + " " + pCarRecord.getModel() + " " 
                + pCarRecord.getMileage() + " " + pCarRecord.getBodyStyle() + " " + "$" 
                + String.format(java.util.Locale.US,"%.2f", pCarRecord.getPrice());

                pCarRecord.setRecord(recordLine);
                
                break;
                
            case 2:
                //Get VIN
                do {
                    System.out.println("Enter the VIN: " );
                    input.nextLine();
                    userVIN = input.nextLine();
                    strLength = userVIN.length();
                } while(strLength != MAX_VIN);
                
                //Check for duplicate VIN in each
                for (String s : truckRecord.getRecord()){
                    if (s.contains(userVIN) == true){
                        System.out.println();
                        System.out.println("This VIN exists! Car is stolen. Call Police! ");
                        System.out.println();
                        return;
                    }
                }
                for (String s : pCarRecord.getRecord()){
                    if (s.contains(userVIN) == true){
                        System.out.println();
                        System.out.println("This VIN exists! Car is stolen. Call Police! ");
                        System.out.println();
                        return;
                    }
                }
                for (String s : motoRecord.getRecord()){
                    if (s.contains(userVIN) == true){
                        System.out.println();
                        System.out.println("This VIN exists! Car is stolen. Call Police! ");
                        System.out.println();
                        return;
                    }
                }
                
                truckRecord.setVIN(userVIN.toUpperCase());
                
                //Get Year
                do {
                    System.out.println("Enter the Year: " );
                    userYear = input.nextInt();
                } while(userYear > MAX_YEAR);
                truckRecord.setYear(userYear);
            
                //Get Make
                System.out.println("Enter the Make: " );
                input.nextLine();
                userMake = input.nextLine();
                truckRecord.setMake(userMake);
            
                //Get Model
                System.out.println("Enter the Model: " );
                userModel = input.nextLine();
                truckRecord.setModel(userModel);
            
                //Get Mileage
                do {
                    System.out.println("Enter the Mileage: " );
                    userMileage = input.nextInt();
                } while(userMileage < MIN_MILEAGE);
                truckRecord.setMileage(userMileage);
            
                //Get Load Weigth
                float loadWeight = 0;
                do{
                    System.out.println("Enter the Maximum Load Weight: " );
                    loadWeight = input.nextFloat();
                } while(loadWeight < MIN_LOADWT);
                truckRecord.setMaxLoadWeight(loadWeight);                
                
                //Get Length
                float length = 0;
                do{
                    System.out.println("Enter the Length in Feet: " );
                    length = input.nextFloat();
                } while(length < MIN_LENGTH);
                truckRecord.setLength(length); 

                //Get Price
                do {
                    System.out.println("Enter the Price: " );
                    userPrice = input.nextFloat();
                } while(userPrice < MIN_PRICE);
                truckRecord.setPrice(userPrice);                
                
                //Add the data to the ArrayList
                recordLine = truckRecord.getVIN() + " " + truckRecord.getYear() + " " 
                + truckRecord.getMake() + " " + truckRecord.getModel() + " " 
                + truckRecord.getMileage() + " " + truckRecord.getMaxLoadWeight() + " " 
                + truckRecord.getLength() + " " + "$" 
                + String.format(java.util.Locale.US,"%.2f", truckRecord.getPrice());

                truckRecord.setRecord(recordLine);
                
                break;
                
            case 3:             
                //Get VIN
                do {
                    System.out.println("Enter the VIN: " );
                    input.nextLine();
                    userVIN = input.nextLine();
                    strLength = userVIN.length();
                } while(strLength != MAX_VIN);
                
                //Check for duplicate VIN
                for (String s : motoRecord.getRecord()){
                    if (s.contains(userVIN) == true){
                        System.out.println();
                        System.out.println("This VIN exists! Car is stolen. Call Police! ");
                        System.out.println();
                        return;
                    }
                }
                for (String s : pCarRecord.getRecord()){
                    if (s.contains(userVIN) == true){
                        System.out.println();
                        System.out.println("This VIN exists! Car is stolen. Call Police! ");
                        System.out.println();
                        return;
                    }
                }
                for (String s : truckRecord.getRecord()){
                    if (s.contains(userVIN) == true){
                        System.out.println();
                        System.out.println("This VIN exists! Car is stolen. Call Police! ");
                        System.out.println();
                        return;
                    }
                }
                
                motoRecord.setVIN(userVIN.toUpperCase());
                
                //Get Year
                do {
                    System.out.println("Enter the Year: " );
                    userYear = input.nextInt();
                } while(userYear > MAX_YEAR);
                motoRecord.setYear(userYear);
            
                //Get Make
                System.out.println("Enter the Make: " );
                input.nextLine();
                userMake = input.nextLine();
                motoRecord.setMake(userMake);
            
                //Get Model
                System.out.println("Enter the Model: " );
                userModel = input.nextLine();
                motoRecord.setModel(userModel);
            
                //Get Mileage
                do {
                    System.out.println("Enter the Mileage: " );
                    userMileage = input.nextInt();
                } while(userMileage < MIN_MILEAGE);
                motoRecord.setMileage(userMileage);
                
                //Get Type
                System.out.println("Enter the Type: " );
                input.nextLine();
                String type = input.nextLine();
                motoRecord.setType(type);
                
                //Get Engine Displacement
                int eng = 0;
                System.out.println("Enter the Engine Displacement: " );
                eng = input.nextInt();
                motoRecord.setEngine(eng);
                
                //Get the Price
                do {
                    System.out.println("Enter the Price: " );
                    userPrice = input.nextFloat();
                } while(userPrice < MIN_PRICE);
                motoRecord.setPrice(userPrice);
                
                //Add the data to the ArrayList
                recordLine = motoRecord.getVIN() + " " + motoRecord.getYear() + " " 
                + motoRecord.getMake() + " " + motoRecord.getModel() + " " 
                + motoRecord.getMileage() + " " + motoRecord.getEngine() + " " 
                + motoRecord.getType() + " " + "$" 
                + String.format(java.util.Locale.US,"%.2f", motoRecord.getPrice());

                motoRecord.setRecord(recordLine);
                
                break;
        }
        System.out.println();
    }
    
    
    /**
    * This method gets the VIN from the user to delete the car record. It then
    * calls removeElement() located in the Car class to remove the element from
    * the ArrayList
    */
    public void deleteCar(){
        Scanner input = new Scanner(System.in);
        
        //Get VIN of car to be deleted
        System.out.print("Enter the VIN of car to be deleted: " );
        String userVIN = input.nextLine();
        userVIN = userVIN.toUpperCase();
        
        //Remove the car record with matching VIN
        pCarRecord.removeElement(userVIN);
        truckRecord.removeElement(userVIN);
        motoRecord.removeElement(userVIN);
        System.out.println();
    }
    
    
    /**
    * This method finds the car record and displays it based on the 
    * VIN entered by the user
    */
    public void checkCar(){       
        Scanner input = new Scanner(System.in);
        
        //Get VIN of car to search
        System.out.print("Enter the VIN of car to search for: " );
        String userVIN = input.nextLine();
        userVIN = userVIN.toUpperCase();
        System.out.println();
        
        //Find the matching car record VIN
        Boolean found = false;
        System.out.println("VIN   YEAR MAKE  MODEL  MILEAGE  PRICE");
        System.out.println("..........................................");
        for (String s : pCarRecord.getRecord()){
            if (s.contains(userVIN) == true){
                found = true;
                System.out.println(s + "\n");
            }
        }
        for (String s : truckRecord.getRecord()){
            if (s.contains(userVIN) == true){
                found = true;
                System.out.println(s + "\n");
            }
        }
        for (String s : motoRecord.getRecord()){
            if (s.contains(userVIN) == true){
                found = true;
                System.out.println(s + "\n");
            }
        }
        
        //If car is not found in the database...
        if (found == false){
            System.out.println("Sorry, car record does not exist." + "\n");
        }
    }
    
    
    /**
    * This method displays the car records to the console for Option 1.
    */ 
    public void displayRecords(){
        System.out.println("VIN   YEAR MAKE  MODEL  MILEAGE  PRICE");
        System.out.println("..........................................");
        for (String s : pCarRecord.getRecord()){
               System.out.println(s);
        }
        for (String s : truckRecord.getRecord()){
               System.out.println(s);
        }
        for (String s : motoRecord.getRecord()){
               System.out.println(s);
        }
        System.out.println();
    }
    
    
    /**
    * This method finds a car record between a certain price.
    */ 
    public void findPrice(){
        Scanner input = new Scanner(System.in);
        
        //Get type of vehicle to search prices
        int type;
        do{
            System.out.println("What type of vehicle do you want to search for?");
            System.out.println("Enter 1 for Car, 2 for Truck, or 3 for Motorcycle: ");
            type = input.nextInt();
        }while(type != 1 && type != 2 && type != 3);
        
        //Get the price range
        System.out.print("Enter the minimum of the price range: ");
        Float min_price = input.nextFloat();
        System.out.println();
        System.out.print("Enter the maximum of the price range: ");
        Float max_price = input.nextFloat();
        System.out.println();
        
        //Find cars within price range
        String temp;
        Boolean hasRecord = false;
        System.out.println("VIN   YEAR MAKE  MODEL  MILEAGE  PRICE");
        System.out.println("..........................................");
        
        switch (type) {
            case 1: 
                for (String s : pCarRecord.getRecord()){
            
                    //Get the price from the end of the car record   
                    temp = s.substring(s.indexOf("$") + 1 , s.length());
            
                    //Convert price to float
                    float price = Float.parseFloat(temp);
            
                    /*
                    Check if car record price is within user's price range and display
                    car record if it is.
                    */
                    if (price >= min_price && price <= max_price){
                        System.out.println(s);
                        hasRecord = true;
                    }              
                }
            break;
            
            case 2:        
                for (String s : truckRecord.getRecord()){
            
                    //Get the price from the end of the car record   
                    temp = s.substring(s.indexOf("$") + 1 , s.length());
            
                    //Convert price to float
                    float price = Float.parseFloat(temp);
            
                    /*
                    Check if car record price is within user's price range and display
                    car record if it is.
                    */
                    if (price >= min_price && price <= max_price){
                        System.out.println(s);
                        hasRecord = true;
                    }               
                }
            break;
            
            case 3:
                for (String s : motoRecord.getRecord()){
            
                    //Get the price from the end of the car record   
                    temp = s.substring(s.indexOf("$") + 1 , s.length());
            
                    //Convert price to float
                    float price = Float.parseFloat(temp);
            
                    /*
                    Check if car record price is within user's price range and display
                    car record if it is.
                    */
                    if (price >= min_price && price <= max_price){
                        System.out.println(s);
                        hasRecord = true;
                    }               
                }
            break;
        }
        
        System.out.println();
        
        //If no car record was found within the price range...
        if (hasRecord == false){
            System.out.println("Sorry, cannot find car within that "
                    + "price range." + "\n");
        }
    }
}
