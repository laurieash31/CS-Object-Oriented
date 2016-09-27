package assignment2;

/**
 * @author Austin Stamper
 * @author Laura Garcia
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
