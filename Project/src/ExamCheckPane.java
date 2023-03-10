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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;


//Class that inherit attributes of a BorderPane  
//Used to show completion of exam by student add checking at same time

public class ExamCheckPane extends BorderPane {
    
	//Used to pass all attributes of subject database into exam object
    private Exam exam  = new Exam(); 
    
    private Student student = new Student() ; 
    private ExamPoints points  ;
    private VBox checkQues = new VBox(25) ;
   
    private VBox showQues = new VBox(25) ;
    
    // list with number of questions not confirmed
    private ArrayList<Integer> unConfQues = new ArrayList<Integer>();
    
 
    
    
    ExamCheckPane(ExamPoints points , Student student  ) throws IOException {
    	this.points = points ;
    	this.student= student ; 
    	Alert alert = new Alert(AlertType.NONE); 
    	try {
    		
    		//First this.exam the attributes from specified database
    		exam.setSubject(points.getSubject());
    		String path = String.format("%s.txt", points.getSubject()) ;
    		String content = Files.readString(Paths.get(path));
    		exam.toClass(content);
    		display() ;
    	
    		
    		}
    	
    	//if exam is empty a warning window appear 
    	catch (Exception e) {
    		alert.setAlertType(AlertType.WARNING);
			alert.setContentText("Exam is not prepared yet.");
			alert.show();
    	}
    }
    
    //return point of exam after it is checked
    public void savePoints(int points) throws FileNotFoundException {
    	PrintWriter output  = new PrintWriter("points.txt") ;
	    output.print(points) ;
	    output.close();
    }
    
    
    //Title animation method 
    private static Pane titleAnimation(  Text text) {
		StackPane pane = new StackPane() ;
        String str = text.getText() ; 
        pane.getChildren().add(text) ;
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.3),
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
    
    
    //method that make selection disable all check box if one is selected
    private void selectionDisable(ArrayList<CheckBox> listBox ,CheckBox box ) {
    	for (CheckBox e :  listBox) {
    		if(e.getText()== box.getText()) {
    			continue ; 
    		}
    		else e.setDisable(true);
    	}
    	
    }
    
  //method that make selection enable all check box
    private void selectionEnable(ArrayList<CheckBox> listBox ,CheckBox box ) {
    	for (CheckBox e :  listBox) {
    		if(e.getText()== box.getText()) {
    			continue ; 
    		}
    		else e.setDisable(false);
    	}
    	
    }
    
   //method that show if a check box in a array of check boxes is selected  
   private boolean isOneSelected (ArrayList<CheckBox> listBox) {
	   for (CheckBox e :  listBox) {
   			if (e.isSelected()) return true ;
	   }
	   
	   return false ;
   }
    
   
   //Function that check and save content in this.checkques pane and check question
   
