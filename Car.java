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
    I don't know if we need a plain constructor or not. And I don't know if we need set functions for each too. 
    I added them just in case, but I wasn't sure how to make a set function for ArrayList.
    
    We might need a function that either combines all the pieces of the record
    into a string like on the slides from today, and then put the string in the ArrayList as one long string for 
    each car record line entered by the user.
    */
    public Car(){
            
    }
    
    public Car(ArrayList<String> tempRecord, String tempVin, int tempYear, int tempMileage, float tempPrice, 
            String tempMake, String tempModel){
        this.record = tempRecord;        
        vin = tempVin;
        year = tempYear;
        mileage = tempMileage;
        price = tempPrice;
        make = tempMake;
        model = tempModel; 
    }
    
    public void setVIN(String newVIN){
        vin = newVIN;
    }
    
    public String getVIN(){
        return vin;
    }
    
    public void setYear(int newYear){
        year = newYear;
    }
    
    public Integer getYear(){
        return year;
    }
    
    public void setMileage(int newMileage){
        mileage = newMileage;
    }
    
    public Integer getMileage(){
        return mileage;
    }
    
    public void setPrice(float newPrice){
        price = newPrice;
    }
    
    public Float getPrice(){
        return price;
    }
    
    public void setMake(String newMake){
        make = newMake;
    }
    
    public String getMake(){
        return make;
    }
    
    public void setModel(String newModel){
        model = newModel;
    }
    
    public String getModel(){
        return model;
    }
    
    public void setRecord(String newRecord){
        record.add(newRecord);
    }
    
    public ArrayList<String> getRecord(){
        return this.record;
    }
    
    //Searches the list for a VIN number
    //Placed in Car beacuse it's difficult to traverse array in Dealership
    public String searchList(String VIN) {
        String negativeSearch = "negativeSearch";
        
        if (this.record.isEmpty()) {
            System.out.println("There is nothing to search.");
            return negativeSearch;
        }
        
        for(int i = 0; i < this.record.size();i++) {
            if(this.record.get(i).equals(VIN)) {
                return record.get(i);
            }
            else {
                return negativeSearch;
            }
        }
        return negativeSearch;      
    }
    
    //Intended to remove an element from the ArrayList
    public void removeElement(String element) {
        record.remove(element);
    }
    
    
    private ArrayList<String> record = new ArrayList<String>();
    private String vin; //Double check this; vin is always 5
    private int year;
    private int mileage;
    private float price;
    private String make;
    private String model;
}
