import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class QuestionPane extends GridPane {
	
	//Needed to save action i a question class
	private Question  question = new Question() ;
	
	//Need to put nr of question according to order  ; 
	private  int quesNr ; 
	
	
	//To see if question is saved ; 
	private boolean  saved=false  ; 

	
	
	//Constructor
	public QuestionPane(int nr) {
		this.quesNr = nr ;
		this.addQuestion();
		}
	
	//Method to see if is saved or not
	public boolean isSaved() {
		return this.saved ; 
	}
	
	
	
	//Return  saved question class
	public Question getQuestion() {
		return this.question;
	}
	
	
	public void setQuesNr(int nr) {
		this.quesNr =nr ; 
	}
	
	
	//Return question number in exam order
	public int getQuesNr() {
		return this.quesNr ; 
	}
	
	
	//Method needed to add alternatives in pane
	private  void  addAlternative( VBox vb , ArrayList<TextField> tfield  ) {
		
			TextField t1 = new TextField();
			t1.setPrefWidth(450);
			tfield.add(t1) ;
			HBox hb = new HBox() ;
			Label  l1=  new Label(String.format("%d) ", tfield.size())) ;
			l1.setStyle("-fx-font-weight: bold; -fx-font-size:18 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
			hb.getChildren().addAll(l1 , t1) ; 
			vb.getChildren().add(hb) ;
	
		
	}
	
	//Method to check if alternatives are completed or not 
	private boolean emtyAlternative ( ArrayList<TextField> tfield) {
		for(int i = 0; i< tfield.size() ; i++) {
			if(tfield.get(i).getText().isEmpty()) return true ;
		}
		return false  ; 	
	}
	
	
	//Method needed to remove alternatives in pane
	private  void  removeAlternative( VBox vb , ArrayList<TextField> tfield  ) {
		
		int i  = tfield.size() ; 
		int j =  vb.getChildren().size() ;
		
		tfield.remove(i-1) ; 
		vb.getChildren().remove(j-1) ;
		
	}
	
	
	//This function display  question
	private void addQuestion() {
		
		//Used to show alert if is needed 
		Alert alert = new Alert(AlertType.NONE); 
		
		//pane to put content 
		GridPane pane = new GridPane()  ; 
		pane.setAlignment(Pos.CENTER);
		
		//Text field arraylist to put alternatives. 
		ArrayList<TextField> tfield = new ArrayList<TextField> () ; 
		
		
		//Needed for Arrangement of question pane 
		HBox hb = new HBox(10) ; 
		VBox vb = new VBox(10);
		hb.setAlignment(Pos.CENTER);
		vb.setAlignment(Pos.CENTER);
		vb.setPrefWidth(500);
		
		
		
		Label l1 = new Label(String.format("Question nr %d" , this.quesNr) );
		l1.setStyle("-fx-text-fill : red ; -fx-font-weight: bold; -fx-font-size:32 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
	
		Button saveQ =  new Button ("Save question") ;
		saveQ.setStyle("-fx-text-fill : red ; -fx-font-weight: bold ; -fx-font-size:14") ;
		
		HBox h = new HBox(240) ; 
		
		h.getChildren().addAll(l1, saveQ) ;
		
		
		TextArea ques = new TextArea();
		ques.setPrefWidth(400);
		ques.setPrefHeight(50);
		ques.setTooltip(new Tooltip("Type a question you want to create and press enter to save it."));
		
		Button addB =  new Button ("Add Alternatives") ;
		addB.setStyle("-fx-text-fill : blue ; -fx-font-style: italic; -fx-font-size:12")  ;
		addB.setOnAction(e->addAlternative( vb ,tfield ));
		
		Button remB = new Button ("Remove Alternatives") ;
		remB.setStyle("-fx-text-fill : blue ; -fx-font-style: italic; -fx-font-size:12")  ;
		remB.setOnAction(e->{
			try {
				removeAlternative(vb , tfield) ;
			}
			
			catch(Exception ex){
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("There is no alternative to remove.");
				alert.show();
			}
		});
		
		VBox vb1 =  new VBox(5) ;
		vb1.setAlignment(Pos.BOTTOM_RIGHT);
		vb1.getChildren().addAll(addB , remB);
		
		hb.getChildren().addAll(ques, vb1) ; 
		
		
		ScrollPane sp = new ScrollPane(vb) ;
		sp.setStyle("-fx-background: rgba(76, 175, 80, 0.2)");
		sp.setMaxHeight(100);
		
		Label l2 = new Label("True Answer");
		l2.setStyle("-fx-text-fill : blue ; -fx-font-weight: bold;   -fx-font-size:26 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
		
		HBox hb1 = new HBox(270) ; 
	
		TextField ques1 = new TextField() ;
		ques1.setPrefWidth(120);
		ques1.setTooltip(new Tooltip("Type true alternative number"));
	
		hb1.getChildren().addAll(l2, ques1) ;
		
		
		Label l3 = new Label("Set points");
		l3.setStyle("-fx-text-fill : blue ; -fx-font-weight: bold;   -fx-font-size:26 ; -fx-font-family: \"Times New Roman\", Times, serif;")  ;
		HBox hb2 = new HBox(347) ; 
		
		TextField ques2 = new TextField() ;
		ques2.setPrefWidth(80);
		ques2.setTooltip(new Tooltip("Type number of points"));
		
		hb2.getChildren().addAll(l3, ques2) ; 
	     
		//Button to save question with some useful methods inside
		//Alert will be shown if boxes are not completed properly
		saveQ.setOnAction(e->{
			if(this.emtyAlternative(tfield)|| tfield.isEmpty()) { 
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("Complete alternatives.");
				alert.show();
			}
			else {	
				try {
					question.setQuestion(ques.getText().strip());
				
					question.delAlternatives();;
				
					for(int i = 0  ; i<tfield.size() ; i++ ) {
						question.addAlternative(tfield.get(i).getText());
					}	
				
					int trAl =  Integer.parseInt(ques1.getText()) ;
					question.setTrueAnswer(question.getAlternatives().get(trAl-1));
					try {
						int trAl1 =  Integer.parseInt(ques2.getText()) ;
						question.setPoints(trAl1);
						this.saved=true;
						}
			
					catch (Exception ex ) {
						alert.setAlertType(AlertType.WARNING);
						alert.setContentText("Wrong Input! Type an (integer) number.");
						alert.show();
					}	
				}
			
				catch (Exception ex ) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("Wrong Input! Type one of alternatives number (integer).");
					alert.show();
					}
			
			
			}}) ;
		
		//Organization of contents
	    this.setVgap(10);
	    this.addRow(0,h);
        this.addRow(1,hb); 
        this.addRow(2, sp);
        this.addRow(3, hb1);
        this.addRow(4, hb2);
        
	}
	
}
