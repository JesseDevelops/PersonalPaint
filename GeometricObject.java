package assignment8;

import javafx.scene.paint.Color;

/**
 * The parent class for Circle and Rectangle. Comments removed for display in
 * class. Constructors removed because they require a separate discussion.
 *
 * @author Jesse.gajda@mohawkcollege.ca
 */
public class GeometricObject {
    //create instance variables

    private double x = 60, y = 100;
    private Color fillColor;
    
    //getter for variable X
    public double getX() {
        return x;
    }

    //sets value for x
    //throws exception if statement isnt true
    public void setX(double x) {
        if (x > 0 && x <1015){

            this.x = x;
        } else {
            throw new IllegalArgumentException("Bad value for x");
        }
    }
    
    //getter for variable y
    public double getY() {
        return y;
    }

    //sets value for y
    //throws exception if statement isnt true
    //doesnt make program crash
    public void setY(double y) {
        if (y > 0 && y < 665) {
            this.y = y;
        } else {
            System.out.println("test");
            throw new IllegalArgumentException("Bad value for y");
            
        }
    }

  
    //getter for color
    public Color getFillColor() {
        return fillColor;
    }

    //setter for fillColor variable
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    //String for toString in geometic object class
    @Override
    public String toString() {
        return "GeometricObject{" + "x=" + x + ", y=" + y + ", fillColor=" + fillColor + '}';
    }

   

    

}
