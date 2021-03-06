package assignment5;

/*
 * Car Dealership Managment Software v0.1 
 * Developed for CS3354: Object Oriented Design and Programming.
 * Copyright: Vangelis Metsis (vmetsis@txstate.edu)
 */

/**
 * Solution from Assignment 2 used to implement GUI
 * @author vangelis
 * @author Laura Garcia
 * @author Austin Stamper
 */
public class Employee extends User {
    private float monthlySalary;
    private int bankAccountNumber;

    /**
     * Default constructor.
     */
    public Employee() {
        this.monthlySalary = 0.0f;
        this.bankAccountNumber = 0;
    }

    /**
     * Constructor initializes an employee object with the provided values.
     * @param id
     * @param firstName
     * @param lastName
     * @param monthlySalary
     * @param bankAccountNumber
     */
    public Employee(int id, String firstName, String lastName, float monthlySalary, int bankAccountNumber) {
        super(id, firstName, lastName);
        this.monthlySalary = monthlySalary;
        this.bankAccountNumber = bankAccountNumber;
    }

    /**
     * Get the monthly salary.
     * @return monthlySalary
     */
    public float getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * Set the monthly salary.
     * @param monthlySalary
     */
    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    /**
     * Get the bank account number.
     * @return
     */
    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * Set the bank account number.
     * @param bankAccountNumber
     */
    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
    
    /**
     * Print the attributes of the employee, in a formatted fashion.
     * Modification to the <CODE>getFormattedText()</CODE> method to return a string
     * @return string - employeeRecord
     */
    @Override
    public String getFormattedText() {
        String employeeRecord = "Employee" + " " + id + " " + firstName + " " 
                + lastName + " "  + "$" + String.format("%.2f", monthlySalary) 
                + " "  + bankAccountNumber;
        
        return employeeRecord;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName 
                + ", lastName=" + lastName + ", monthlySalary=" + String.format("%.2f", monthlySalary) 
                + ", bankAccountNumber=" + bankAccountNumber + '}';
    }
}
