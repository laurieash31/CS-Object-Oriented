/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.ArrayList;

/**
 *
 * @author lauragarcia/Austin Stamper
 */
public class Car {
    
    /*
    I'm not sure if we need these or not. If we do, we need a "set???" 
    functions for each one since they are private. 
    
    And then have a function that either combines all the pieces of the record
    into a string, and then put the string in the ArrayList as one long string for 
    each car record line entered by the user. 
    */
    public String getVIN(){
        return vin;
    }
    
    public Integer getYear(){
        return year;
    }
    
    public Integer getMileage(){
        return mileage;
    }
    
    public Float getPrice(){
        return price;
    }
    
    public String getMake(){
        return make;
    }
    
    public String getModel(){
        return model;
    }
    
    
    ArrayList<String> record = new ArrayList<String>();
    private String vin; //Double check this; vin is always 5
    private int year;
    private int mileage;
    private float price;
    private String make;
    private String model;
}
