 /**
 *
 * @author Laura Garcia
 * @author Austin Stamper
 * @version 1.0
 */
package assignment2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

/** The class Dealership contains the methods used in Main.java */
public class Dealership {
      
    //Constant values
    public static final int MAX_VIN = 5;
    public static final int MAX_YEAR = 2016;
    public static final int MIN_MILEAGE = 0;
    public static final int MIN_PRICE = 0;

    //Create an instance of Car class	
    Vehicle carRecord = new Vehicle();
    
    
       
 /** 
 * This method tests if cars.txt exists and creates a file if it doesn't. 
 */
    //This function tests if cars.txt exists and creates files if it doesn't
    public void fileCheck(){
        try {
            File car_records = new File("cars.txt");
            if (car_records.createNewFile()){
                System.out.println("'cars.txt' has been created.");
                System.out.println();
            }
            else {
                System.out.println("Importing car record data... ");
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("There was a problem creating 'cars.txt' ");
            e.printStackTrace();
        }
    }
    
 /** 
 * This method reads data in from the cars.txt file if it exists. Data is stored
 * in the ArrayList.
 */
    //This function reads data in from the cars.txt file if there are 
    //car records already in the file. It stores them into the ArrayList.
    public void readRecords(){
        try (BufferedReader br = new BufferedReader(new FileReader("cars.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                carRecord.setRecord(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        
    }
    
/** 
 * This method exports car records into the file "cars.txt".
 */
    //This function places the car records into "cars.txt"
    public void exportData(){
        try {
            PrintWriter outFile = new PrintWriter("cars.txt");
            for (String s : carRecord.getRecord()){
               outFile.println(s);
            }
            outFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
    
    /**
    * This method gets the user input for each field, then converts it to a 
    * string.Then it puts the string into the ArrayList at the first index and 
    * so on.
    */
    public void addVehicle(){
        Scanner input = new Scanner(System.in);
        
        String vehicleType = null;
        System.out.println("What type of vehicle? (Motorcycle, Truck, or Car)" );
        vehicleType = input.nextLine();
        
        switch (vehicleType) {
            
            //Figure out if it is Truck, Motorcycle, or Car and get unique data
            //Still needs some debugging
            case "Truck":
                Truck truckRecord = new Truck();
                float loadWeight = 0;
                float length = 0;
                System.out.println("Enter the Maximum Load Weight: " );
                loadWeight = input.nextFloat();
                System.out.println("Enter the Length in Feet: " );
                length = input.nextFloat();
                truckRecord.setLength(length);
                truckRecord.setMaxLoadWeight(loadWeight);
                break;
            case "Motorcycle":
                Motorcycle motoRecord = new Motorcycle();
                String type = null;
                int eng = 0;
                System.out.println("Enter the Type: " );
                type = input.nextLine();
                System.out.println("Enter the Engine Displacement: " );
                eng = input.nextInt();
                motoRecord.setEngine(eng);
                motoRecord.setType(type);
                break;
            case "Car":
                PassengerCar pCarRecord = new PassengerCar();
                String bodyStyle = null;
                System.out.println("Enter the Body Style: " );
                bodyStyle = input.nextLine();
                pCarRecord.setBodyStyle(bodyStyle);
                break;
        }
        
        //Get VIN
        String userVIN;
        int strLength = 0;
        do {
            System.out.println("Enter the VIN: " );
            userVIN = input.nextLine();
            strLength = userVIN.length();
        } while(strLength != MAX_VIN);
        carRecord.setVIN(userVIN.toUpperCase()); 
        
        //Get Year
        int userYear = 0;
        do {
            System.out.println("Enter the Year: " );
            userYear = input.nextInt();
        } while(userYear > MAX_YEAR);
        carRecord.setYear(userYear);
        
        //Get Make
        System.out.println("Enter the Make: " );
        input.nextLine();
        String userMake = input.nextLine();
        carRecord.setMake(userMake);
        
        //Get Model
        System.out.println("Enter the Model: " );
        String userModel = input.nextLine();
        carRecord.setModel(userModel);
        
        //Get Mileage
        int userMileage;
        do {
            System.out.println("Enter the Mileage: " );
            userMileage = input.nextInt();
        } while(userMileage < MIN_MILEAGE);
        carRecord.setMileage(userMileage);
        
        //Get Price
        Float userPrice;
        do {
            System.out.println("Enter the Price: " );
            userPrice = input.nextFloat();
        } while(userPrice < MIN_PRICE);
        carRecord.setPrice(userPrice);
        
        
        
        //Add the data to the ArrayList
        String recordLine = carRecord.getVIN() + " " + carRecord.getYear() + " " 
                + carRecord.getMake() + " " + carRecord.getModel() + " " 
                + carRecord.getMileage() + " " + "$" 
                + String.format(java.util.Locale.US,"%.2f", carRecord.getPrice());
        
        //Initital idea was to add the variables unique to the different vehicles
        //through a similar switch case to the one at the top but it isn't permitted.
        //States that recordLine is already defined.
        /*switch (vehicleType) {                      
            case "Truck":
                String recordLine = carRecord.getVIN() + " " + carRecord.getYear() + " " 
                + carRecord.getMake() + " " + carRecord.getModel() + " " 
                + carRecord.getMileage() + " " + "$" 
                + String.format(java.util.Locale.US,"%.2f", carRecord.getPrice())
                + truckRecord.getLength();
                
                break;
            case "Motorcycle":
                String recordLine = carRecord.getVIN() + " " + carRecord.getYear() + " " 
                + carRecord.getMake() + " " + carRecord.getModel() + " " 
                + carRecord.getMileage() + " " + "$" 
                + String.format(java.util.Locale.US,"%.2f", carRecord.getPrice());
                
                break;
            case "Car":
                String recordLine = carRecord.getVIN() + " " + carRecord.getYear() + " " 
                + carRecord.getMake() + " " + carRecord.getModel() + " " 
                + carRecord.getMileage() + " " + "$" 
                + String.format(java.util.Locale.US,"%.2f", carRecord.getPrice());
                
                break;*/
        
        carRecord.setRecord(recordLine);
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
        carRecord.removeElement(userVIN); 
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
        for (String s : carRecord.getRecord()){
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
        for (String s : carRecord.getRecord()){
               System.out.println(s);
        }
        System.out.println();
    }
    
    
    /**
    * This method finds a car record between a certain price.
    */ 
    public void findPrice(){
        Scanner input = new Scanner(System.in);
        
        //Get user input to set the price range
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
        for (String s : carRecord.getRecord()){
            
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
        System.out.println();
        
        //If no car record was found within the price range...
        if (hasRecord == false){
            System.out.println("Sorry, cannot find car within that "
                    + "price range." + "\n");
        }
    }
}
