package drawCircleJavaFX;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DrawCircle extends Application{

    float radius = 10;
    Color color = Color.RED;
    private Logger logger = Logger.getLogger(DrawCircle.class.getName());
    @Override
    public void start(Stage stage) {
        Label input = new Label("Enter a new number for the circle radius: ");
        TextField t1 = new TextField();
        Label input2 = new Label("Enter a new color for the circle: ");
        ColorPicker cp = new ColorPicker(Color.RED);
        //t1.setAlignment(Pos.CENTER);
        Button btn = new Button("Draw the circle");

        Circle circle = new Circle(radius, Color.RED);
        circle.setCenterX(800.0f);
        circle.setCenterY(335.0f);
        // circle.setFill(Color.DARKCYAN);
        //circle.setStrokeWidth(8.0);
        //circle.setStroke(Color.DARKSLATEGREY);
        
        GridPane r = new GridPane();
        //Setting size for the pane  
        
        r.setMinSize(1000, 500);
        //  r.setGridLinesVisible(true);
        r.setAlignment(Pos.TOP_CENTER);
        //Setting the padding  
        r.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns 
        r.setVgap(15);
        r.setHgap(15);

        //Setting the Grid alignment 
        
        r.add(input, 0, 0);
        r.add(t1, 2, 0);
        r.add(input2, 0, 1);
        r.add(cp, 2, 1);
        r.add(btn, 2, 3);
        
        /*
        r.addRow(0, input, t1);
        r.addRow(1, input2, cp);
        r.addRow(2, btn);
         */
        Group root = new Group(circle, r);
        Scene scene = new Scene(root, 1000, 500);
        stage.centerOnScreen();
        stage.setTitle("Drawing a Circle: exam practice 51 by nickaiva");
        stage.setScene(scene);
        stage.setMaximized(true);

        EventHandler<ActionEvent> ev = new EventHandler<ActionEvent>() {
            

			public void handle(ActionEvent e) {
                if (!validate(t1.getText())) {
                    t1.setText("Invalid input");
                }
                
                try {
					radius = Float.parseFloat(t1.getText());
				} catch (NumberFormatException e2) {
					logger.log(Level.INFO, "Non numerical input");
				}
				// color
                Color c = cp.getValue();

                // set text of the label to RGB value of color
                input2.setText("Red = " + c.getRed() + ", Green = " + c.getGreen()
                        + ", Blue = " + c.getBlue());
                //System.out.println("The num you entered : " + radius);
                circle.setRadius(radius);
                circle.setFill(c);
            }
        };

        btn.setOnAction(ev);
        stage.show();
    }

    public boolean validate(final String input) {
        Pattern pattern;
        Matcher matcher;
        String PATTERN = "^([0-9]+)$";
        pattern = Pattern.compile(PATTERN);
        matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
