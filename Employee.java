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
public class Employee extends User implements java.io.Serializable {
    
    public Employee(float salary, int acctNum){
        monthSalary = salary;
        accountNum = acctNum;
    }
    
    public void setMonthSalary(float salary){
        monthSalary = salary;
    }
    
    public float getMonthSalary(){
        return monthSalary;
    }
    
    public void setAccountNum(float acctNum){
        accountNum = acctNum;
    }
    
    public float getAccountNum(){
        return accountNum;
    }
    
    private float monthSalary;
    private float accountNum;
}
