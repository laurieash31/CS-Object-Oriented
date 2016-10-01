package assignment2;

/**
 * @author Austin Stamper
 * @author Laura Garcia
 */
import java.util.ArrayList;
import java.util.Date;

public class Transactions implements java.io.Serializable {
    
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
    
    public void setCustomerID(int custID){
        customerID = custID;
    }
    
    public int getCustomerID(){
        return customerID;
    }
    
    public void setVehicleVIN(String carVIN){
        vehicleVIN = carVIN;
    }
    
    public String getVehicleVIN(){
        return vehicleVIN;
    }
    
    public void setFinalPrice(float finalPrice){
        price = finalPrice;
    }
    
    public float getFinalPrice(){
        return price;
    }
    
    public void setEmployeeID(int empID){
        employeeID = empID;
    }
    
    public int getEmployeeID(){
        return employeeID;
    }
    
    public void setDate(Date salesDate){
        date = salesDate;
    }
    
    public Date getSalesDate(){
        return date;
    }
    
    public void setSalesRecordsList(String newRecord){
        salesRecordsList.add(newRecord);
    }
     
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
