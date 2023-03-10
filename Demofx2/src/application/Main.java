package application;
import java.awt.Button;

import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
//import java.util.* ; 

public class Main extends Application {
	@Override
	public void start(Stage stg1) throws Exception  {
	
			Circle cr = new Circle() ;
			cr.setCenterX(100);
			cr.setCenterY(100);
			cr.setRadius(100);
			cr.setStrokeLineCap(Color.BLACK) ;
			cr.setFill(Color.WHITE) ;
			Pane pan = new Pane() ;
			pan.getChildren().add(cr) ; 
			Scene scene = new Scene(pan  ,400,400);
			stg1.setTitle("Klaus");
			stg1.setScene(scene);
			stg1.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
