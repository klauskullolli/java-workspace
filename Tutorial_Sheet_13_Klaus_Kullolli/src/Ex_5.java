
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex_5 extends Application {
    
	
	
	public static void  ADD(TextField f1 , TextField f2 , TextField f3) {
		try {
	    	double a  =Double.parseDouble( f1.getText());   
	    	double b  =Double.parseDouble( f2.getText());
	    	String s= String.format("%f" , (a+b)) ;
	    	f3.setText(s);}
	    	catch(Exception ex)  {
	    		f3.setText("Error occured!") ;
	    	}
	}
	
	public static void  SUB(TextField f1 , TextField f2 , TextField f3) {
		try {
	    	double a  =Double.parseDouble( f1.getText());   
	    	double b  =Double.parseDouble( f2.getText());
	    	String s= String.format("%f" , (a-b)) ;
	    	f3.setText(s);}
	    	catch(Exception ex)  {
	    		f3.setText("Error occured!") ;
	    	}
	}
	
	
	public static void  MUL(TextField f1 , TextField f2 , TextField f3) {
		try {
	    	double a  =Double.parseDouble( f1.getText());   
	    	double b  =Double.parseDouble( f2.getText());
	    	String s= String.format("%f" , (a*b)) ;
	    	f3.setText(s);}
	    	catch(Exception ex)  {
	    		f3.setText("Error occured!") ;
	    	}
	}
	
	public static void  DIV(TextField f1 , TextField f2 , TextField f3) {
		try {
	    	double a  = Double.parseDouble( f1.getText());   
	    	double b  = Double.parseDouble( f2.getText());
	    	double c = a / b ;
	    	String s= String.format("%f" , c) ;
	    	//System.out.println(a +" " + b+ " "+ c);
	    	f3.setText(s);}
	    	catch(Exception ex)  {
	    		f3.setText("Error occured!") ;
	    	}
	}
	
	
	@Override
	public void start(Stage stg1) throws Exception {
		
		
		GridPane pan = new GridPane();
		pan.setAlignment(Pos.CENTER);
		pan.setVgap(5);
		HBox hBox = new HBox(15);
		hBox.setPadding(new Insets(15,15,15,15));
		TextField f1 = new TextField() ;
		TextField f2 = new TextField() ;
		TextField f3 = new TextField() ;
	    hBox.getChildren().addAll(new Text("Number 1") , f1,new Text("Number 2") , f2,new Text("Result") , f3) ;
	    
	    
		
		
		HBox hBox1 = new HBox(15);
		hBox1.setPadding(new Insets(15,15,15,15));
		Button AddB =  new Button("Add") ;
		Button SubB =  new Button("Subtract") ;
		Button MulB =  new Button("Muliply") ;
		Button DivB =  new Button("Divide") ;
	    hBox1.getChildren().addAll(AddB ,SubB, MulB , DivB) ;
	    
	    AddB.setOnAction(e->{
	    	ADD(f1 ,f2, f3) ;
	    });
	    
	    SubB.setOnAction(e->{
	    	SUB(f1 ,f2, f3) ;
	    });
	    
	    MulB.setOnAction(e->{
	    	MUL(f1 ,f2, f3) ;
	    });
	    
	    DivB.setOnAction(e->{
	    	DIV(f1 ,f2, f3) ;
	    });
	    
	    
		hBox1.setAlignment(Pos.CENTER);
	    pan.add(hBox,0, 0);
	    pan.add(hBox1,0, 1);
	    Scene scene  = new Scene(pan ) ;
		stg1.setScene(scene);
		stg1.setTitle("Exercise_5");
        stg1.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
