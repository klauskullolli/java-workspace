import javafx.application.Application;
//import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
//import javafx.scene.shape.Polygon;
//import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex_2 extends Application {

	@Override
	public void start(Stage stg1) throws Exception {
        Pane pan = new Pane() ;
		DrawLine(pan, 20) ;
		Scene scene  = new Scene(pan , 800 ,600) ;
		stg1.setScene(scene);
		stg1.setTitle("Exercise_2");
        stg1.show();
	}
    
	
	public void DrawLine(Pane pan , int nr ) {
		Line l1 ; 
		   for (int i = 0 ; i<nr ; i++) {
			  l1= new Line () ;
			  l1.endXProperty().bind(pan.widthProperty());
			  l1.endYProperty().bind(pan.heightProperty());
			  l1.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
			  l1.setRotate(i* (360/nr));
			  pan.getChildren().add(l1) ;
		   }
	 
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
         launch(args) ;
	}

}
