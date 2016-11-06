/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author Austin
 */
public class DealershipTest {
    
    private static ArrayList<Car> carList = new ArrayList<Car>();
    
    public DealershipTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {       
        carList.add(new Car("AJS172", "Honda", "Civic", 1998, 20145, 7898.90F));
        carList.add(new Car("ZZC974", "Toyota", "Celica", 2001, 100304, 9400.90F));
        carList.add(new Car("ABS669", "Ford", "Mustang", 1963, 400321, 3400.90F));
        System.out.println("Set up environment");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Cleared environment");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of showCars method, of class Dealership.
     */
    @Test
    public void testShowCars() {
        System.out.println("This is a test.");
    }

    /**
     * Test of showCarsRange method, of class Dealership.
     * @throws java.io.IOException
     */
    @Test
    public void testShowCarsRange() throws IOException {
        System.out.println("showCarsRange");
        
        //Test normal functionality
        float low = 0.0F;
        float high = 30000.0F;
        Dealership instance = new Dealership();
        instance.showCarsRange(low, high);
        
        //Test negative low
        low = -5.0F;
        instance.showCarsRange(low, high);
        
        //Test high < low
        low = 3.0F;
        high = 2.0F;
        instance.showCarsRange(low, high);
                
    }

    /**
     * Test of findCar method, of class Dealership.
     * @throws java.io.IOException
     */
    @Test
    public void testFindCar() throws IOException {
        System.out.println("findCar");
        String vin = "ZZC974";
        Dealership instance = new Dealership();
        int expResult = 2;
        int result = instance.findCar(vin);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCar method, of class Dealership.
     * @throws java.io.IOException
     */
    @Test
    public void testAddCar() throws IOException {
        System.out.println("addCar");
        String vin = "";
        String make = "";
        String model = "";
        String year = "";
        String mileage = "";
        String price = "";
        Dealership instance = new Dealership();
        instance.addCar(vin, make, model, year, mileage, price);
        
        //Test vin > 5 characters
        vin = "Helloo";
        instance.addCar(vin, make, model, year, mileage, price);
        
    }

    /**
     * Test of removeCar method, of class Dealership.
     * @throws java.io.IOException
     */
    @Test
    public void testRemoveCar() throws IOException {
        System.out.println("removeCar");
        Car toDelete = null;
        Dealership instance = new Dealership();
        instance.removeCar(toDelete);
        
        //Add Car, then delete it
        instance.addCar(null, null, null, null, null, null);
        instance.removeCar(null);
    }

    /**
     * Test of getCar method, of class Dealership.
     * @throws java.io.IOException
     */
    @Test
    public void testGetCar() throws IOException {
        System.out.println("getCar");
        Dealership instance = new Dealership();
        
        //Add a car and then search for it
        instance.addCar(null, null, null, null, null, null);
        int i = 1;       
        Car expResult = null;
        Car result = instance.getCar(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of flush method, of class Dealership.
     * @throws java.lang.Exception
     */
    @Test
    public void testFlush() throws Exception {
        System.out.println("flush");
        Dealership instance = new Dealership();
        instance.flush();
    }
    
}
