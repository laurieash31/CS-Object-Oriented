/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Scanner;
/**
 *
 * @author lauragarcia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            System.out.print(">>");
            
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();
            
            //Debug for user input
            System.out.println("Your selection is: " + selection + "\n");
    }
    
}
