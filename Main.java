/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Laura Garcia/Austin Stamper
 */
public class Main {

    public static void main(String[] args) {
        
        Dealership dealer = new Dealership();
        
        //Needs constructor
        Car car = new Car();
        
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
                System.out.println("Your selection is: " );
                int selection = input.nextInt();
            
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
                        dealer.addCar();
                        dealer.counter(count);
                        break;
                    case "3":
                        System.out.println("You selected 3");
                        dealer.counter(count);
                        break;
                    case "4":
                        System.out.println("You selected 4");
                        break;
                    case "5":
                        System.out.println("You selected 5");
                        break;
                    case "6":
                        System.out.println("You selected 6");
                        //if(count > 0) {
                            //Car value needs to be added
                            dealer.exportData();
                        //}
                        quit = true;
                        break;
                    case "7":
                        System.out.println("You selected 7");
                        break;
                    default:
                        System.out.println("Your selection is unavailable");
                        break;
                    }
            } catch(InputMismatchException e) {
                System.out.println("You must enter a valid option!");
            }                    
        } while(quit == false);
    }
}
