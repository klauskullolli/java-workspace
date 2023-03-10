import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


//This is Border pane inherited class needed to arrange student window
public class StudentPane  extends BorderPane {
	
	//Needed to show information for a specific student form database
	private Student student  = new Student() ;
	
	
	//Constructor
	StudentPane( Student student){
		this.student = student  ;
		diplay() ;
	}
	
	
	
	// Needed to arrange subject in a visible VBox 
	//here student can see if they have taken the exams of subject 
	//if they haven't taken they can take and complete the exam
	private VBox   subjectPane() {
		
		Alert alert = new Alert(AlertType.NONE); 
		VBox vb  = new VBox(10) ;
 		vb.setAlignment(Pos.CENTER);
 		
 		//Iteration over the number of subject for the given student
 		for (int i=0 ; i< this.student.getSubjects().size() ; i++) {
 			HBox hb = new HBox(30) ;
 			
 			Label l1  = new Label(this.student.getSubjects().get(i).getSubject()) ;
 			l1.setPrefWidth(250);
 			l1.setAlignment(Pos.BASELINE_LEFT);
 			l1.setStyle("-fx-text-fill : black ; -fx-font-weight: bold; -fx-background-color:white;  -fx-font-size:24 ; -fx-font-family: \"Times New Roman\", Times, serif; ") ; 
 			
 			hb.getChildren().add(l1) ;
 			
 			Button subButt  ; 
 			
 			//for a specific subject see if student has done the exam or no 
 			if(this.student.getSubjects().get(i).isCompleted()) {
 				subButt = new Button("Graded") ;
 				subButt.setId("examBut");
 	 			subButt.getStylesheets().add("stylesheet.css") ;
 	 			
 				ExamPoints exam = this.student.getSubjects().get(i) ;
 				subButt.setOnAction(e->{
 					alert.setAlertType(AlertType.INFORMATION);
 					alert.setContentText(String.format("You have taken %d points.", exam.getPoints()));
 					alert.show();
 				});
 				
 			}
 			
 			
 			else {
 				subButt = new Button("Take exam") ;
 				subButt.setId("examBut");
 	 			subButt.getStylesheets().add("stylesheet.css") ;
 	 			
 				ExamPoints exam = this.student.getSubjects().get(i) ;
 				subButt.setOnAction(e->{
 					
 					
 					
					try {
						Stage stage = (Stage) subButt.getScene().getWindow();
	        			stage.close();
						ExamDisplay.dispalyStudentExam(student ,exam);
						
						
					} catch (IOException e1) {
						alert.setAlertType(AlertType.WARNING);
	 					alert.setContentText("Something went wrong.");
	 					alert.show();
					}
 					
 				});
 				
 			}
 			
 			hb.getChildren().add(subButt) ;
 			
 			vb.getChildren().add(hb) ;
 			
 		}

 		
 		return vb ; 
	}
	
	
	
	//Main function that arrange the entire pane 
	
	private void diplay() {
		
		
		
		GridPane pane   = new GridPane() ;
		pane.setHgap(10);
		pane.setVgap(10);
	
		
		
		Label subt =  new Label (" Personal Info: ") ;
		subt.setPrefWidth(250);
		subt.setAlignment(Pos.CENTER);
		subt.setId("subt");
		subt.getStylesheets().add("stylesheet.css") ;
		
		Label l1 = new Label ("Student Id: ") ;
		l1.setPrefWidth(250);
		l1.setAlignment(Pos.CENTER);
		l1.setId("label");
		l1.getStylesheets().add("stylesheet.css") ;
		
		Label l2 = new Label ("Name: ") ;
		l2.setPrefWidth(250);
		l2.setAlignment(Pos.CENTER);
		l2.setId("label");
		l2.getStylesheets().add("stylesheet.css") ;
		
		Label l3 = new Label ("Surname: ") ;
		l3.setPrefWidth(250);
		l3.setAlignment(Pos.CENTER);
		l3.setId("label");
		l3.getStylesheets().add("stylesheet.css") ;
		
		Label l4 = new Label ("Email: ") ;
		l4.setPrefWidth(250);
		l4.setAlignment(Pos.CENTER);
		l4.setId("label");
		l4.getStylesheets().add("stylesheet.css") ;
		
		Label l5 = new Label ("Subjects: ") ;
		l5.setPrefWidth(250);
		l5.setAlignment(Pos.CENTER);
		l5.setId("label1");
		l5.getStylesheets().add("stylesheet.css") ;
		
		Label t1 = new Label(String.format("%d",this.student.getId())) ;
		t1.setPrefWidth(250);
		t1.setAlignment(Pos.CENTER);
		t1.setStyle("-fx-text-fill : black ; -fx-font-weight: bold; -fx-background-color:white;  -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif; ") ; 
 		
		Label t2 = new Label(this.student.getName()) ;
		t2.setPrefWidth(250);
		t2.setAlignment(Pos.CENTER);
 		t2.setStyle("-fx-text-fill : black ; -fx-font-weight: bold; -fx-background-color:white  ;-fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif; ") ; 
 		
 		Label t3 = new Label(this.student.getSurname()) ;
 		t3.setPrefWidth(250);
		t3.setAlignment(Pos.CENTER);
 		t3.setStyle("-fx-text-fill : black ; -fx-font-weight: bold; -fx-background-color:white ; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif; ") ; 
 		
 		Label t4 = new Label(this.student.getEmail()) ;
 		t4.setPrefWidth(250);
		t4.setAlignment(Pos.CENTER);
 		t4.setStyle("-fx-text-fill : black ; -fx-font-weight: bold;  -fx-background-color:white; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;") ; 
 		
 		
 		pane.addRow(1,subt );
 		pane.addRow(2,l1 ,t1);
 		pane.addRow(3,l2 ,t2);
 		pane.addRow(4,l3 ,t3);
 		pane.addRow(5,l4 ,t4);
 		pane.addRow(6,l5);
 		
 		//here is the arrangement of subjects 
 		VBox vb =  subjectPane() ;
 		
 		
 		
 		Text title =  new Text("Student Window") ;
		title.setFill (Color.rgb(82, 0, 196));
		title.setStroke(Color.BLACK);
		title.setStrokeWidth(2);
		title.setStyle(" -fx-font-weight: bold; -fx-font-size:38 ; -fx-font-family: \"Times New Roman\", Times, serif;");
		
		this.setTop(title);
		ProfessorPane.setMargin(title, new Insets(20, 40, 50, 60));
		ProfessorPane.setAlignment(title, Pos.CENTER);
		
		ProfessorPane.setMargin( pane, new Insets(-10, 50, 80, 50));
    	this.setCenter(pane);
    	this.getCenter().setStyle("-fx-background-color: rgba(149, 131, 54, 0.8)");
    	
    	ProfessorPane.setMargin( vb, new Insets(-60, 50, 80, 50));
    	this.setBottom(vb);
 		
 		
	}
}
