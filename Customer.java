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
public class Customer extends User implements java.io.Serializable {
    
    public Customer(){}
    
    public Customer(int dlNum, String pNum){
        dlNumber = dlNum;
        pNumber = pNum;
    }
    
    public void setPNumber(String pNum){
        pNumber = pNum;
    }
    
    public String getPNumber(){
        return pNumber;
    }
    
    public void setDLNumber(int dlNum){
        dlNumber = dlNum;
    }
    
    public int getDLNumber(){
        return dlNumber;
    }
    
    private int dlNumber;
    private String pNumber;
}

