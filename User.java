package assignment2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Laura Garcia
 * @author Austin Stamper 
 */
public class User implements java.io.Serializable {
    
    public User(){}
    
    public User(ArrayList<String> tempRecord, int id, String fName, String lName){
        this.record = tempRecord;
        ID = id;
        firstName = fName;
        lastName = lName;
    }
    
    public void setID(int id){
        ID = id;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setFirstName(String fName){
        firstName = fName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setLastName(String lName){
        lastName = lName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public ArrayList<String> getRecord(){
        return this.record;
    }
    
    public void setRecord(String newRecord){
        record.add(newRecord);
    }
    
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
