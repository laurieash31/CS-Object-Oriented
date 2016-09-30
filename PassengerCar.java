package assignment2;

/**
 *
 * @author lauragarcia
 * @author Austin Stamper
 */
public class PassengerCar extends Vehicle{
    
    public PassengerCar(){}
    
    public PassengerCar(String style){
        bodyStyle = style;
    }
    
    public void setBodyStyle(String style){
        bodyStyle = style;
    }
    
    public String getBodyStyle(){
        return bodyStyle;
    }
    
    private String bodyStyle;
}
