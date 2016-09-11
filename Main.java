/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Laura Garcia/Austin Stamper
 */
public class Main {

    public static void main(String[] args) {
        
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
        
            //Display option menu
            System.out.println("Welcome to the dealership database. Please choose one of the following: ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("[1] Display existing car records");
            System.out.println("[2] Add a new car record to the database");
            System.out.println("[3] Delete a car record from the database");
            System.out.println("[4] Search for a car record using the VIN");
            System.out.println("[5] Display the list of cars within a price range");
            System.out.println("[6] Exit the program");
            System.out.println("[7] Display the menu choices");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(">> ");
            
            Scanner input = new Scanner(System.in);
            
            
            //User input is held in "int selection"
            System.out.println("Your selection is: " );
            int selection = input.nextInt();
            //System.out.println(selection + "\n");
            
            //int comparison wasn't working, converted to string
            String selectstring = "" + selection;
        
        //All inputs are read successfully
        //Can use for when each option is selected
        switch (selectstring) {
            case "1":
                System.out.println("You selected 1");
                break;        
            case "2":
                System.out.println("You selected 2");
                break;
            case "3":
                System.out.println("You selected 3");
                break;
            case "4":
                System.out.println("You selected 4");
                break;
            case "5":
                System.out.println("You selected 5");
                break;
            case "6":
                System.out.println("You selected 6");
                break;
            case "7":
                System.out.println("You selected 7");
                break;
            default:
                System.out.println("Your selection is unavailable");
                break;
        }
        
        //Add a try-catch to handle the "InputMismatchException" when user enters wrong info
    }
    
}
