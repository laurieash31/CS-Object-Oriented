/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    //This is needed for being able to store the string in the ArrayList	
    Car carRecord = new Car();
    
    
    //This function tests if cars.txt exists and creates files if it doesn't
    public void fileCheck(){
        try {
            File car_records = new File("cars.txt");
            if (car_records.createNewFile()){
                System.out.println("'cars.txt' has been created.");
            }
            else {
                System.out.println("Importing car record data... ");
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
    //Remove the printline debug statement that prints what's in the array elements. 
    public void addCar(){
        Scanner input = new Scanner(System.in);
        
        //Get VIN
        String userVIN;
        int strLength = 0;
        do {
            System.out.println("Enter the VIN: " );
            userVIN = input.nextLine();
            strLength = userVIN.length();
        } while(strLength != 5);
        carRecord.setVIN(userVIN.toUpperCase()); 
        
        //Get Year
        System.out.println("Enter the Year: " );
        int userYear = input.nextInt();
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
                + carRecord.getMileage() + " " + "$" + carRecord.getPrice();
        
        carRecord.setRecord(recordLine);
        System.out.println();
    }
    
    
    //Re-enter information that is to be deleted
    //Issue with this design is that it will delete the first read of input data
    //it finds. It will not delete a specifically designated slot entirely.
    public void deleteCar(){
        Scanner input = new Scanner(System.in);
        
        //Get VIN of car to be deleted
        System.out.println("Enter the VIN of car to be deleted: " );
        String userVIN = input.nextLine();
        userVIN = userVIN.toUpperCase();
        
        //Remove the car record with matching VIN
        carRecord.removeElement(userVIN);        
    }
    
    
    
    /*
    This function finds the car record and displays it based on the 
    VIN entered by the user
    */
    public void checkCar(){       
        Scanner input = new Scanner(System.in);
        
        //Get VIN of car to search
        System.out.println("Enter the VIN of car to search for: " );
        String userVIN = input.nextLine();
        userVIN = userVIN.toUpperCase();
        
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
        System.out.println("Enter the minimum of the price range: ");
        Float min_price = input.nextFloat();
        
        System.out.println("Enter the maximum of the price range: ");
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
