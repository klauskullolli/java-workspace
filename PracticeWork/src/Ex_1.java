

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;


public class Ex_1 extends Application {
 @Override // Override the start method in the Application class
 public void start(Stage stg1) {
 // Create a pane and set its properties
	Label l1 = new Label("Put A :") ;
	Label l2 = new Label("Put B :") ;
	Label l3 = new Label("Put C :") ;
	TextField t1 = new TextField(); 
	TextField t2 = new TextField(); 
	TextField t3 = new TextField(); 
	TextField t4 = new TextField(); 
	
	Button button = new Button ("Cal the area") ;
	button.setOnAction(e->{
		try {
			double a = Double.parseDouble(l1.getText()) ;
			double b = Double.parseDouble(l2.getText()) ;
			double c = Double.parseDouble(l3.getText()) ;
			
			if(a+b<c || a+c<b || b+c < a) {
				t4.setText("this is not a trinagle");
			}
			
			else {
				double s = (a+ b + c) / 2  ;
				double area = Math.sqrt(s*(s-a)*(s-b)*(s-c)) ;
				t4.setText(String.format("%.2f", area)) ;
			}
		}
		catch (Exception ex) {
			t4.setText("Please input an double in each space!");
		}
	});
	
	GridPane  pane = new GridPane() ;
	pane.addRow(0, l1 ,t1);
	pane.addRow(1 ,l2 , t2);
	pane.addRow(2 ,l3 , t3);
	pane.addRow(3 , t2);
	pane.addRow(4 , button);
	
	Scene scene  = new Scene(pane , 800 ,600) ;
	stg1.setScene(scene);
	stg1.setTitle("Exercise_2");
    stg1.show();

	
 }
 public static void main(String[] args) {
		launch(args) ;

	}
 
}

   
   
   
   
   