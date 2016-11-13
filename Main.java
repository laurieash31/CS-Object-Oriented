/**
 * @author Laura Garcia
 * @author Austin Stamper
 * @version 3.0
 */

package assignment5;

import java.util.Scanner;
import java.util.InputMismatchException;

/** This class is the main class for the package */
public class Main {

    public static void main(String[] args) {
        
        Dealership dealer = new Dealership();
        
        //Read data (if any) from cars.txt file into the ArrayList
        dealer.readRecords();
        
        //Set "exit program" to false for menu loop
        boolean quit = false;
        
        do{
            //Display option menu
            System.out.println("Welcome to the dealership database. Please choose one of the following: ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("[1] Display existing vehicle records");
            System.out.println("[2] Add a new vehicle record to the database");
            System.out.println("[3] Delete a vehicle record from the database");
            System.out.println("[4] Search for a vehicle record using the VIN");
            System.out.println("[5] Display the list of vehicles within a price range");
            System.out.println("[6] Display the users in the database");
            System.out.println("[7] Add a user to the database");
            System.out.println("[8] Update user info using their ID");
            System.out.println("[9] Sell a vehicle");
            System.out.println("[10] Show completed sales transactions");
            System.out.println("[11] Exit the program");
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
                        System.out.println("Displaying vehicle records..." + "\n");
                        dealer.displayRecords();
                        break;        
                    case "2":
                        System.out.println("Add a vehicle to the database..." + "\n");
                        dealer.addVehicle();
                        break;
                    case "3":
                        System.out.println("Delete a vehicle from the database..." + "\n");
                        dealer.deleteCar();
                        break;
                    case "4":
                        System.out.println("Search for vehicle..." + "\n");
                        dealer.checkCar();
                        break;
                    case "5":
                        System.out.println("Display list of vehicless within range..." + "\n");
                        dealer.findPrice();
                        break;
                    case "6":
                        System.out.println("Show list of users...");
                        dealer.printUsers();
                        break;
                    case "7":
                        System.out.println("Add a new user...");
                        dealer.addUser();
                        break;
                    case "8":
                        System.out.println("Update user info...");
                        dealer.updateUser(); 
                        break;
                    case "9":
                        System.out.println("Sell a vehicle...");
                        dealer.sellVehicle();
                        break;
                    case "10":
                        System.out.println("Show list of transactions...");
                        dealer.printTransactions();
                        break;
                    case "11":
                        System.out.println("Saving data..." + "\n");
                        dealer.exportData();
                        System.out.println("Exiting program...");
                        quit = true;
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
