import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Ex_1 extends Application {

	@Override
	public void start(Stage stg1) throws Exception {

		Pane pan = new Pane() ;
		
		Circle cr = new Circle(100 , 100 , 50) ;
		cr.setFill(Color.BLUE);
		
		Line l1 = new Line(100 , 500 , 500 , 100) ;
		l1.setFill(Color.BLUE);
		l1.setStrokeWidth(4);
		
		Rectangle rec = new Rectangle (330  , 230 , 60  ,40  ) ;
		rec.setFill(Color.YELLOW);
		
		double[]polypoint = {200.0, 50.0, 
				   400.0, 343.0, 
				   450.0, 230.0,          
				   400.0, 400.0, 
				   200.0, 200.0,                   
				   150.0, 400.0} ; 
		Polygon pol = new Polygon(polypoint) ; 
		pol.setStroke(Color.BLACK) ; 
		pol.setFill(Color.WHITE);
		pan.getChildren().addAll( rec , l1 , cr , pol  ) ; 
		Ellipse(pan) ;
		Scene scene  = new Scene(pan , 800 ,600) ;
		stg1.setScene(scene);
		stg1.setTitle("Exercise_1");
        stg1.show();
	}
    
	
	public void Ellipse(Pane pan ) {
		Ellipse elips ;
		   for (int i = 0 ; i<16 ; i++) {
			  elips = new Ellipse(600 , 500 , 60 , 40  );
			   elips.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			   elips.setRotate(i* (360/16));
			   pan.getChildren().add(elips) ;
		   }
	} 
		
		   
		  
		 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        launch(args) ;
	}

}
