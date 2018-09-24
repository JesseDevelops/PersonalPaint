package assignment8;

import javafx.scene.canvas.GraphicsContext;

/**
 * The Circle class after inheritance. Comments removed for
 * display in class. Constructors removed because they require a separate
 * discussion.
 *
 * @author Jesse.gajda@mohawkcollege.ca
 */
public class Circle extends GeometricObject {

    //create instance variable for class circle
    private double radius;

    //getter for radius
    public double getRadius() {
        return radius;
    }

    //setter for radius 
    //throws exception when if statement is not true
    public void setRadius(double radius) {
        if (radius > 0 && radius < 300) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Bad value for radius");
        }
    }

    //getter for area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    //draw contents 
    //draws the circle
    //fills the circle
    
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.fillOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
        gc.strokeOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
    }

    //String for toString in circle class
    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';
    }

}
