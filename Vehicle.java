 /**
 * @author Laura Garcia
 * @author Austin Stamper
 * @version 2.0
 */
package assignment2;

import java.util.ArrayList;
import java.util.Iterator;

/** The class Vehicle contains the data to be used in the methods */
public class Vehicle implements java.io.Serializable{

    /**
    * This method is a default constructor.
    */ 
    public Vehicle(){}
    
    //This function is the constructor 
    public Vehicle(ArrayList<String> tempRecord, String tempVin, int tempYear, int tempMileage, float tempPrice, 
            String tempMake, String tempModel){
        this.record = tempRecord;        
        vin = tempVin;
        year = tempYear;
        mileage = tempMileage;
        price = tempPrice;
        make = tempMake;
        model = tempModel; 
    }
    
    /**
    * This method sets the newVIN to the VIN in record.
    * @param newVIN the VIN to be set.
    */
    public void setVIN(String newVIN){
        vin = newVIN;
    }
    
    /**
    * This function returns the VIN from the record.
    * @return the VIN in the record. 
    */ 
    public String getVIN(){
        return vin;
    }
    
    /**
    * This function sets the year in record to newYear.
    * @param newYear the defined year to be set.
    */ 
    public void setYear(int newYear){
        year = newYear;
    }
    
    
    //This function returns the year from record
    public Integer getYear(){
        return year;
    }
    
    
    /**
    * This function sets the mileage in record to newMileage
    * @param newMileage the defined mileage to be set.
    */ 
    public void setMileage(int newMileage){
        mileage = newMileage;
    }
    
    
    //This function returns the mileage from record
    public Integer getMileage(){
        return mileage;
    }
    
    
    /**
    * This function sets the price in record to newPrice.
    * @param newPrice the defined price to be set.
    */ 
    public void setPrice(float newPrice){
        price = newPrice;
    }
    
    
    //This function returns the price from record
    public Float getPrice(){
        return price;
    }
    
    
    /**
    * This function sets the make in record to newMake.
    * @param newMake the defined make to be set.
    */ 
    public void setMake(String newMake){
        make = newMake;
    }
    
    
    //This function returns the make from record
    public String getMake(){
        return make;
    }
    
    
    /**
    * This function sets the model in record to newModel.
    * @param newModel the defined model to be set.
    */ 
    public void setModel(String newModel){
        model = newModel;
    }
    
    
    /**
     * This method returns the model from record
     * @return the model from record
     */ 
    public String getModel(){
        return model;
    }
    
    
    /**
    * This function sets the record in record to newRecord.
    * @param newRecord the defined record to be set.
    */ 
    public void setRecord(String newRecord){
        record.add(newRecord);
    }
    
    
    /**
     * This function returns the record 
     * @return the Record
     */ 
    public ArrayList<String> getRecord(){
        return this.record;
    }
    
    /**
    * This function uses the VIN to remove an element from the ArrayList.
    * @param userVIN the defined VIN used to find the element to be removed.
    */ 
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
