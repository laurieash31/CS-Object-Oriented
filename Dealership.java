/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author Laura Garcia/Austin Stamper
 */
public class Dealership {
    
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
       
       String vin = car.getVIN();
       String make = car.getMake();
       String model = car.getModel();
       int year = car.getYear();
       int mileage = car.getMileage();
       float price = car.getPrice();
       
       try {
       PrintWriter outFile = new PrintWriter("cars.txt");
       outFile.println(vin + " " + make + " " + model + " " + year + " "
                       + year + " " + mileage + " " + price);
       } catch (IOException e) {
           e.printStackTrace();
       }

    }
    
}
