package assignment2;

/**
 * @author Austin Stamper
 * @author Laura Garcia
 */

/** This class defines the variables and methods  unique to a Truck */
public class Truck extends Vehicle implements java.io.Serializable{
    
    /** Default Constructor */
    public Truck(){}
    
    public Truck(float weight, float len){
        maxLoadWeight = weight;
        length = len;
    }
    /**
     * Sets the Max Load Weight
     * @param weightthe weight to be set 
     */
    public void setMaxLoadWeight(float weight){
        maxLoadWeight = weight;
    }
    
    /**
     * Returns the Max Load Weight
     * @return the Max Load Weight
     */
    public float getMaxLoadWeight(){
        return maxLoadWeight;
    }
    
    /**
     * Sets the Length
     * @param len the length to be set
     */
    public void setLength(float len){
        length = len;
    }
    
    /**
     * Returns the length
     * @return the length
     */
    public float getLength(){
        return length;
    }
    
    private float maxLoadWeight;
    private float length;
}
