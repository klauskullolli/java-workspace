import java.io.File;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Class that shows information for a specific professor in  a Border Pane arrangement
public class ProfessorPane extends BorderPane {
	
	
	// Professor class needed to access professor object form other classes
	private  Professor professor = new Professor() ; 
	
	
	//Constructor of the class
	ProfessorPane(Professor professor ){
		this.professor = professor ;
		this.diplay();
	}
	
	//Main function where pane is created
	private void diplay() {
		//Alert window used to appear for different confirmations or warnings
		Alert alert = new Alert(AlertType.NONE); 
		
		//Used for arrangement of components 
		GridPane pane   = new GridPane() ;
		pane.setHgap(10);
		pane.setVgap(10);
	
		
		//Different labels to display info
		Label subt =  new Label (" Personal Info: ") ;
		subt.setPrefWidth(250);
		subt.setAlignment(Pos.CENTER);
		subt.setId("subt");
		subt.getStylesheets().add("stylesheet.css") ;
		
		Label l1 = new Label ("Professor Id: ") ;
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
		
		Label l5 = new Label ("Subject: ") ;
		l5.setPrefWidth(250);
		l5.setAlignment(Pos.CENTER);
		l5.setId("label1");
		l5.getStylesheets().add("stylesheet.css") ;
		
		Label t1 = new Label(String.format("%d",this.professor.getId())) ;
		t1.setPrefWidth(250);
		t1.setAlignment(Pos.BASELINE_LEFT);
		t1.setStyle("-fx-text-fill : black ; -fx-font-weight: bold; -fx-background-color:white;  -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif; ") ; 
 		
		Label t2 = new Label(this.professor.getName()) ;
		t2.setPrefWidth(250);
		t2.setAlignment(Pos.BASELINE_LEFT);
 		t2.setStyle("-fx-text-fill : black ; -fx-font-weight: bold; -fx-background-color:white  ;-fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif; ") ; 
 		
 		Label t3 = new Label(this.professor.getSurname()) ;
 		t3.setPrefWidth(250);
		t3.setAlignment(Pos.BASELINE_LEFT);
 		t3.setStyle("-fx-text-fill : black ; -fx-font-weight: bold; -fx-background-color:white ; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif; ") ; 
 		
 		Label t4 = new Label(this.professor.getEmail()) ;
 		t4.setPrefWidth(250);
		t4.setAlignment(Pos.BASELINE_LEFT);
 		t4.setStyle("-fx-text-fill : black ; -fx-font-weight: bold;  -fx-background-color:white; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;") ; 
 		
 		Label t5 = new Label(this.professor.getSubject()) ;
 		t5.setPrefWidth(250);
		t5.setAlignment(Pos.BASELINE_LEFT);
 		t5.setStyle("-fx-text-fill : black ; -fx-font-weight: bold; -fx-background-color:white;  -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;") ;
 		
 		
 		//This button is needed to access in exam paper and professor can change previous created exam or can create a new one 
 		Button examBut =  new Button ("Prepare exam") ; 
 		examBut.setId("examBut");
 		examBut.getStylesheets().add("stylesheet.css") ;
 		
 		//Arrangement of content 
 		pane.addRow(1,subt );
 		pane.addRow(2,l1 ,t1);
 		pane.addRow(3,l2 ,t2);
 		pane.addRow(4,l3 ,t3);
 		pane.addRow(5,l4 ,t4);
 		pane.addRow(6,l5);
 		pane.addRow(7,t5 ,examBut);
 		
 		
 		Text title =  new Text("Professor Window") ;
		title.setFill (Color.rgb(129, 171, 255));
		title.setStroke(Color.BLACK);
		title.setStyle(" -fx-font-weight: bold; -fx-font-size:38 ; -fx-font-family: \"Times New Roman\", Times, serif;");
		
		this.setTop(title);
		ProfessorPane.setMargin(title, new Insets(20, 40, 50, 60));
		ProfessorPane.setAlignment(title, Pos.CENTER);
		
		ProfessorPane.setMargin( pane, new Insets(-10, 50, 80, 50));
    	this.setCenter(pane);
    	this.getCenter().setStyle("-fx-background-color: rgba(149, 131, 54, 0.8)");
    	
    	
    	//Actions taken were exam button is pressed ;  there are shown different alert windows with specific info if something is not right  
    	examBut.setOnAction(e->{
    		File file = new File(String.format("%s.txt", this.professor.getSubject())) ;
    		if(file.length()==0) {
    			Stage stage = (Stage) examBut.getScene().getWindow();
    			stage.close();
    			ExamDisplay.dispalyProfessorExam(this.professor.getSubject());
    			
    		}
    		
    		else {
    			alert.setAlertType(AlertType.CONFIRMATION);
        		alert.setContentText("Do you want to submit the exam?");
        		Optional<ButtonType> result = alert.showAndWait();
    		
        		if(result.get() == ButtonType.OK) {
        			Stage stage = (Stage) examBut.getScene().getWindow();
        			stage.close();
        			ExamDisplay.dispalyProfessorExam(this.professor.getSubject());
        		}
    		}
    		
    	});
        
 		
 		
	}
}
