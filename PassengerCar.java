package assignment2;

/**
 * @author Laura Garcia
 * @author Austin Stamper
 */

/** This class defines the variables and methods unique to a Passenger Car */
public class PassengerCar extends Vehicle implements java.io.Serializable{
    
    /** Default Constructor */
    public PassengerCar(){}
    
    public PassengerCar(String style){
        bodyStyle = style;
    }
    
    /**
     * Sets the Body Style
     * @param style the body style to be set
     */
    public void setBodyStyle(String style){
        bodyStyle = style;
    }
    
    /**
     * Returns the Body Style
     * @return the Body Style
     */
    public String getBodyStyle(){
        return bodyStyle;
    }    
    private String bodyStyle;
}
