/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Austin Stamper
 */
public class User{
    
    public User(int id, String fName, String lName){
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
    
    public String getLasstName(){
        return lastName;
    }
    
    private int ID;
    private String firstName;
    private String lastName;
}
