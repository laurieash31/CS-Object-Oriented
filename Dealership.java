/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author Laura Garcia/Austin Stamper
 */
public class Dealership {
    
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
    
}
