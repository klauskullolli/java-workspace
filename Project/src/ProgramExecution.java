import java.io.IOException;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class ProgramExecution extends Application {

  //This is starting function where program starts 
	public static void mainWindow() {
		
		//Here starts GUI presentation of window
		BorderPane pane = new BorderPane() ;  
		pane.setStyle("-fx-background-color: rgba(72, 221, 147, 0.2)");
		
		GridPane gpane = new GridPane() ; 
		gpane.setHgap(15);
		gpane.setVgap(20);
		
		
	    //Window consist of four buttons each with specific information, each of them perform ; 
		Button studLogg = new Button("Log In as a student") ; 
		studLogg.setId("mainBut");
		studLogg.getStylesheets().add("stylesheet.css") ;
		
		
		Button profeLogg = new Button("Log In as a professor") ; 
		profeLogg.setId("mainBut");
		profeLogg.getStylesheets().add("stylesheet.css") ;
		
		Button studReg = new Button("Regster as a student") ; 
		studReg.setId("mainBut");
		studReg.getStylesheets().add("stylesheet.css") ;
		
		Button profeReg = new Button("Register as a professor") ; 
		profeReg.setId("mainBut");
		profeReg.getStylesheets().add("stylesheet.css") ;
		
		gpane.addRow(0,studLogg,profeLogg);
		gpane.addRow(1,studReg,profeReg);
		
		
		Button exitButt =  new Button("Exit") ; 
		exitButt.setId("savebut");
		exitButt.getStylesheets().add("stylesheet.css") ;
		
		Label title1  = new Label("  WELCOME TO EPOKA  " ) ;
		title1.setId("label2");
		title1.getStylesheets().add("stylesheet.css") ;
		
		Label title2  = new Label("  EXAM SITE  " ) ;
		title2.setId("label2");
		title2.getStylesheets().add("stylesheet.css") ;
		
		VBox vb =  new VBox(10) ; 
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(title1 ,title2) ; 
		
		pane.setTop(vb);
		BorderPane.setMargin(vb, new Insets(20, 40, 50, 60));
		BorderPane.setAlignment(vb, Pos.CENTER);
		
		BorderPane.setMargin( gpane, new Insets(-10, 50, 80, 50));
    	pane.setCenter(gpane);
		
    	BorderPane.setMargin(exitButt, new Insets(20, 80, 20, -80));
    	BorderPane.setAlignment(exitButt ,Pos.BASELINE_RIGHT);
		pane.setBottom(exitButt);
		
		//this is a button just for closing the window 
		exitButt.setOnAction(e->{
			Stage stage = (Stage) exitButt.getScene().getWindow();
			stage.close();
		});
		
		
		
		studLogg.setOnAction(e->{
			Stage stage = (Stage) studLogg.getScene().getWindow();
			stage.close();
			try {
				//This appears the window for login as student
				ExamDisplay.studentLogIn();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}) ; 
		
		profeLogg.setOnAction(e->{
			
			Stage stage = (Stage) studLogg.getScene().getWindow();
			stage.close();
			try {
				
				//This function appears the window for login as a student
				ExamDisplay.professorLogIn();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}) ; 
		
		profeReg.setOnAction(e->{
			try {
				Stage stage = (Stage) studLogg.getScene().getWindow();
				stage.close();
				//This display the window when professor can re
				ExamDisplay.dispalyProfessorRegistration() ;
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});
		
		studReg.setOnAction(e->{
			try {
				Stage stage = (Stage) studLogg.getScene().getWindow();
				stage.close();
				
				//this display window when student can register
				ExamDisplay.dispalyStudentRegistration(); 
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});
		
		
		Stage stg1 = new Stage () ;
		 Scene scene = new Scene(pane  , 600,  400) ; 
			stg1.setScene(scene);
			stg1.setTitle("Epoka Exam Site");
			stg1.show();
			
		
		
		
	}
	
	
	@Override
	public void start(Stage stg1) throws Exception {
	
		mainWindow() ;
	
    		
	}

	public static void main(String[] args)   {
	
		
		launch(args) ;
		
		
		
		
	

}
}


