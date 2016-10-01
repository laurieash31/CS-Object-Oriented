package assignment2;

/**
 * @author Laura Garcia
 * @author Austin Stamper
 */
public class PassengerCar extends Vehicle implements java.io.Serializable{
    
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
