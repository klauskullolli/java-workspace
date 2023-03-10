import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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


//This is a class that create a pane arranged in that way to register other students
public class StudentRegisterPane extends BorderPane {
	
	//Used to define if a subject is selected at least  ;
	private boolean clicked  = false ;
	
	//Create a list of student class needed to save student on database
	private StudentList students=  new StudentList() ;
	
	
	StudentRegisterPane() throws IOException{
		String content = Files.readString(Paths.get("StudentsData.txt"));
		if(content.isEmpty()) {
			//this.students.toClass(content);
			this.dispaly();}
		
		else {
			this.students.toClass(content);
			this.dispaly();
		}
		
	}
	
	//Used to save student list in a given database 
	private void saveStudent() throws FileNotFoundException {
		PrintWriter output  = new PrintWriter("StudentsData.txt") ;
	    output.print(students) ;
	    output.close();
	}
	
	
	//this is a function to perform a title animation
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
	
	
	//Used to check if any of content is empty 
	private boolean  isEmty(ArrayList<TextField > field) {
		for (int i = 0 ; i < field.size() ; i++)
			if(field.get(i).getText().isEmpty() ) return true ;
		return false  ; 
	}
	
	// main function that forms the pane class according to our conditions 
	private void dispaly()  throws FileNotFoundException  {
		
		//needed to show different warning / info for specific actions
		Alert alert = new Alert(AlertType.NONE); 
		
		//Student class to save or student and to add to student list, that is updated later in student database
		Student student = new Student() ;
		GridPane pane   = new GridPane() ;
		pane.setHgap(15);
		pane.setVgap(10);
		
		
		//Here stars the visualization of contents and their arrangement
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
		
		ComboBox<String> subBox  = new ComboBox<String>() ;
		subBox.setPrefWidth(180);
		subBox.setStyle("-fx-font-size:14");
    	SubjectList subLis = new SubjectList() ;
    	subBox.getItems().addAll(subLis.getSubjectList()) ;
    	
    	Button addSub  = new Button("Add subject") ;
    	addSub.setStyle(" -fx-font-weight: bold; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ; 
		
		pane.addRow(1,t1 ,f1);
		pane.addRow(2,t2 ,f2);
		pane.addRow(3,t3 ,f3);
		pane.addRow(4,t4 ,f4);
		pane.addRow(5,t5 ,f5);
		pane.addRow(6, subBox ,addSub);
		
		
		//This is button action that make possible passing of info form text field to student class
		//Every time it is clicked the selected subject is removed 
		addSub.setOnAction(e->{
			try {
			this.clicked = true ;	 
			if(subBox.getItems().isEmpty()) {
				subBox.setStyle("-fx-font-size:12 ; -fx-font-weight: bold; -fx-background-color: RED");
				subBox.setPromptText("There is no subject left!");
			
			}
			else {
				student.addSubject(subBox.getValue().strip());
				for (int i= 0 ; i< subLis.getSubjectList().size()  ; i++ )
					if (subLis.getSubjectList().get(i) ==subBox.getValue().strip()  ) subLis.removeSubject(i);
				subBox.getItems().clear();
				subBox.getItems().addAll(subLis.getSubjectList()) ;
			}
			}
			catch(Exception ex) {
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("There is no subject selected");
				alert.show();
			}	
		}) ;
	
		//Button that save the student and update database
		Button savebut =  new Button ("Save")  ;
		savebut.setId("savebut");
		savebut.getStylesheets().add("stylesheet.css") ;
		
		Text title =  new Text("Complete Registration") ;
		title.setFill (Color.rgb(129, 171, 255));
		title.setStroke(Color.BLACK);
		title.setStyle(" -fx-font-weight: bold; -fx-font-size:38 ; -fx-font-family: \"Times New Roman\", Times, serif;");
		
		this.setTop(titleAnimation(title));
		StudentRegisterPane.setMargin( pane, new Insets(10, 50, -30, 50));
    	this.setCenter(pane);
    	
    	
    	StudentRegisterPane.setMargin(savebut, new Insets(20, 40, 50, 60));
    	StudentRegisterPane.setAlignment(savebut, Pos.TOP_RIGHT);
        this.setBottom(savebut);
        
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
        			student.setName(f1.getText().strip());
        			student.setSurname(f2.getText().strip());
        			student.setEmail(f3.getText().strip());
        			student.setPassword(f4.getText().strip());
        			
        			this.students.addStudent(student);
        			try {
            			this.saveStudent(); 
            			Stage stage = (Stage) savebut.getScene().getWindow();
            			stage.close();
            			ProgramExecution.mainWindow();
            			
        			} catch (FileNotFoundException e1) {
        				alert.setAlertType(AlertType.WARNING);
        				alert.setContentText("DataBase is not working properly!");
        				alert.show();
        				alert.setOnCloseRequest(ex->  ProgramExecution.mainWindow());
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