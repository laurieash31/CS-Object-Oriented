/*
 * Car Dealership Managment Software v0.1 
 * Developed for CS3354: Object Oriented Design and Programming.
 * Copyright: Vangelis Metsis (vmetsis@txstate.edu)
 */

/**
 * Solution from Assignment 2
 * Slight modifications to work with GUI
 * 
 * @author vangelis
 * @author Laura Garcia
 * @author Austin Stamper
 */


public class Customer extends User {
    private String phoneNumber;
    private int driverLicenceNumber;

    /**
     * Default constructor.
     */
    public Customer() {
        this.phoneNumber = "";
        this.driverLicenceNumber = 0;
    }

    /**
     * Constructor initializes a customer object with the provided values.
     * @param id
     * @param phoneNumber
     * @param driverLicenceNumber
     * @param firstName
     * @param lastName
     */
    public Customer(int id, String firstName, String lastName, String phoneNumber, int driverLicenceNumber) {
        super(id, firstName, lastName);
        this.phoneNumber = phoneNumber;
        this.driverLicenceNumber = driverLicenceNumber;
    }

    /**
     * Get the phone number.
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number.
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the driver license number.
     * @return driverLicenceNumber
     */
    public int getDriverLicenceNumber() {
        return driverLicenceNumber;
    }

    /**
     * Set the driver license number.
     * @param driverLicenceNumber
     */
    public void setDriverLicenceNumber(int driverLicenceNumber) {
        this.driverLicenceNumber = driverLicenceNumber;
    }
    
    /**
     * Print the attributes of the customer, in a formatted fashion.
     * Modification to the <CODE>getFormattedText()</CODE> method to return a string
     * @return string - customerRecord
     */
    @Override
    public String getFormattedText() {
        
        String customerRecord = "Customer" + " " + id + " " + firstName + " " 
                + lastName + " "  + phoneNumber + " "  + driverLicenceNumber;
        
        return customerRecord;
    }

    @Override
    public String toString() { 
        return "Customer{" + "id=" + id + ", firstName=" + firstName 
                + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber 
                + ", driverLicenceNumber=" + driverLicenceNumber + '}';
    }
}
