package assignment1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author Laura Garcia/Austin Stamper
 */
public class Dealership {
    
    //Constant values
    public static final int MAX_VIN = 5;
    public static final int MAX_YEAR = 2016;

    //Create an instance of Car class	
    Car carRecord = new Car();
       
    
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
    
    
    //This function gets the user input for each field, then converts it to a string.
    //Then it puts the string into the ArrayList at the first index and so on. 
    public void addCar(){
        Scanner input = new Scanner(System.in);
        
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
        System.out.println("Enter the Mileage: " );
        int userMileage = input.nextInt();
        carRecord.setMileage(userMileage);
        
        //Get Price
        System.out.println("Enter the Price: " );
        Float userPrice = input.nextFloat();
        carRecord.setPrice(userPrice);
        
        //Add the data to the ArrayList
        String recordLine = carRecord.getVIN() + " " + carRecord.getYear() + " " 
                + carRecord.getMake() + " " + carRecord.getModel() + " " 
                + carRecord.getMileage() + " " + "$" 
                + String.format(java.util.Locale.US,"%.2f", carRecord.getPrice());
        
        carRecord.setRecord(recordLine);
        System.out.println();
    }
    
    
    /*
    This function gets the VIN from the user to delete the car record. It then
    calls removeElement() located in the Car class to remove the element from
    the ArrayList
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
    
    
    /*
    This function finds the car record and displays it based on the 
    VIN entered by the user
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
    
    
    
    //This function diplays the car records to the console for Option 1
    public void displayRecords(){
        for (String s : carRecord.getRecord()){
               System.out.println(s);
        }
        System.out.println();
    }
    
    
    
    //This function finds a car record between a certain price
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
