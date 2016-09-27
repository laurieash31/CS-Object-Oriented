/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 * @author Austin Stamper
 * @author Laura Garcia
 */
public class Truck extends Vehicle{
    
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
