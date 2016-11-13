package assignment5;

/**
 * @author Laura Garcia
 * @author Austin Stamper
 */

/** This class defines the variables and methods unique to a Customer */
public class Customer extends User implements java.io.Serializable {
    
    /** Default Constructor */
    public Customer(){}
    
    public Customer(int dlNum, String pNum){
        dlNumber = dlNum;
        pNumber = pNum;
    }
 
    /**
     * Sets the Phone Number
     * @param pNum the phone number to be set
     */
    public void setPNumber(String pNum){
        pNumber = pNum;
    }
    
    /**
     * Returns the Phone Number
     * @return the Phone Number
     */
    public String getPNumber(){
        return pNumber;
    }
    
    /**
     * Sets the Driver's License Number
     * @param dlNum 
     */
    public void setDLNumber(int dlNum){
        dlNumber = dlNum;
    }
    
    /**
     * Returns the Driver's License Number
     * @return the Driver's License Number
     */
    public int getDLNumber(){
        return dlNumber;
    }
    
    private int dlNumber;
    private String pNumber;
}
