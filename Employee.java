package assignment2;

/**
 * @author Laura Garcia
 * @author Austin Stamper
 */
public class Employee extends User implements java.io.Serializable {
    
    public Employee(){}
    
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
    
    public void setAccountNum(int acctNum){
        accountNum = acctNum;
    }
    
    public int getAccountNum(){
        return accountNum;
    }
    
    private float monthSalary;
    private int accountNum;
}
