
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;




public class ExamDisplay {
	
	
	
	//This a function that is needed to perform action when a professor is logged in . 

	public static void professorLogIn() throws IOException {
		
		
		Alert alert = new Alert(AlertType.NONE); 
		
		
		File file = new File("ProfessorsData.txt") ;
		
		
		
		if(file.length()==0) {
			alert.setAlertType(AlertType.WARNING);
			alert.setContentText("There is no professor register yet.");
			Optional<ButtonType> result = alert.showAndWait();
    		if(result.get() == ButtonType.OK) {
    			ProgramExecution.mainWindow();
    		}
		}
		
		else {
			String content = Files.readString(Paths.get("ProfessorsData.txt"));
			ProfessorList professors = new ProfessorList() ;
			professors.toClass(content);
		
			Stage stg1 = new Stage () ;
		
			BorderPane pane = new BorderPane() ; 
		
			GridPane login  = new GridPane() ; 
			login.setPadding(new Insets(20 , 10 , -10 ,10));
			login.setVgap(10);
			login.setHgap(10);
		
		
			Label l1 = new Label ("Email") ;
			l1.setAlignment(Pos.CENTER);
			l1.setPrefWidth(200);
			l1.setStyle(" -fx-text-fill : white ; -fx-border-color: #008B8B ; -fx-background-color:rgba(54, 0, 255, 0.8) ; -fx-font-weight: bold; -fx-font-size:24 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
		
			Label l2 = new Label ("Password") ; 
			l2.setStyle(" -fx-text-fill : white ; -fx-border-color: #008B8B ; -fx-background-color:rgba(54, 0, 255, 0.8) ; -fx-font-weight: bold; -fx-font-size:24 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
			l2.setAlignment(Pos.CENTER);
			l2.setPrefWidth(200);
		
		
			TextField f1 = new TextField() ;
			f1.setPrefWidth(250);
		
			PasswordField f2 = new PasswordField() ;
			f2.setPrefWidth(250);
		
			Button logInBut  =  new Button ("Log in")  ;  
			logInBut.setId("logInBut");
			logInBut.getStylesheets().add("stylesheet.css") ;
			
			login.addRow(1,l1 ,f1);
			login.addRow(2,l2 ,f2);
		
			Label title = new Label ("Log In Professor") ;
			title.setId("title");
			title.getStylesheets().add("stylesheet.css") ;
		
		
			pane.setTop(title);
			BorderPane.setMargin( title, new Insets(20, 50, 10, 50));
			BorderPane.setAlignment(title, Pos.CENTER);
		
			
			BorderPane.setMargin( login, new Insets(10, 50, 10, 50));
			pane.setCenter(login);
    	
    	
			BorderPane.setMargin(logInBut, new Insets(20, 40, 50, 60));
			BorderPane.setAlignment(logInBut, Pos.TOP_RIGHT);
			pane.setBottom(logInBut);
        
        
			logInBut.setOnAction(e-> {
        	
				Professor profe = new Professor();
        	
				if(f1.getText().isEmpty() || f2.getText().isEmpty()) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("Complete empty spaces");
					alert.show();
				}
        	
				else {
        		
					boolean access = false; 
					for (int i = 0 ; i<professors.getPorfessorList().size()  ;  i++ ) 
        			if(professors.getProfessor(i).getEmail().equals(f1.getText().strip()) && professors.getProfessor(i).getPassword().equals(f2.getText().strip())) {
        				System.out.print(professors.getPorfessorList().get(i) );
        				profe = professors.getPorfessorList().get(i) ;
        				access = true ;
        				break ; 
        			}
					if(access) {
						Stage stage = (Stage) logInBut.getScene().getWindow();
						stage.close();
						displayProfessorPane(profe);
        			
					}
        		
					else {
						alert.setAlertType(AlertType.WARNING);
						alert.setContentText("Check again your password and email or this account is not registered");
						alert.show();
					}
        		
				}
			});
        
	
			Scene scene = new Scene(pane  , 500,  300) ; 
				stg1.setScene(scene);
				stg1.setTitle("Professor Registration");
				stg1.show();
		
		
	
		}
}
	
	
	
	
	
	
	//This a function that is needed to perform action when a student is logged in . 	
	public static void studentLogIn() throws IOException {
		
		
		Alert alert = new Alert(AlertType.NONE); 
		
		
		File file = new File("StudentsData.txt") ;
		
		
		
		if(file.length()==0) {
			alert.setAlertType(AlertType.WARNING);
			alert.setContentText("There is no student register yet.");
			Optional<ButtonType> result = alert.showAndWait();
    		if(result.get() == ButtonType.OK) {
    			ProgramExecution.mainWindow();
    		}
		}
		
		else {
			
			String content = Files.readString(Paths.get("StudentsData.txt"));
			StudentList students = new StudentList() ;
			students.toClass(content);
		
			Stage stg1 = new Stage () ;
		
			BorderPane pane = new BorderPane() ; 
		
			GridPane login  = new GridPane() ; 
			login.setPadding(new Insets(20 , 10 , -10 ,10));
			login.setVgap(10);
			login.setHgap(10);
		
		
			Label l1 = new Label ("Email") ;
			l1.setAlignment(Pos.CENTER);
			l1.setPrefWidth(200);
			l1.setStyle(" -fx-text-fill : white ; -fx-border-color: #008B8B ; -fx-background-color:rgba(54, 0, 255, 0.8) ; -fx-font-weight: bold; -fx-font-size:24 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
		
			Label l2 = new Label ("Password") ; 
			l2.setStyle(" -fx-text-fill : white ; -fx-border-color: #008B8B ; -fx-background-color:rgba(54, 0, 255, 0.8) ; -fx-font-weight: bold; -fx-font-size:24 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
			l2.setAlignment(Pos.CENTER);
			l2.setPrefWidth(200);
		
		
			TextField f1 = new TextField() ;
			f1.setPrefWidth(250);
		
			PasswordField f2 = new PasswordField() ;
			f2.setPrefWidth(250);
		
			Button logInBut  =  new Button ("Log in")  ;  
			logInBut.setId("logInBut");
			logInBut.getStylesheets().add("stylesheet.css") ;
			
			login.addRow(1,l1 ,f1);
			login.addRow(2,l2 ,f2);
		
			Label title = new Label ("Log In Student") ;
			title.setId("title");
			title.getStylesheets().add("stylesheet.css") ;
		
		
			pane.setTop(title);
			BorderPane.setMargin( title, new Insets(20, 50, 10, 50));
			BorderPane.setAlignment(title, Pos.CENTER);
		
			
			BorderPane.setMargin( login, new Insets(10, 50, 10, 50));
			pane.setCenter(login);
    	
    	
			BorderPane.setMargin(logInBut, new Insets(20, 40, 50, 60));
			BorderPane.setAlignment(logInBut, Pos.TOP_RIGHT);
			pane.setBottom(logInBut);
        
        
			logInBut.setOnAction(e-> {
        	
				Student student = new Student();
        	
				if(f1.getText().isEmpty() || f2.getText().isEmpty()) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("Complete empty spaces");
					alert.show();
				}
        	
				else {
        		
					boolean access = false; 
					for (int i = 0 ; i< students.getStudentList().size() ;  i++ ) 
        			if(students.getStudent(i).getEmail().equals(f1.getText().strip()) && students.getStudent(i).getPassword().equals(f2.getText().strip())) {
        			
        				student = students.getStudentList().get(i) ;
        				access = true ;
        				break ; 
        			}
					if(access) {
						Stage stage = (Stage) logInBut.getScene().getWindow();
						stage.close();
						displayStudentPane(student);
						
        			
					}
        		
					else {
						alert.setAlertType(AlertType.WARNING);
						alert.setContentText("Check again your password and email or this account is not registered");
						alert.show();
					}
        		
				}
			});
        
	
			Scene scene = new Scene(pane  , 500,  300) ; 
			stg1.setScene(scene);
			stg1.setTitle("Student Log In");
				stg1.show();
		
		
	
		}
	}
	
	
	
	
	//Function that display exam pane where a professor can create one
	public static void dispalyProfessorExam(String subject) {
		
		Stage stg1 = new Stage () ;
		 Scene scene = new Scene(new ExamPane(subject)  , 800,  700) ; 
			stg1.setScene(scene);
			stg1.setTitle("Exam");
			stg1.show();
	}
	
	
	// Function that display window where Professor can register
	public static void dispalyProfessorRegistration() throws IOException {
		
		Stage stg1 = new Stage () ;
		 Scene scene = new Scene(new  ProfessorRegisterPane()  , 500,  400) ; 
			stg1.setScene(scene);
			stg1.setTitle("Professor Registration");
			stg1.show();
	}
	
	
	// Function that display window where student can register
	public static void dispalyStudentRegistration() throws IOException {
		
		Stage stg1 = new Stage () ;
		 Scene scene = new Scene(new  StudentRegisterPane()  , 500,  400) ; 
			stg1.setScene(scene);
			stg1.setTitle("Student Registrtion");
			stg1.show();
	}
	


	private static  void saveStudent(Student student) throws IOException {
		StudentList students = new StudentList() ;
		String content = Files.readString(Paths.get("StudentsData.txt"));
		students.toClass(content);
		
		for(int i = 0 ; i<students.getStudentList().size() ; i++ ) {
			if(students.getStudent(i).getName().equals(student.getName()) && students.getStudent(i).getSurname().equals(student.getSurname()))
			{   
				students.getStudentList().set(i, student) ;
				break ; 
			}
		}
		
		PrintWriter output  = new PrintWriter("StudentsData.txt") ;
	    output.print(students) ;
	    output.close();
	}
	
	
	//Stage stage = (Stage) closeButton.getScene().getWindow();
	public static void dispalyStudentExam( Student student , ExamPoints points) throws IOException  {
		
				
		String path = String.format("%s.txt", points.getSubject()) ;
		String content = Files.readString(Paths.get(path));
		
		if(content.isEmpty()) {
			Alert alert = new Alert(AlertType.NONE);
			alert.setAlertType(AlertType.WARNING);
			alert.setContentText("Exam is not prepared yet.");
			alert.show();
			alert.setOnCloseRequest(e->ProgramExecution.mainWindow());
		}

		else {
			ExamCheckPane pane  = new ExamCheckPane(points , student) ;
		
			Scene scene = new Scene(pane  , 800,  700) ; 
		
			Stage stg1 = new Stage () ;
			stg1.setScene(scene);
			stg1.setTitle("Exam Complition");
			stg1.show();
			
			stg1.setOnCloseRequest(e->{
				try {
					saveStudent(student) ;
					ProgramExecution.mainWindow() ;
					}	
				catch (IOException e1) {
						e1.printStackTrace();
					}
				});
			}
		
	
			
		
	}
	
	
	
	// Function that display professor window with data form specific professor
	
	public static void displayProfessorPane(Professor professor) {
		Stage stg1 = new Stage () ;
		 Scene scene = new Scene(new ProfessorPane(professor)  , 630,  500) ; 
			stg1.setScene(scene);
			stg1.setTitle("Professor Window");
			stg1.show();
	}
	
	
	// Function that display student window with data form specific student
	
	public static void displayStudentPane(Student student) {
		ScrollPane sp = new ScrollPane() ; 
		StudentPane pane = new StudentPane(student) ;
		sp.setContent(pane);
		Stage stg1 = new Stage () ;
		 Scene scene = new Scene( sp , 630,  500) ; 
			stg1.setScene(scene);
			stg1.setTitle("Student Window");
			stg1.show();
			
			stg1.setOnCloseRequest(e->{
				try {
					saveStudent(student) ;
					ProgramExecution.mainWindow() ;
					}	
				catch (IOException e1) {
						e1.printStackTrace();
					}
				});
	}
	
}   


	
	
	
