package dealership;

/**
 * This class is a very simple representation of a car. There are only getter
 * methods and no setter methods and as a result a car cannot be mutated once
 * initialized. A car object can also call the two override methods
 * <CODE>toString()</CODE> and <CODE>equals()</CODE>
 *
 * @author Vangelis Metsis
 */
public class Car {

    private final String vin;
    private final String make;
    private final String model;
    private final int year;
    private final int mileage;
    private final float price;

    /**
     * This constructor initializes the car object. The constructor provides no
     * user input validation. That should be handled by the class that creates a
     * car object.
     *
     * @param vin a <b><CODE>String</CODE></b> that represents the license plate
     * @param make a <b><CODE>String</CODE></b> that represents the make
     * @param model a <b><CODE>String</CODE></b> that represents the model
     * @param year a 4 digit <b><CODE>int</CODE></b> that represents the year
     * model
     * @param mileage an <b><CODE>int</CODE></b> that represents the mileage of
     * the vehicle
     * @param price a <b><CODE>float</CODE></b> that represents the price of the
     * vehicle
     */
    public Car(String vin, String make, String model, int year, int mileage, float price) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    /**
     * This method returns the car's license plate.
     *
     * @return a <b><CODE>String</CODE></b> that is the VIN of the car.
     */
    public String getVin() {
        return vin;
    }

    /**
     * This method returns the car's make.
     *
     * @return a <b><CODE>String</CODE></b> that is the car's make.
     */
    public String getMake() {
        return make;
    }

    /**
     * This method returns the car's model.
     *
     * @return a <b><CODE>String</CODE></b> that is the car's model.
     */
    public String getModel() {
        return model;
    }

    /**
     * This method returns the car's model year.
     *
     * @return an <b><CODE>int</CODE></b> that is the car's year model
     */
    public int getYear() {
        return year;
    }

    /**
     * This method returns the car's mileage.
     *
     * @return an <b><CODE>int</CODE></b> that is the car's mileage
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * This method returns the car's price.
     *
     * @return a <b><CODE>float</CODE></b> that is the car's price
     */
    public float getPrice() {
        return price;
    }

    /**
     * This method returns the car's fields as a string representation.
     *
     * @return a <b><CODE>String</CODE></b> that lists the fields of the car
     * object delineated by a space and in the same order as the constructor
     */
    @Override
    public String toString() {
        return vin + " " + make + " " + model + " " + year + " " + mileage 
                + " " + String.format("%.2f", price) + "\n";
    }

    /**
     * This method provides a way to compare two car objects.
     *
     * @param c a <b><CODE>Car</CODE></b> object that is used to compare to
     * <b><CODE>this</CODE></b> car. two cars are equal if their VIN is the
     * same.
     * @return the <CODE>boolean</CODE> value of the comparison.
     */
    public boolean equals(Car c) {
        return c.getVin().equals(this.vin);
    }

}