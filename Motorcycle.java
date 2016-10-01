/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 * @author Laura Garcia
 * @author Austin Stamper
 */

/** This class defines the variables and methods unique to a Motorcycle */
public class Motorcycle extends Vehicle implements java.io.Serializable{
    
    /** Default Constructor */
    public Motorcycle(){}
    
    public Motorcycle(String type, int eng){
        motoType = type;
        engine = eng;
    }
    
    /**
     * Sets the type of Motorcycle
     * @param type the type of Motorcycle to be set
     */
    public void setType(String type){
        motoType = type;
    }
    
    /**
     * Returns the type of Motorcycle
     * @return the type of Motorcycle
     */
    public String getType(){
        return motoType;
    }
    
    /**
     * Sets the engine CC
     * @param eng the engine CC to be set
     */
    public void setEngine(int eng){
        engine = eng;
    }
    
    /**
     * Returns the engine CC
     * @return the engine CC
     */
    public int getEngine(){
        return engine;
    }       
    
    private String motoType;
    private int engine;
}