   private void   questionCheck(int nr) {
	   Question question =  exam.getQuestions().get(nr-1) ;
	   
	   VBox vb= new VBox(10) ;
	   Label l1 =  new Label() ; 
	   l1.setText(String.format("Question %d", nr ));
   	   l1.setStyle(("-fx-text-fill : red ; -fx-font-weight: bold; -fx-font-size:32 ; -fx-font-family: \"Times New Roman\", Times, serif;"));
	  
   	   Label l2  = new Label(String.format("%s?",question.getQuestion())) ;
   	   l2.setStyle(("-fx-text-fill : blue ; -fx-font-weight: bold; -fx-font-size:22 ; -fx-font-family: \"Times New Roman\", Times, serif;"));
   	   
   	   Text l3 =  new Text (String.format("%d points" , question.getPoints())) ;
   	   
   	   ArrayList<String> alternatives  = new ArrayList<String>() ;
   	   ArrayList<CheckBox> listBox = new ArrayList<CheckBox>() ;
   	   alternatives  = question.getAlternatives() ; 
   	   
   	   if(question.isTrue()) {
   		   l3.setStyle("-fx-text-fill : Black ;  -fx-font-style: italic; -fx-font-size:18 ;-fx-underline: true; -fx-strikethrough: false ; -fx-font-family: \"Times New Roman\", Times, serif;");
   		   for (int  i= 0  ; i< alternatives.size() ; i++ ) {
   			    CheckBox checkBox = new CheckBox(alternatives.get(i));
   			    if(checkBox.getText().strip().equals(question.getTrueAnswer())){
   			    	checkBox.setSelected(true);
   			    	checkBox.setStyle("-fx-text-fill : Black ;  -fx-font-style: italic; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif; -fx-background-color: rgba(0, 255, 0, 0.5);")  ;
   			    	}
   			    else 
   			    	checkBox.setStyle("-fx-text-fill : Black ;  -fx-font-style: italic; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
   			    listBox.add(checkBox) ;
   		   }
   		   
   		   }
   	   
   	   else {
   		l3.setStyle("-fx-text-fill : Black ;  -fx-font-style: italic; -fx-font-size:18 ;-fx-underline: true; -fx-strikethrough: true ; -fx-font-family: \"Times New Roman\", Times, serif;");
   		for (int  i= 0  ; i< alternatives.size() ; i++ ) {
		    CheckBox checkBox = new CheckBox(alternatives.get(i));
		    if(checkBox.getText().strip().equals(question.getTrueAnswer())){
		    	checkBox.setSelected(true);
		    	checkBox.setStyle("-fx-text-fill : Black ;  -fx-font-style: italic; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif; -fx-background-color: rgba(0, 255, 0, 0.5);")  ;
		    	}
		    else if(checkBox.getText().strip().equals(question.getAnswer())){
		    	checkBox.setSelected(true);
		    	checkBox.setStyle("-fx-text-fill : Black ;  -fx-font-style: italic; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif; -fx-background-color: rgba(255, 0, 0, 0.5); -fx-shape: \"M2,0L5,4L8,0L10,0L10,2L6,5L10,8L10,10L8,10L5,6L2,10L0,10L0,8L4,5L0,2L0,0Z\";");
		    }
		    else 
		    	checkBox.setStyle("-fx-text-fill : Black ;  -fx-font-style: italic; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
		    listBox.add(checkBox) ;
   		}
   	   }
   	   
   	   HBox hb = new HBox(400) ; 
   	   hb.getChildren().addAll(l1 , l3) ;
   	   
   	   VBox vb1= new VBox(10) ;
   	   vb1.getChildren().addAll(listBox ) ;
   	   
   	   vb.getChildren().addAll( hb,l2 ,vb1) ;
	
   	   this.checkQues.getChildren().add(vb) ;
  
   }
    
    
   //function only show question with alternatives in a arrangement
    private void  questionDispaly(int nr) {
    	
    	unConfQues.add(nr) ;
    	
    	VBox vb= new VBox(10) ;
    	
    	Label l1 = new Label() ; 
    	l1.setText(String.format("Question %d", nr )); 
    	l1.setStyle(("-fx-text-fill : red ; -fx-font-weight: bold; -fx-font-size:32 ; -fx-font-family: \"Times New Roman\", Times, serif;"));
    	
    	Alert alert = new Alert(AlertType.NONE); 
    	
    	Question question =  exam.getQuestions().get(nr-1) ;
    	
    	Label l2  = new Label(String.format("%s?",question.getQuestion())) ;
    	l2.setStyle(("-fx-text-fill : blue ; -fx-font-weight: bold; -fx-font-size:22 ; -fx-font-family: \"Times New Roman\", Times, serif;"));
    	
    	Text l3 =  new Text (String.format("%d points" , question.getPoints())) ;
    	l3.setStyle("-fx-text-fill : Black ;  -fx-font-style: italic; -fx-font-size:18 ;-fx-underline:true  ;-fx-font-family: \"Times New Roman\", Times, serif;")  ;
    	
    	HBox hb = new HBox(400) ; 
    	hb.getChildren().addAll(l1 , l3) ;
    	
    	VBox vb1= new VBox(10) ;
    	
    	ArrayList<String> alternatives  = new ArrayList<String>() ;
    	ArrayList<CheckBox> listBox = new ArrayList<CheckBox>() ;
    	alternatives  = question.getAlternatives() ; 
    	for (int  i= 0  ; i< alternatives.size() ; i++ ) {
    		
    		CheckBox checkBox = new CheckBox(alternatives.get(i));
    		checkBox.setStyle("-fx-text-fill : Black ;  -fx-font-style: italic; -fx-font-size:20 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
    		checkBox.setOnAction(e->{
    			if(checkBox.isSelected()) {
    				selectionDisable(listBox , checkBox) ;
    				if(!unConfQues.contains(nr)) unConfQues.add(nr) ;
    			}
    			
    			else selectionEnable(listBox , checkBox) ;
    		});
    		
    		listBox.add(checkBox) ;
    		
    	}
    	
    	HBox hb1 = new HBox() ; 
        
    	Button cofButt  = new Button("Confirm") ;
    	cofButt.setStyle("-fx-text-fill : Red ;-fx-font-weight: bold; -fx-background-radius: 15px; -fx-font-style: italic; -fx-font-size:18 ; -fx-font-family: \"Times New Roman\", Times, serif; -fx-background-color:	rgb(161, 144, 190)")  ;
    	
    	hb1.getChildren().add(cofButt) ;
    	
    	vb1.getChildren().addAll(listBox ) ;
    	
    	cofButt.setOnAction(e->{
    		try {
    			this.unConfQues.remove(this.unConfQues.indexOf(nr)) ;
    		}
    		catch (Exception ex) {
    
    		}
    		
    		if(isOneSelected(listBox)) {
    			CheckBox answer = new CheckBox() ;
    			for (CheckBox check : listBox ) {
    				if (check.isSelected()) answer = check ;
    			} 
    		question.setAnswer(answer.getText().strip());
    		
    		}
    		else {
    			alert.setAlertType(AlertType.WARNING);
				alert.setContentText("Select one alterative first.");
				alert.show();
    		}
    		
    	});
    	
    	vb.getChildren().addAll( hb,l2 ,vb1, hb1) ;
    	
    	this.showQues.getChildren().add(vb) ;
    	
    	
    	
    }
    
    
   //Main function where a exam paper is completed and checked is same time 
    
    private void display() {
    	
    	Alert alert = new Alert(AlertType.NONE); 
    	
    	HBox hb = new HBox(10) ;
    	hb.setAlignment(Pos.CENTER);
    	Label l1 = new Label("TIME : ") ;
    	l1.setStyle(" -fx-font-weight: bold; -fx-font-size:30 ; -fx-font-family: \"Times New Roman\", Times, serif;");
    	hb.getChildren().add(l1) ;
    	hb.getChildren().add(new Timer(exam.getTime() , this.points, this.student.getId() )  );
    	
    	
    	for (int i = 1 ; i<=exam.getNrOfQuestions() ; i++) {
    		questionDispaly(i) ;
    	}
    	
    	Text text  = new Text("Good luck!") ;
		text.setFill (Color.rgb(129, 171, 255));
		text.setStroke(Color.BLACK);
		text.setStyle(" -fx-font-weight: bold; -fx-font-size:38 ; -fx-font-family: \"Times New Roman\", Times, serif;");
    	
		VBox vb = new VBox(10) ;
		
		
		ScrollPane sp = new ScrollPane() ; 
		sp.setStyle("-fx-background-color:transparent;");
		sp.setContent(this.showQues);
		
		vb.getChildren().addAll(hb , sp) ;
		
		Button subButt = new Button("Submit") ;
		subButt.setStyle("-fx-text-fill : white;-fx-font-weight: bold; -fx-background-radius: 15px; -fx-font-style: italic; -fx-font-size:24 ; -fx-font-family: \"Times New Roman\", Times, serif; -fx-background-color:	rgb(255, 71, 79)")  ;
    	
		
		this.setTop(titleAnimation(text));
		ExamPane.setMargin( vb, new Insets(50, 50, 50, 70));
    	this.setCenter(vb);
    	
    	
    	ExamPane.setMargin(subButt, new Insets(20, 70, 20, 60));
        ExamPane.setAlignment(subButt, Pos.BOTTOM_RIGHT);
        this.setBottom(subButt);
        
        subButt.setOnAction(e->{
        	
        	if(this.unConfQues.isEmpty()) {
        		alert.setAlertType(AlertType.CONFIRMATION);
        		alert.setContentText("Do you want to submit the exam?");
        		Optional<ButtonType> result = alert.showAndWait();
    		
        		if(result.get() == ButtonType.OK) {
        			for (int i = 1 ; i<=exam.getNrOfQuestions() ; i++) {
        				questionCheck(i) ;
        				}
        			vb.getChildren().clear();
        			sp.setContent(this.checkQues);
        			vb.getChildren().add(sp) ;
        			this.points.setPoints(exam.getPoints()); 
        			Text text1  = new Text(String.format("You took %d points" ,this.points.getPoints())) ;
        			
        			
        			text1.setFill (Color.rgb(255, 71, 75));
        			text1.setStroke(Color.BLACK);
        			text1.setStyle(" -fx-font-weight: bold; -fx-font-size:34 ; -fx-font-family: \"Times New Roman\", Times, serif;");
        			Pane pane = titleAnimation(text1) ;
        			
        			ExamPane.setMargin(pane, new Insets(20, 70, 20, 60));
        			this.setBottom(pane);
        			
        			
        		}}
        	
        	else {
        		
        		alert.setAlertType(AlertType.WARNING);
        		alert.setContentText(String.format("Confirm Question %d first or do not let it empty!", this.unConfQues.get(0)));
        		alert.show();
        	}
        	
        	
        });
        
    }
    
    //function that returns points of exam
    public int getPoints() {
    	return this.points.getPoints() ;
    }
    
    
}
