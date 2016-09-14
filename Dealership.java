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
    
    public void fileCheck(){
    //Tests if cars.txt exists and creates files if it doesn't
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
    
    //If counter > 0, this will run to export new data
    public void exportData(Car car){
       try {
           FileWriter outFile = new FileWriter("cars.txt");
           for (String s : carRecord.getRecord()){
               outFile.write(s);
           }
           outFile.close();
       } catch (IOException e) {
           e.printStackTrace();
       }

    }
    
    
    //This function gets the user input for each field, then converts it to a string.
    //Then it puts the string into the ArrayList at the first index and so on.
    //Remove the printline debug statement that prints what's in the array elements. 
    public void addCar(){
        Scanner input = new Scanner(System.in);
        
        //Get VIN
        System.out.println("Enter the VIN: " );
        String userVIN = input.nextLine();
        carRecord.setVIN(userVIN);
        
        //Get Year
        System.out.println("Enter the Year: " );
        int userYear = input.nextInt();
        carRecord.setYear(userYear);
        
        //DOES THE THING WITH THE NEWLINE, FIX FROM NOTES WITH PROPER NEXT() FUNCTION
        
        //Get Make
        System.out.println("Enter the Make: " );
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
                + carRecord.getMileage() + " " + carRecord.getPrice() + "\n";
        
        carRecord.setRecord(recordLine);
        
        //Debugging print statement--Not necessary for final
        System.out.println(carRecord.getRecord());
    }
    
}
