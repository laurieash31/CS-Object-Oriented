package assignment2;

/**
 * @author Austin Stamper
 * @author Laura Garcia
 */
public class Truck extends Vehicle implements java.io.Serializable{
    
    public Truck(){}
    
    public Truck(float weight, float len){
        maxLoadWeight = weight;
        length = len;
    }
    
    public void setMaxLoadWeight(float weight){
        maxLoadWeight = weight;
    }
    
    public float getMaxLoadWeight(){
        return maxLoadWeight;
    }
    
    public void setLength(float len){
        length = len;
    }
    
    public float getLength(){
        return length;
    }
    
    private float maxLoadWeight;
    private float length;
}
