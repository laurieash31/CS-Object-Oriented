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
public class Motorcycle extends Vehicle implements java.io.Serializable{
    
    public Motorcycle(){}
    
    public Motorcycle(String type, int eng){
        motoType = type;
        engine = eng;
    }
    
    public void setType(String type){
        motoType = type;
    }
    
    public String getType(){
        return motoType;
    }
    
    public void setEngine(int eng){
        engine = eng;
    }
    
    public int getEngine(){
        return engine;
    }       
    
    private String motoType;
    private int engine;
}
