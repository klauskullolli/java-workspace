import java.util.ArrayList;
import java.util.Scanner;

//This a class that contain all needed informations for a question in this program
public class Question {
	//All need variables for this class
	private String question ; 
	
	//Using array list because are alot of alternatives
	private ArrayList<String> alternatives = new ArrayList <String>() ;
	private int points=0  ; 
	private String trueAnswer , answer;
	
	Question (){}
	
	Question (String question  , int points ){
		this.question = question ;
		this.points = points ;
	}
	
	
	public void setPoints(int points) {
		this.points = points ;
	}
	
	
	public int getPoints() {
		return this.points ;
	}
	
	public void setQuestion(String question) {
		this.question = question ; 
	}
	
	
	
	public  String getQuestion() {
		return this.question ;
	}
	
	
	public void addAlternative( String alternative) {
		this.alternatives.add(alternative) ;
	}
	
	public ArrayList<String> getAlternatives(){
		return this.alternatives ;
	}
	
	public int getSize() {
		return this.alternatives.size()  ;
	}
	
	public void setTrueAnswer(String answer) {
		this.trueAnswer = answer ;
	}
	
	public String getTrueAnswer() {
		 return this.trueAnswer ;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer ;
	}
	
	
	
	public String getAnswer() {
		 return this.answer ;
	}
	
	
	public boolean isTrue() {
		if(this.trueAnswer.equals(this.answer)) return true ;
		else return false ;
	}
	
	
	
	public void delAlternatives() {
		alternatives.removeAll(alternatives) ; 
	}
	
	
	
	//Use to convert to string all data of this class
	@Override
	
	public String toString() {
		String str="" , s1 ; 
		str = String.format("%s\n %d %d ", this.question, this.points , this.alternatives.size());
		for(int i=0 ; i<this.alternatives.size() ; i++) {
			s1 = String.format("%s\n",this.alternatives.get(i) );
			str =str + s1 ;
		}
		
		s1 = String.format("%s\n",this.trueAnswer);
		str =str + s1 ;
		str = str  + (";\n") ; 
		return str ; 
	} 
	
	
	//Used to covert form string to class , mostly taken from database
	public void toClass(String s) {
		Scanner sc  = new Scanner(s) ;
		this.question = sc.nextLine() ;
		this.points = sc.nextInt() ; 
		int altSize =  sc.nextInt() ; 
		for (int i =0 ; i<altSize  ; i++ ) {
			this.alternatives.add(sc.nextLine()) ;
		}
		
		this.trueAnswer = sc.nextLine() ; 
		
		sc.close();
	}
}


