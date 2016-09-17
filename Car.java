/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author lauragarcia/Austin Stamper
 */
public class Car {
    
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
    
    //Removes an element from the ArrayList
    public void removeElement(String userVIN) {
        //record.remove(element);
        //Find the matching car record VIN
        Iterator<String> iter = record.iterator();

        while (iter.hasNext()) {
            String str = iter.next();

            if (str.contains(userVIN) == true) {
                iter.remove();
            }
        
        }
    }
    
    
    private ArrayList<String> record = new ArrayList<String>();
    private String vin;
    private int year;
    private int mileage;
    private float price;
    private String make;
    private String model;
}
