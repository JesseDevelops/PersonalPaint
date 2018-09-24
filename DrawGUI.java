package assignment8;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 *
 * @author Jesse.gajda@mohawkcollege.ca
 */
public class DrawGUI extends Application {
   

    // TODO: Instance Variables for View Components and Model
    private GraphicsContext gc;
    private double pressX;
    private double pressY;
    private javafx.scene.control.ColorPicker colorPicker;

    Circle circ;
    TextField valueX;
    Label xLabel;
    TextField valueY;
    ;
    Label yLabel;
    Group root;
    Scene scene;
    Label radiusLabel;
    TextField setRadius;
    Button drawIt;
    Button clearIt;

    // TODO: Private Event Handlers and Helper Methods
    /**
     * mouse handler for when we press mouse
     * creates circles wherever we click or drag
     * has a catch for exception and it returns in a separate window user input error
     * @param me 
     */
    
    /**
     * creates press handler for when mouse is pressed or dragged
     * creates a new circle each time mouse is dragged or pressed
     * @param me 
     */
    private void pressHandler(MouseEvent me) {

        try {
            pressX = me.getX();
            pressY = me.getY();

            String temp = setRadius.getText();
            int radiusTemp = Integer.parseInt(temp);
            circ.setRadius(radiusTemp);

            circ.setX(pressX);
            circ.setY(pressY);
            circ.draw(gc);

            System.out.println("Pressed " + me.getButton() + " at (" + me.getX() + "," + me.getY() + ").");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception working test");
           JOptionPane.showMessageDialog(null, "Enter a legal value for Radius", "Illegal Expression", JOptionPane.ERROR_MESSAGE);
          
            
        }
        
    }

   

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(javafx.stage.Stage stage) throws java.lang.Exception {
        root = new Group();
        scene = new Scene(root, 1000, 750, Color.CYAN); // set the size here
        stage.setTitle("Mouse Events"); // set the window title here
        stage.setScene(scene);
        String cssFile = "assignment8/Style.css";
        scene.getStylesheets().add(cssFile);
        // TODO: Add your GUI-building code here

        // 1. Create the model
        colorPicker = new ColorPicker();
        colorPicker.setValue(Color.BLUE);
        colorPicker.setLayoutX(200);
        colorPicker.setLayoutY(690);
        colorPicker.setPrefHeight(30);
        colorPicker.setPrefWidth(120);

        // 2. Create the GUI components
        Canvas c = new Canvas(1000, 650);
        circ = new Circle();
        valueX = new TextField("250");
        xLabel = new Label("X Coordinate");
        valueY = new TextField("250");
        yLabel = new Label("Y Coordinate");
        radiusLabel = new Label("Radius");
        setRadius = new TextField("10");
        drawIt = new Button("Draw It");
        clearIt = new Button ("Clear It");
      
        
       
        
        
        // 3. Add components to the root
        root.getChildren().add(c);
        root.getChildren().add(colorPicker);
        root.getChildren().add(valueX);
        root.getChildren().add(xLabel);
        root.getChildren().add(yLabel);
        root.getChildren().add(valueY);
        root.getChildren().add(radiusLabel);
        root.getChildren().add(setRadius);
        root.getChildren().add(drawIt);
        root.getChildren().add(clearIt);

        // 4. Configure the components (colors, fonts, size, location)
        valueX.setLayoutX(90);
        valueX.setLayoutY(680);
        valueX.setPrefWidth(70);
        xLabel.setLayoutX(0);
        xLabel.setLayoutY(685);

        yLabel.setLayoutX(180);
        yLabel.setLayoutY(685);
        valueY.setLayoutX(270);
        valueY.setLayoutY(680);
        valueY.setPrefWidth(70);

        radiusLabel.setLayoutX(350);
        radiusLabel.setLayoutY(685);
        setRadius.setLayoutX(410);
        setRadius.setLayoutY(680);
        setRadius.setPrefWidth(70);

        drawIt.setLayoutX(490);
        drawIt.setLayoutY(680);

        colorPicker.setLayoutY(680);
        colorPicker.setLayoutX(600);
        
        clearIt.setLayoutX(750);
        clearIt.setLayoutY(680);

        gc = c.getGraphicsContext2D();
        gc.setFill(Color.LIGHTYELLOW);
        gc.fillRect(0, 0, 1000, 650);
        // 5. Add Event Handlers and do final setup
        colorPicker.setOnAction(this::drawHandler);
        c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        c.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::pressHandler);
        drawIt.setOnAction(this::createHandler);
        clearIt.setOnAction(this::clearHandler);
        //  6. Show the stage
        stage.show();

    }
    
    

    /**
     * draw handler for our color picker
     * has the drop down color box
     * @param e 
      */
    
    private void drawHandler(javafx.event.ActionEvent e) {
        Color color = colorPicker.getValue();
        circ.setFillColor(color);

    }
    
    /**
     * clears and creates a new canvas
     * lets users remove all previous drawing
     * @param e 
     */
    private void clearHandler (javafx.event.ActionEvent e){
       gc.clearRect(0, 0, 1000, 650);
       gc.setFill(Color.LIGHTYELLOW);
       gc.fillRect(0, 0, 1000, 650);
        
    }

    /**
     * draws a circle on location x and y
     * draws circle based on radius
     * has to be inside the canvas or it wont draw 
     * its a drawIt button
     * @param e 
     */
    private void createHandler(javafx.event.ActionEvent e) {
        try{
            
        
        String xCoordtemp = valueX.getText();
        int xTemp = Integer.parseInt(xCoordtemp);
        circ.setX(xTemp);

        String yCoordtemp = valueY.getText();
        int yTemp = Integer.parseInt(yCoordtemp);
        circ.setY(yTemp);

        String temp = setRadius.getText();
        int radiusTemp = Integer.parseInt(temp);
        circ.setRadius(radiusTemp);
        
       circ.draw(gc);
        }
        catch (java.lang.NumberFormatException ex){
            System.out.println("test");
             JOptionPane.showMessageDialog(null, "Enter a legal value for Radius", "Illegal Expression", JOptionPane.ERROR_MESSAGE);
        }
        catch (java.lang.IllegalArgumentException exx){
            System.out.println("test2");
             JOptionPane.showMessageDialog(null, "Enter a legal value for X or Y coordinate", "Illegal Expression", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
