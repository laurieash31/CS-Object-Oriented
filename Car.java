package assignment1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author lauragarcia/Austin Stamper
 */
public class Car {
    
    //This function is a default constructor
    public Car(){}
    
    
    //This function is the constructor
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
    
    
    //This function sets the newVIN to the vin in record
    public void setVIN(String newVIN){
        vin = newVIN;
    }
    
    
    //This function returns the vin from the record
    public String getVIN(){
        return vin;
    }
    
    
    //This function sets the year in record to newYear
    public void setYear(int newYear){
        year = newYear;
    }
    
    
    //This function returns the year from record
    public Integer getYear(){
        return year;
    }
    
    
    //This function sets the mileage in record from newMileage
    public void setMileage(int newMileage){
        mileage = newMileage;
    }
    
    
    //This function returns the mileage from record
    public Integer getMileage(){
        return mileage;
    }
    
    
    //This function sets the price in record to newPrice
    public void setPrice(float newPrice){
        price = newPrice;
    }
    
    
    //This function returns the price from record
    public Float getPrice(){
        return price;
    }
    
    
    //This function sets the make in record to newMake
    public void setMake(String newMake){
        make = newMake;
    }
    
    
    //This function returns the make from record
    public String getMake(){
        return make;
    }
    
    
    //This function sets the model in record to newModel
    public void setModel(String newModel){
        model = newModel;
    }
    
    
    //This function returns the model from record
    public String getModel(){
        return model;
    }
    
    
    //This function sets a record element to newRecord
    public void setRecord(String newRecord){
        record.add(newRecord);
    }
    
    
    //This function returns the record 
    public ArrayList<String> getRecord(){
        return this.record;
    }
    
    //This function removes the element from record
    public void removeElement(String userVIN) {
        //Find the matching car record VIN
        Iterator<String> iter = record.iterator();

        while (iter.hasNext()) {
            String str = iter.next();

            if (str.contains(userVIN) == true) {
                iter.remove();
            } 
        }
    }
    
    //Variables
    private ArrayList<String> record = new ArrayList<String>();
    private String vin;
    private int year;
    private int mileage;
    private float price;
    private String make;
    private String model;
}
