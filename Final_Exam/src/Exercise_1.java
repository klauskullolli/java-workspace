import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise_1 extends Application {

	@Override
	public void start(Stage stg1) throws Exception {
		Label l1 = new Label("Room") ;
		Label l2 = new Label("Number of nights") ;
		Label l3 = new Label("Tax") ;
		Label l4 = new Label("Discount Rate") ;
		
		Alert alert = new Alert(AlertType.NONE); 
		
		TextField t1 = new TextField(); 
		TextField t2 = new TextField(); 
		TextField t3 = new TextField(); 

        CheckBox cec = new CheckBox("Does this item has tax applied?") ; 
		Button bt1 = new Button("Calculate total price") ;
		Button bt2 = new Button("Calculate total price with tax") ;
		
		GridPane  pane = new GridPane() ;
		pane.setVgap(10);
		pane.setHgap(10);
		pane.addRow(0, l1 ,t1);
		pane.addRow(1 ,l2 , t2);
		pane.addRow(2 ,bt1);
		pane.addRow(3 , l3 , cec);
		pane.addRow(4 ,l4 , t3);
		pane.addRow(5 ,bt2);
		
		bt1.setOnAction(e->{
			double a = Double.parseDouble(t1.getText()) ;
			double b = Double.parseDouble(t2.getText()) ;
			double price =a * b  ;
			alert.setAlertType(AlertType.INFORMATION);
    		alert.setContentText(String.format("Total price is: %.2f." ,price ));
    		alert.show();

		});
		
		bt2.setOnAction(e->{
			if (cec.isSelected()) {
				double a = Double.parseDouble(t1.getText()) ;
				double b = Double.parseDouble(t2.getText()) ;
				double c = Double.parseDouble(t3.getText()) ;
				double price =a *b*(1-c)  ;
				alert.setAlertType(AlertType.INFORMATION);
	    		alert.setContentText(String.format("Total price is: %.2f." ,price ));
	    		alert.show();
			}
			else {
				alert.setAlertType(AlertType.ERROR);
	    		alert.setContentText("You can not add tax if checkbox is not selected");
	    		alert.show();
			}
			
		});
		
		Scene scene  = new Scene(pane) ;
		stg1.setScene(scene);
		stg1.setTitle("Hotel");
	    stg1.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
