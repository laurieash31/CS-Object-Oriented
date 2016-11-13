package assignment5;

/**
 * @author Laura Garcia
 * @author Austin Stamper
 */

/** This class defines the variables and methods unique to an Employee */
public class Employee extends User implements java.io.Serializable {
    
    /** Default Constructor */
    public Employee(){}
    
    public Employee(float salary, int acctNum){
        monthSalary = salary;
        accountNum = acctNum;
    }
    
    /**
     * Sets the Monthly Salary
     * @param salary 
     */
    public void setMonthSalary(float salary){
        monthSalary = salary;
    }
    
    /**
     * Returns the Monthly Salary
     * @return the Monthly Salary
     */
    public float getMonthSalary(){
        return monthSalary;
    }
    
    /**
     * Sets the Account Number
     * @param acctNum 
     */
    public void setAccountNum(int acctNum){
        accountNum = acctNum;
    }
    
    /**
     * Returns the Account Number
     * @return the Account Number
     */
    public int getAccountNum(){
        return accountNum;
    }
    
    private float monthSalary;
    private int accountNum;
}
