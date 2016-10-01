package assignment2;

/**
 * @author Austin Stamper
 * @author Laura Garcia
 */
import java.util.ArrayList;
import java.util.Date;

/**This class handles methods that deal with customer/employee transactions */
public class Transactions implements java.io.Serializable {
    
    //Constructor
    public Transactions(){}
    
    public Transactions(ArrayList<String> tempRecord, int custID, String carVIN, 
            float finalPrice, int empID, Date salesDate){
        this.salesRecordsList = tempRecord;
        customerID = custID;
        vehicleVIN = carVIN;
        price = finalPrice;
        employeeID = empID;
        date = salesDate;
    }
    /**
     * This method sets the customer ID via the variable cutID
     * @param custID the customer ID to be set
     */
    public void setCustomerID(int custID){
        customerID = custID;
    }
    
    /**
     * Return the Customer ID
     * @return the customer ID
     */
    public int getCustomerID(){
        return customerID;
    }
    
    /**
     * sets the vehicle VIN
     * @param carVIN the VIN to be set
     */
    public void setVehicleVIN(String carVIN){
        vehicleVIN = carVIN;
    }
    
    /**
     * Returns the Vehicle VIN
     * @return the Vehicle VIN
     */
    public String getVehicleVIN(){
        return vehicleVIN;
    }
    
    /**
     * Sets the final price
     * @param finalPrice the final price to be set
     */
    public void setFinalPrice(float finalPrice){
        price = finalPrice;
    }
    
    /**
     * Returns the final price
     * @return the final price
     */
    public float getFinalPrice(){
        return price;
    }
    
    /**
     * Sets the employee ID
     * @param empID the employee ID to be set
     */
    public void setEmployeeID(int empID){
        employeeID = empID;
    }
    
    /**
     * Returns the employee ID
     * @return the employee ID
     */
    public int getEmployeeID(){
        return employeeID;
    }
    
    /**
     * Sets the sales Date
     * @param salesDate the sales Date to be set
     */
    public void setDate(Date salesDate){
        date = salesDate;
    }
    
    /**
     * Returns the sales date
     * @return the sales date
     */
    public Date getSalesDate(){
        return date;
    }
    
    /**
     * Adds a new item to the array list for a transaction
     * @param newRecord the new item to be added 
     */
    public void setSalesRecordsList(String newRecord){
        salesRecordsList.add(newRecord);
    }
     
    /**
     * Returns an item from the array list
     * @return the item from the array list
     */
    public ArrayList<String> getSalesRecordsList(){
        return this.salesRecordsList;
    }
    
    private ArrayList<String> salesRecordsList = new ArrayList<String>();
    private int customerID;
    private String vehicleVIN;
    private float price;
    private int employeeID;
    private Date date = new Date();   
}

