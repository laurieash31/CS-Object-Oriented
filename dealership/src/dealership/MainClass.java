package dealership;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the main class of the Dealership database manager. It provides a
 * console for a user to use the 5 main commands.
 *
 * @author Vangelis Metsis
 */
public class MainClass {

    /**
     * This method will begin the user interface console. Main uses a loop to
     * continue doing commands until the user types '6'. A lot of user input
     * validation is done in the loop. At least enough to allow the interface
     * with Dealership to be safe.
     *
     * @param args this program expects no command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        Dealership dealership = new Dealership();

        String welcomeMessage = "\nWelcome to the dealership database. Choose one of the following functions:\n\n"
                + "\t1. Show all existing car records in the database\n"
                + "\t2. Add a new car record to the database.\n"
                + "\t3. Delete a car record from a database.\n"
                + "\t4. Search for a car (given its VIN).\n"
                + "\t5. Show a list of cars within a given price range.\n"
                + "\t6. Exit program.\n";

        System.out.println(welcomeMessage);

        int selection = in.next().charAt(0);
        in.nextLine();

        while (selection != '6') {

            switch (selection) {
                case '1':
                    dealership.showCars();
                    break;
                case '2':
                    System.out.println("\nPlease type description of car with the following pattern:\n"
                            + "\nVIN MAKE MODEL YEAR MILEAGE PRICE\n"
                            + "example:\nDAW12 Honda Civic 2007 52333 9500.00\n");
                    String inTemp = in.nextLine();

                    String temp[] = inTemp.split(" ");

                    if (temp.length != 6) {
                        System.out.println("Not correct number of fields to process.");
                        break;
                    }

                    dealership.addCar(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
                    break;
                case '3':
                    dealership.showCars();

                    System.out.println("\nPlease select which number entry to delete from the database.\n");

                    int numToDelete = in.nextInt();
                    in.nextLine(); //Skip new line character
                    
                    dealership.removeCar(dealership.getCar(numToDelete - 1));
                    break;
                case '4':
                    System.out.println("\nEnter the VIN of the car you wish to see.\n");
                    String vin = in.next();
                    in.nextLine();
                    int index = dealership.findCar(vin);
                    if (index != -1) {
                        System.out.println("\nHere is the car that matched\n"
                                + dealership.getCar(index).toString()
                                + "\n");
                    } else {
                        System.out.println("\nSearch did not find a match.\n");
                    }
                    break;
                case '5':
                    float high = 0;
                    float low = 0;
                    
                    System.out.println("\nEnter lower-bound price.\n");
                    low = in.nextFloat();
                    System.out.println("\nEnter upper-bound price.\n");
                    high = in.nextFloat();
                    in.nextLine();
                    
                    dealership.showCarsRange(low, high);
                    break;
                case 'h':
                    System.out.println(welcomeMessage);
                    break;
                default:
                    System.out.println("That is not a recognized command. Please enter another command or 'h' to list the commands.");
                    break;

            }

            System.out.println("Please enter another command or 'h' to list the commands.\n");
            selection = in.next().charAt(0);

            in.nextLine();
        }

        in.close();
        dealership.flush();
        
        System.out.println("Done!");

    }
}