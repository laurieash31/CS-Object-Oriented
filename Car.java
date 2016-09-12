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
    I'm not sure if we need these "get" functions or not. Also I left off
    the ArrayList for now in the constructor. 
    
    We might need a function that either combines all the pieces of the record
    into a string, and then put the string in the ArrayList as one long string for 
    each car record line entered by the user.
    */
        public Car(ArrayList<String>tempRecord, String tempVin, int tempYear, int tempMileage, float tempPrice, 
            String tempMake, String tempModel){
        this.record = tempRecord;        
        vin = tempVin;
        year = tempYear;
        mileage = tempMileage;
        price = tempPrice;
        make = tempMake;
        model = tempModel; 
    }
    
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
