package assignment2;

import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to represent a database interface for a list of
 * <CODE>Car</CODE>'s. It using a plain-text file "cars.txt" to store and write
 * car objects in readable text form. It contains an <CODE>ArrayList</CODE>
 * called <CODE>carList</CODE> to store the database in a runtime friendly data
 * structure. The <CODE>carList</CODE> is written to "cars.txt" at the end of
 * the <CODE>Dealership</CODE> object's life by calling <CODE>flush()</CODE>.
 * This class also provides methods for adding, remove, and searching for cars
 * from the list.
 *
 * @author Vangelis Metsis
 */
public class Dealership {

    private ArrayList<Vehicle> carList;

    /**
     * This constructor is hard-coded to open "<CODE>cars.txt</CODE>" and
     * initialize the <CODE>carList</CODE> with its contents. If no such file
     * exists, then one is created. The contents of the file are "loaded" into
     * the carList ArrayList in no particular order. The file is then closed
     * during the duration of the program until <CODE>flush()</CODE> is called.
     * @throws IOException
     */
    public Dealership() throws IOException {
        carList = new ArrayList<>();
        Scanner carDatabase;

        File dataFile = new File("cars.txt");

        // If data file does not exist, create it.
        if (!dataFile.exists()) {
            System.err.println("Cars.txt does not exist, creating one now . . .");
            //if the file doesn't exists, create it
            PrintWriter pw = new PrintWriter("cars.txt");
            //close newly created file so we can reopen it
            pw.close();
        }

        carDatabase = new Scanner(new FileReader(dataFile));

        //Initialize the Array List with cars from cars.txt
        while (carDatabase.hasNextLine()) {

            // split values using the space character as separator
            String[] temp = carDatabase.nextLine().split(" "); 

            carList.add(new Vehicle(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]),
                    Integer.parseInt(temp[4]), Float.parseFloat(temp[5])));
        }

        //Cars list is now in the Array List Completely so we can close the file
        carDatabase.close();
    }

    /**
     * Method showCars displays the current list of cars in the Arraylist in no
     * particular order.
     *
     */
    public void showCars() {
        showCars(carList);
    }

    /**
     * Private method used as an auxiliary method to display a given ArrayList
     * of cars in a formatted manner.
     *
     * @param cars the car list to be displayed.
     */
    private void showCars(ArrayList<Vehicle> cars) {

        System.out.println(" __________________________________________________________________________________");
        System.out.println("| Entry | VIN    | Make           | Model          | Year | Mileage | Price        |");
        System.out.println("|----------------------------------------------------------------------------------|");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(String.format("| %-6s| %-7s| %-15s| %-15s| %-5s| %-8s| $%-12s|",
                    Integer.toString(i + 1), cars.get(i).getVin(), cars.get(i).getMake(), cars.get(i).getModel(),
                    Integer.toString(cars.get(i).getYear()), Integer.toString(cars.get(i).getMileage()),
                    String.format("%.2f", cars.get(i).getPrice())));
        }
        System.out.println("|__________________________________________________________________________________|\n");

    }

    /**
     * This method displays cars that have a price within the range of
     * <CODE>low</CODE> to <CODE>high</CODE>.
     *
     * @param low a float that is the lower bound price.
     * @param high a float that is the upper bound price.
     */
    public void showCarsRange(float low, float high) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        for (Vehicle car : carList) {
            if ((low <= car.getPrice()) && (car.getPrice() <= high)) {
                cars.add(car);
            }
        }
        showCars(cars);
    }

    /**
     * This method can be used to search for a car in the Arraylist of cars.
     *
     * @param vin a <CODE>String</CODE> that represents the vehicle
     * identification number of the car that to be searched for
     * @return the <CODE>int</CODE> index of the car in the Arraylist of cars,
     * or -1 if the search failed.
     */
    public int findCar(String vin) {

        int index = -1;

        for (int i = 0; i < carList.size(); i++) {
            String temp = carList.get(i).getVin();

            if (vin.equalsIgnoreCase(temp)) {
                index = i;
                break;
            }

        }

        return index;
    }

    /**
     * This method is used to add a car to the carList ArrayList. In order for a
     * car to be added to the ArrayList it must comply with the following:
     * <p>
     * 1. The car is not already in the ArrayList according to the VIN
     * as the unique key.
     * <p>
     * 2. The VIN string matches the following regular expression:
     * <CODE>"[A-Za-z0-9]{5}"</CODE> or in other words: it
     * is 5 avinhanumeric characters.
     * <p>
     * 3. The make of the car is only alphanumeric characters.
     * <p>
     * 4. The model of the car is only alphanumeric or contains a dash "-".
     * <p>
     * 5. The year model must be exactly four digits.
     * <p>
     * 6. The price must be non-negative.
     *
     * @param toAdd the <CODE>Car</CODE> object to add to the
     * <CODE>carList</CODE>
     */
    public void addCar(String vin, String make, String model, String year, String mileage, String price) {
        
        if (this.findCar(vin) != -1) {
            System.err.println("Car already exists in database. \n");
            return;
        }
        
        if (!vin.matches("[A-Za-z0-9]{5}")) {
            System.err.println("Invalid VIN: not proper format."
                        + "VIN must be at least 5 alphanumeric characters.");
            return;
        }
        
        if (!make.matches("[A-Za-z0-9]+")) {
            System.err.println("Invalid make type:\n"
                            + "The car's make must be an alphanumeric string.");
            return;
        }
        
        if (!model.matches("[A-Z0-9a-z\\-]+")) {
            System.err.println("Invalid model type:\n"
                                + "The car's model must be a non-numeric alphabet string.");
            return;
        }
        
        if (!year.matches("[0-9]{4}") ) {
            System.err.println("Invalid year:\n"
                                    + "The car's year of manufacture must be a 4 digit number. ");
            return;
        }
        
        if (!mileage.matches("[0-9]{1,6}")) {
            System.err.println("Invalid milage:\n"
                                    + "The car's mileage has to be an integer number between 0 and 999999. ");
            return;
        }
        
        if (Float.parseFloat(price) < 0) {
            System.err.println("The entered price cannot be negative.");
            return;
        }
        
        //If passed all the checks, add the car to the list
        carList.add(new Vehicle(vin, make, model, Integer.parseInt(year), 
                Integer.parseInt(mileage), Float.parseFloat(price)));
        System.out.println("Car has been added.\n"); 
    }

    /**
     * This method will remove a car from the <CODE>carList</CODE> ArrayList. It
     * will remove the first instance of a car that matches the car that was
     * passed to this method in the <CODE>carList</CODE> using the
     * <CODE>equals()</CODE> override in the class <CODE>Car</CODE>. If no such
     * car exists, it will produce an error message.
     *
     * @param toDelete the <CODE>car</CODE> object to be removed.
     */
    public void removeCar(Vehicle toDelete) {
        if (carList.remove(toDelete)) {
            System.out.println("Car was removed.\n");
        } else {
            System.err.println("Car does not exist in database.");
        }
    }

    /**
     * This method is used to retrieve the Car object from the
     * <CODE>carList</CODE> at a given index.
     *
     * @param i the index of the desired <CODE>car</CODE> object.
     * @return the <CODE>car</CODE> object at the index or null if the index is
     * invalid.
     */
    public Vehicle getCar(int i) {
        if (i < carList.size() && i >= 0) {
            return carList.get(i);
        } else {
            System.err.println("Invalid Index. Please enter another command or 'h' to list the commands.");
            return null;
        }
    }

    /**
     * This should be the last method to be called from this class. It opens
     * <CODE>"cars.txt"</CODE> and overwrites it with a text representation of
     * all the cars in the <CODE>carList</CODE>.
     * @throws IOException
     */
    public void flush() throws IOException {
        PrintWriter pw = new PrintWriter("cars.txt");

        for (Vehicle c : carList) {
            pw.print(c.toString());
        }

        pw.close();
    }

}