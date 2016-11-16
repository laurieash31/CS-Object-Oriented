/*
 * Car Dealership Managment Software v0.1 
 * Developed for CS3354: Object Oriented Design and Programming.
 * Copyright: Vangelis Metsis (vmetsis@txstate.edu)
 */
 
/**
 * Solution for Assignment 2, with modifications to implement a GUI
 * Class PassengerCar is an entity class that represents a passenger car in the 
 * dealership inventory.
 * 
 * @author vangelis
 * @author Laura Garcia
 * @author Austin Stamper
 */

public class PassengerCar extends Vehicle {
    
    private String bodyStyle;

    /**
     * Default constructor. 
     */
    public PassengerCar() {
        bodyStyle = "";
    }

    /**
     * Constructor that initializes a PassengerCar object with the given params.
     * @param vin The Vehicle Identification Number (VIN) of the vehicle.
     * @param make The make of the vehicle.
     * @param model The model of the vehicle.
     * @param year The production year of the vehicle.
     * @param mileage The mileage counter of the vehicle.
     * @param price The sale price of the vehicle.
     * @param bodyStyle The body style of the car.
     */
    public PassengerCar(String vin, String make, String model, int year, 
            int mileage, float price, String bodyStyle) {
        super(vin, make, model, year, mileage, price);
        this.bodyStyle = bodyStyle;
    }

    /**
     * Get the body style of the car.
     * @return
     */
    public String getBodyStyle() {
        return bodyStyle;
    }

    /**
     * Set the body style of the car.
     * @param bodyStyle
     */
    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }
    
    /**
     * Print the attributes of the passenger car, in a formatted fashion.
     * Modification to the <CODE>getFormattedText()</CODE> method to return a string
     * @return string - pCarRecord
     */
    @Override
    public String getFormattedText() {
        String pCarRecord = vin + " " + make + " " + model + " " + year
               + " " + mileage + " " + price + " " + bodyStyle;
        
        return pCarRecord;
    }

    @Override
    public String toString() {
        return "PassengerCar{" + "vin=" + vin + ", make=" + make + ", model=" + 
                model + ", year=" + year + ", mileage=" + mileage + ", price=" + 
                price + ", bodyStyle=" + bodyStyle + '}';
    }
}
