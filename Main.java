/**
 * @author Laura Garcia
 * @author Austin Stamper
 * @version 1.0
 */

package assignment2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        
        Dealership dealer = new Dealership();
        
        //Needs constructor
        Vehicle car = new Vehicle();
        
        //Check if file exists
        dealer.fileCheck();
        
        //Read data (if any) from cars.txt file into the ArrayList
        dealer.readRecords();
        
        //Set "exit program" to false for menu loop
        boolean quit = false;
        int count = 0;
        
        do{
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
            
            //Error checking for bad user input
            try{
            
                Scanner input = new Scanner(System.in);
           
                //User input is held in "int selection"
                System.out.print("Your selection is: " );
                int selection = input.nextInt();
            
                //int comparison wasn't working, converted to string
                String selectstring = "" + selection;
        
                //All inputs are read successfully
                //Can use for when each option is selected
                switch (selectstring) {
                    case "1":
                        System.out.println("Displaying car records..." + "\n");
                        dealer.displayRecords();
                        break;        
                    case "2":
                        System.out.println("Add a car to the database..." + "\n");
                        dealer.addCar();
                        break;
                    case "3":
                        System.out.println("Delete a car from the database..." + "\n");
                        dealer.deleteCar();
                        break;
                    case "4":
                        System.out.println("Search for car..." + "\n");
                        dealer.checkCar();
                        break;
                    case "5":
                        System.out.println("Display list of cars within range..." + "\n");
                        dealer.findPrice();
                        break;
                    case "6":
                        System.out.println("Saving data..." + "\n");
                        dealer.exportData();
                        System.out.println("Exiting program...");
                        quit = true;
                        break;
                    case "7":
                        System.out.println("Displaying menu..." + "\n");
                        break;
                    default:
                        System.out.println("Your selection is unavailable" + "\n");
                        break;
                    }
            } catch(InputMismatchException e) {
                System.out.println("You must enter a valid option!");
                System.out.println();
            }                    
        } while(quit == false);
    }
}