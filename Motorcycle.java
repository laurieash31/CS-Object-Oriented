package assignment5;

/*
 * Car Dealership Managment Software v0.1 
 * Developed for CS3354: Object Oriented Design and Programming.
 * Copyright: Vangelis Metsis (vmetsis@txstate.edu)
 */

/**
 * Solution for Assignment 2, with modifications to implement GUI
 * @author vangelis
 */
public class Motorcycle extends Vehicle {
    
    private String type;
    private int displacement;

    /**
     * Default constructor.
     */
    public Motorcycle() {
        this.type = "";
        this.displacement = 0;
    }

    /**
     * Constructor used to initialize the class fields of the class with the
     * provided values.
     * @param vin
     * @param make
     * @param model
     * @param year
     * @param mileage
     * @param price
     * @param type
     * @param displacement
     */
    public Motorcycle(String vin, String make, String model, int year, 
            int mileage, float price, String type, int displacement) {
        super(vin, make, model, year, mileage, price);
        this.type = type;
        this.displacement = displacement;
    }

    /**
     * Get the motorcycle type.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Get the motorcycle type.
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the motorcycle displacement.
     * @return
     */
    public int getDisplacement() {
        return displacement;
    }

    /**
     * Set the motorcycle displacement.
     * @param displacement
     */
    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }
    
    /**
     * Print the attributes of the motorcycle, in a formatted fashion.
     * Modification to the <CODE>print()</CODE> method to return a string
     * @return string - motoRecord
     */
    @Override
    public String getFormattedText() {
        String motoRecord = vin+ " "  + make+ " "  + model + " "  + year + " "  
               + mileage + " "  + "$" + String.format("%.2f", price) + " "  + type + " "  + displacement;
        
        return motoRecord;
    }

    @Override
    public String toString() {
        return "Motorcycle{" + "vin=" + vin + ", make=" + make + 
                ", model=" + model + ", year=" + year + ", mileage=" + mileage + 
                ", price=" + String.format("%.2f", price) + ", type=" + type + 
                ", displacement=" + displacement + '}';
    }
}
