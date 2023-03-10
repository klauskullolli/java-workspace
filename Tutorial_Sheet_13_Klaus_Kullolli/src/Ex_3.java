import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import javafx.stage.Stage;

public class Ex_3 extends Application {

	@Override
	public void start(Stage stg1) throws Exception {
		 Pane pan = new Pane() ;
			//DrawLine(pan, 20) ;

			Rectangle rec = new Rectangle (200  , 300 , 400  ,200  ) ;
			rec.setStroke(Color.BLACK);
			rec.setFill(Color.WHITE);
		    pan.getChildren().add(rec);
		    
		    rec = new Rectangle (250  , 350 , 50  ,50  ) ;
			rec.setStroke(Color.BLACK);
			rec.setFill(Color.RED);
		    pan.getChildren().add(rec);
		    
		    rec = new Rectangle (500  , 350 , 50  ,50  ) ;
			rec.setStroke(Color.BLACK);
			rec.setFill(Color.RED);
		    pan.getChildren().add(rec);
		    
		    Line l1 = new Line (150, 350 , 400, 100);
		    l1.setStroke(Color.BLACK);
		    pan.getChildren().add(l1);
		    
		    l1 = new Line (650, 350 , 400, 100);
		    l1.setStroke(Color.BLACK);
		    pan.getChildren().add(l1);
		    
			Scene scene  = new Scene(pan , 800 ,600) ;
			stg1.setScene(scene);
			stg1.setTitle("Exercise_3");
	        stg1.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args) ;

	}

}
