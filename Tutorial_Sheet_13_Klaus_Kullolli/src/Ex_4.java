
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex_4 extends Application {

	@Override
	public void start(Stage stg1) throws Exception {
		// TODO Auto-generated method stub
		Pane pan = new Pane() ;
		
		
		Scene scene  = new Scene(pan , 600 ,600) ;
		ChessBord(pan) ;
		stg1.setScene(scene);
		stg1.setTitle("Exercise_3");
        stg1.show();
	}
	
	
	public void ChessBord (Pane  pan) {
		Rectangle rec ; 
		for (int i = 0 ; i<8 ; i++ ) {
			
			for (int j =0 ; j<8 ; j++) {
				rec = new Rectangle() ;
				 rec.setX(i*(pan.widthProperty().divide(8).doubleValue()));
				 rec.setY(j*(pan.heightProperty().divide(8).doubleValue()));
				 rec.setWidth(pan.widthProperty().divide(8).doubleValue());
				 rec.setHeight(pan.heightProperty().divide(8).doubleValue());
				 if((i+j)%2==0) rec.setFill(Color.YELLOW);
		         else  rec.setFill(Color.BLACK);
		      pan.getChildren().add(rec);
				}
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args) ;
	}

}
