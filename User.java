package assignment5;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Laura Garcia
 * @author Austin Stamper 
 */

/** This class defines the methods and variables for all types of users */
public class User implements java.io.Serializable {
    
    /** Default Constructor */
    public User(){}
    
    public User(ArrayList<String> tempRecord, int id, String fName, String lName){
        this.record = tempRecord;
        ID = id;
        firstName = fName;
        lastName = lName;
    }
    
    /**
     * Sets the User ID
     * @param id 
     */
    public void setID(int id){
        ID = id;
    }
    
    /**
     * Returns the user ID
     * @return the User ID
     */
    public int getID(){
        return ID;
    }
    
    /**
     * Sets the First Name
     * @param fName the first name to be set
     */
    public void setFirstName(String fName){
        firstName = fName;
    }
    
    /**
     * Returns the First Name
     * @return the First Name
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * Sets the Last Name
     * @param lName the last name to be set
     */
    public void setLastName(String lName){
        lastName = lName;
    }
    
    /**
     * Returns the Last Name
     * @return the Last Name
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * Returns an item in the ArrayList
     * @return 
     */
    public ArrayList<String> getRecord(){
        return this.record;
    }
    
    /**
     * Adds a new item to the array list
     * @param newRecord the item to be added to the array list
     */
    public void setRecord(String newRecord){
        record.add(newRecord);
    }
    
    /**
     * Removes an item from the array list
     * @param userID the user ID that is used to locate the item to be removed
     */
    public void removeElement(String userID) {
        //Find the matching car record VIN
        Iterator<String> iter = record.iterator();

        while (iter.hasNext()) {
            String str = iter.next();

            if (str.contains(userID) == true) {
                iter.remove();
            } 
        }
    }
    
    private ArrayList<String> record = new ArrayList<String>();
    private int ID;
    private String firstName;
    private String lastName;
}
