import javafx.animation.Animation;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Ex_10 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		
		 BorderPane pane1 = new BorderPane() ;
		
		 // Place text into the stack pane
		Timeline animation = new Timeline() ;
		animation.play();
		
		// Create a handler for changing text
	
		
		Label l1 = new Label () ; 
		Label l2 = new Label () ; 
		l2.setText("02");
		l1.setText("12");
		Label l3  = new Label(":") ;
		l1.setStyle("-fx-font-size :  30 ;-fx-text-fill : Red ;-fx-font-weight: bold; ");
		l2.setStyle("-fx-font-size :  30 ; -fx-text-fill : Red ;-fx-font-weight: bold;");
		l3.setStyle("-fx-font-size :  30 ; -fx-text-fill : Red ;-fx-font-weight: bold;");
		
		EventHandler<ActionEvent> eventHandler1 = e -> {
			int min = Integer.parseInt(l2.getText()) ;
			int sec = Integer.parseInt(l1.getText()) ;
			if(sec==0 && min!=0) {
				min-- ;
				sec=59;
				if(min<10){
					l1.setText(String.format("%d", sec));
					l2.setText(String.format("0%d", min)); }
				else {
					l1.setText(String.format("%d", sec));
					l2.setText(String.format("%d", min));
				}
			}
			if (sec>0 ) {
				sec-- ;
				if(sec<10)
				l1.setText(String.format("0%d", sec));
				else l1.setText(String.format("%d", sec));
			}
			else primaryStage.close();
			
		};
		
		HBox hb = new HBox(5) ;
		hb.getChildren().addAll(l2,l3 ,l1) ;
	
		 animation = new Timeline(
				new KeyFrame(Duration.millis(1000),eventHandler1 ));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play(); 
		
		
		
		// Pause and resume animation
		pane.getChildren().add(hb) ;
		BorderPane.setMargin(pane, new Insets(70, 50, 70, 40));
		BorderPane.setAlignment(pane, Pos.CENTER);
		pane1.setCenter(pane);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane1);
		primaryStage.setTitle("TimelineDemo"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) {
		launch(args) ;

		}
	}