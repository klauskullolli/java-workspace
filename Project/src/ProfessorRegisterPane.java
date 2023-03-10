import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


//Class that inherits properties of BorderPane to form a specific pane for registration of Professors 
public class ProfessorRegisterPane extends BorderPane  {
	

	//Used to define if a subject is selected at least  ;
	private boolean clicked  = false ;
	
	//Create a list of student class needed to save student on database
	private ProfessorList professors=  new ProfessorList() ;
	
	// Constructor of class
	ProfessorRegisterPane() throws IOException{
		
		// read firstly content from database and then put data on database
		String content = Files.readString(Paths.get("ProfessorsData.txt"));
		
		if(content.isEmpty()) {
			
			this.dispaly();}
		else {
			this.professors.toClass(content);
			this.dispaly();
		}
		
	}
	
	//Used to save updates in database ; 
	private void saveProfessor() throws FileNotFoundException {
		PrintWriter output  = new PrintWriter("ProfessorsData.txt") ;
	    output.print(professors) ;
	    output.close();
	}
	
	
	//Is  a title animation function that display title moving 
	private static Pane titleAnimation(  Text text) {
		StackPane pane = new StackPane() ;
        String str = text.getText() ; 
        pane.getChildren().add(text) ;
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.1),
                event -> {
                    if (i.get() > str.length()) {
                        timeline.stop();
                    } else {
                        text.setText(str.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        return pane ;
	}
	
	
	//Method used to check if any of texfieled in pane is empty 
	private boolean  isEmty(ArrayList<TextField > field) {
		for (int i = 0 ; i < field.size() ; i++)
			if(field.get(i).getText().isEmpty() ) return true ;
		return false  ; 
	}
	
	
	//Main method that form pane where a professor 
	private void dispaly()  throws FileNotFoundException  {
		
		// Needed alert window to display message for different tasks
		Alert alert = new Alert(AlertType.NONE); 
		
		//Professor class to save registration form pane to class 
		Professor professor = new Professor() ;
		
		//Pane to organize window
		GridPane pane   = new GridPane() ;
		pane.setHgap(15);
		pane.setVgap(10);
		
		
		//The other are different  labels for data
		Label t1 = new Label("Name") ;
		t1.setPrefWidth(200);
		t1.setAlignment(Pos.CENTER);
		t1.setStyle(" -fx-text-fill : white ; -fx-border-color: #008B8B ; -fx-background-color:rgba(54, 0, 255, 0.8) ; -fx-font-weight: bold; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
		
		
		Label t2 = new Label("Surname") ;
		t2.setStyle("-fx-text-fill : white ; -fx-border-color: #008B8B ; -fx-background-color:rgba(54, 0, 255, 0.8) ; -fx-font-weight: bold; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
		t2.setPrefWidth(200);
		t2.setAlignment(Pos.CENTER);
		
		Label t3 = new Label("Email") ;
		t3.setStyle("-fx-text-fill : white ;-fx-border-color: #008B8B ; -fx-background-color:rgba(54, 0, 255, 0.8) ; -fx-font-weight: bold; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
		t3.setPrefWidth(200);
		t3.setAlignment(Pos.CENTER);
		
		Label t4 = new Label("Password") ;
		t4.setStyle("-fx-text-fill : white ; -fx-border-color: #008B8B ; -fx-background-color:rgba(54, 0, 255, 0.8) ; -fx-font-weight: bold; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
		t4.setPrefWidth(200);
		t4.setAlignment(Pos.CENTER);
		
		Label t5 = new Label("Confirm Password") ;
		t5.setStyle("-fx-text-fill : white ; -fx-border-color: #008B8B ; -fx-background-color:rgba(54, 0, 255, 0.8) ; -fx-font-weight: bold; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
		t5.setPrefWidth(200);
		t5.setAlignment(Pos.CENTER);
		
		//Text field array is needed to check more simple if any of them is empty
		ArrayList<TextField > field  =  new ArrayList<TextField >() ;
		TextField f1 = new TextField() ;
		f1.setPrefWidth(250);
		field.add(f1) ;
		
		TextField f2 = new TextField() ;
		f2.setPrefWidth(200);
		field.add(f2) ;
		
		TextField f3 = new TextField() ;
		f3.setPrefWidth(200);
		field.add(f3) ;
		
		PasswordField f4 = new PasswordField() ;
		f4.setPrefWidth(200);
		field.add(f4) ;
		
		PasswordField f5 = new PasswordField() ;
		f5.setPrefWidth(200);
		field.add(f5) ;
		
		//Combo box used to arrange subject in better way and select any of them if is needed
		ComboBox<String> subBox  = new ComboBox<String>() ;
		subBox.setPrefWidth(180);
		subBox.setStyle("-fx-font-size:14");
		
		//Class that contain lists
    	SubjectList subLis = new SubjectList() ;
    	
    	ArrayList <String> subs =  subLis.getSubjectList() ;
    	
    	//This loop is needed to filter all subject that are selected from other professors
    	
    	for(int j=0 ; j< professors.getPorfessorList().size()  ; j++ ) {
			 if(subs.contains(professors.getPorfessorList().get(j).getSubject())) {
				 subs.remove(professors.getPorfessorList().get(j).getSubject()) ;
			 }
			}
    	
    	//Condition is necessary to display a warning window if there is no subject to select
    	if(subs.isEmpty()) {
    		alert.setAlertType(AlertType.WARNING);
    		alert.setContentText("You can not register! There is no subject to teach.");
    		Optional<ButtonType> result = alert.showAndWait();
		
    		if(result.get() == ButtonType.OK) {
    			
        			Stage stage = (Stage) subBox.getScene().getWindow();
        			stage.close();
    			}
    		}
    	
    	//All subject are arranged in combo box
    	subBox.getItems().addAll(subs) ;
    	
    	//Button to confirm subject 
    	Button addSub  = new Button("Add subject") ;
    	addSub.setStyle(" -fx-font-weight: bold; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ; 
		
    	//Arrangement of elements of class
		pane.addRow(1,t1 ,f1);
		pane.addRow(2,t2 ,f2);
		pane.addRow(3,t3 ,f3);
		pane.addRow(4,t4 ,f4);
		pane.addRow(5,t5 ,f5);
		pane.addRow(6, subBox ,addSub);
		
		addSub.setOnAction(e->{
			
			try {	
				
				professor.setSubject(subBox.getValue().strip());
				addSub.setDisable(true); 
				this.clicked = true ;	
				subBox.setEditable(false);
			
			}
			catch(Exception ex) {
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("There is no subject selected");
				alert.show();
			}	
		}) ;
	
		//Button to save registered professor 
		Button savebut =  new Button ("Save")  ;
		savebut.setId("savebut");
		savebut.getStylesheets().add("stylesheet.css") ;
		
		Text title =  new Text("Complete Registration") ;
		title.setFill (Color.rgb(129, 171, 255));
		title.setStroke(Color.BLACK);
		title.setStyle(" -fx-font-weight: bold; -fx-font-size:38 ; -fx-font-family: \"Times New Roman\", Times, serif;");
		
		this.setTop(titleAnimation(title));
		ExamPane.setMargin( pane, new Insets(10, 50, -30, 50));
    	this.setCenter(pane);
    	
    	
    	ExamPane.setMargin(savebut, new Insets(20, 40, 50, 60));
        ExamPane.setAlignment(savebut, Pos.TOP_RIGHT);
        this.setBottom(savebut);
        
        
        //Button actions after it is clicked if something is not right a warning box will display with specific informations 
        savebut.setOnAction(e->{
        	if(isEmty(field) || this.clicked==false) {
        		alert.setAlertType(AlertType.WARNING);
				alert.setContentText("Complete all empty spaces or Add subject.");
				alert.show();
        	}
        	
        	else {
        		String s1 = f4.getText().strip() ; 
        		String s2 = f5.getText().strip() ; 
        		
        		if(s1.equals(s2) ) {
        			professor.setName(f1.getText().strip());
        			professor.setSurname(f2.getText().strip());
        			professor.setEmail(f3.getText().strip());
        			professor.setPassword(f4.getText().strip());
        			
        			this.professors.addProfessor(professor);
        			try {
            			this.saveProfessor(); 
            			Stage stage = (Stage) savebut.getScene().getWindow();
            			stage.close();
            			ProgramExecution.mainWindow();
        			} 
        			catch (FileNotFoundException e1) {
        				alert.setAlertType(AlertType.WARNING);
        				alert.setContentText("DataBase is not working properly!");
        				alert.show();
        			}
        			
        		}
        		
        		else {
        			alert.setAlertType(AlertType.WARNING);
    				alert.setContentText("Password doesn't match! Check password again. ");
    				alert.show();
        		}
        	}
        
        });
		
		
}
}
