package assignment2;

/**
 *
 * @author lauragarcia
 */
public class PassengerCar extends Vehicle{
    
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
