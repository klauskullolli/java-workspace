import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

//This a stack pane used to display time passing during the exam using animation
public class Timer  extends StackPane{
	private int minutes ;
	private ExamPoints exam ; 
	private int id  ; 
	
	
	private void saveStudent() throws IOException {
		StudentList students =  new StudentList() ;
	    String content = Files.readString(Paths.get("StudentsData.txt"));
	    students.toClass(content);
	    students.getStudent(id-1).addPoints(exam.getSubject(), 0);
	    PrintWriter output  = new PrintWriter("StudentsData.txt") ;
	    output.print(students) ;
	    output.close();
	    
	}	
	//Constructor 
	Timer(int mintes ,  ExamPoints exam  ,int id ){
		this.minutes=mintes ; 
		this.exam = exam ;
		this.id = id ; 
		this.display();
	}
	
	
	//main function that create pane according to time
	private void display() {
		
		Alert alert = new Alert(AlertType.NONE); 
		
		
		
		Label l1 = new Label () ; 
		Label l2 = new Label () ; 
		if(minutes<10)l2.setText(String.format("0%d", this.minutes));
		
		else l2.setText(String.format("%d", this.minutes));
		
		l1.setText("00");
		
		Label l3  = new Label(":") ;
		
		l1.setStyle("-fx-font-size :  30 ;-fx-text-fill : Red ;-fx-font-weight: bold; ");
		l2.setStyle("-fx-font-size :  30 ; -fx-text-fill : Red ;-fx-font-weight: bold;");
		l3.setStyle("-fx-font-size :  30 ; -fx-text-fill : Red ;-fx-font-weight: bold;");
		
		//this is the event that perform time passing 
		//if times is 0 than a warning window that show that you have taken 0 points  
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
			
			else if (sec>0 ) {
				sec-- ;
				if(sec<10)
				l1.setText(String.format("0%d", sec));
				else l1.setText(String.format("%d", sec));
				}
			else {
				Stage stage = (Stage) this.getScene().getWindow();
				stage.close();
				alert.setAlertType(AlertType.WARNING);
        		alert.setContentText("Time is over! You took 0 points");
        		try {
					this.saveStudent();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				alert.show();
				alert.setOnCloseRequest(ex->{
					
					ProgramExecution.mainWindow();});
			   }
			};
			HBox hb = new HBox(5) ;
			hb.getChildren().addAll(l2,l3 ,l1) ;
		
			//Animation starts here
			Timeline animation = new Timeline(
					new KeyFrame(Duration.millis(1000),eventHandler1 ));
			animation.setCycleCount(this.minutes*60 + 1);
			animation.play(); 
	
			
		
			
			this.getChildren().add(hb) ;
		
		
		
		 }
		}

