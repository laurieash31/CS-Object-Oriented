/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.PrintWriter;

/**
 *
 * @author Laura Garcia/Austin Stamper
 */
public class Dealership {

    //This is needed for being able to store the string in the ArrayList	
    Car carRecord = new Car();
    
    //Used to figure out if cars have been added or removed.
    //Increases in either situation to switch the output function on
    public int counter(int count) {
        count++;
        return count;
    }
    
    
    //This function tests if cars.txt exists and creates files if it doesn't
    public void fileCheck(){
        try {
                File car_records = new File("cars.txt");
                if (car_records.createNewFile()){
                //Debug to check when creating new cars.txt file
	        //System.out.println("File is created!");
                }
                 else{
                //Debug to check if cars.txt already exists
	        //System.out.println("File already exists.");
               }
        } catch (IOException e) {
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
    
    
    //If counter > 0, this will run to export new data
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
       /*try {
           FileWriter outFile = new FileWriter("cars.txt");
           for (String s : carRecord.getRecord()){
               outFile.write(s);
           }
           outFile.close();
       } catch (IOException e) {
           e.printStackTrace();
       }*/

    }
    
    
    //This function gets the user input for each field, then converts it to a string.
    //Then it puts the string into the ArrayList at the first index and so on.
    //Remove the printline debug statement that prints what's in the array elements. 
    public void addCar(){
        Scanner input = new Scanner(System.in);
        
        //Get VIN
        System.out.println("Enter the VIN: " );
        String userVIN = input.nextLine();
        carRecord.setVIN(userVIN.toUpperCase()); //Had issues here
        
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
        
        //Debugging print statement--Not necessary for final
        System.out.println(carRecord.getRecord());
    }
    
    //Re-enter information that is to be deleted
    //Issue with this design is that it will delete the first read of input data
    //it finds. It will not delete a specifically designated slot entirely.
    public void deleteCar(){
        Scanner input = new Scanner(System.in);
        
        //Get VIN
        System.out.println("Enter the VIN: " );
        String userVIN = input.nextLine();
        carRecord.setVIN(userVIN.toUpperCase()); //Had issues here
        
        //Get Year
        System.out.println("Enter the Year: " );
        int userYearInt = input.nextInt();
        String userYear = "" + userYearInt;
        
        //Get Make
        System.out.println("Enter the Make: " );
        String userMake = input.nextLine();
        
        //Get Model
        System.out.println("Enter the Model: " );
        String userModel = input.nextLine();
        
        //Get Mileage
        System.out.println("Enter the Mileage: " );
        int userMileageInt = input.nextInt();
        String userMileage = "" + userMileageInt;
        
        //Get Price
        System.out.println("Enter the Price: " );
        Float userPriceFlt = input.nextFloat();
        String userPrice = "" + userPriceFlt;
        
       //Remove Car Elements
       //Issue here: Will remove earlier iterations of the same type
       carRecord.removeElement(userVIN);
       carRecord.removeElement(userYear);
       carRecord.removeElement(userMake);
       carRecord.removeElement(userModel);
       carRecord.removeElement(userMileage);
       carRecord.removeElement(userPrice);
       
              
        //Debugging print statement--Not necessary for final
        System.out.println(carRecord.getRecord());
    }
    
    public boolean checkCar(){       
        Scanner input = new Scanner(System.in);
        ArrayList<String> record = carRecord.getRecord();
        
        //Get VIN
        System.out.println("Enter the VIN: " );
        String userVIN = input.nextLine();
        
        if(!carRecord.searchList(userVIN).equals("negativeSearch")) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    
    //This function diplays the car records to the console for Option 1
    public void displayRecords(){
        for (String s : carRecord.getRecord()){
               System.out.println(s);
        }
    }
    
    
    
    //This function for Option 5 finds a car record between a certain price
    public void findPrice(){
        Scanner input = new Scanner(System.in);
        
        //Get user input to set the price range
        System.out.println("Enter the minimum of the price range: ");
        Float min_price = input.nextFloat();
        
        System.out.println("Enter the maximum of the price range: ");
        Float max_price = input.nextFloat();
        
        /*
        Convert the prices in the car records to float and check if the car
        record is within the user's specified price range.
        */
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
        
        //If no car record was found within the price range...
        if (hasRecord == false){
            System.out.println("Sorry, cannot find car within that "
                    + "price range." + "\n");
        }
        
    }
    
}
