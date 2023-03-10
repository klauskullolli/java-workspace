import java.util.ArrayList;
import java.util.Scanner;

//This is the class that contains all necessary information needed for an exam 
public class Exam {
	
	private String subject ; 
	private int points  ;
	private int time ;
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	//Constructor 
	Exam(){}
	
	//Constructor 
	Exam(String subject , int time){
		this.subject = subject ;
		this.time = time ;
	}
	
	public void setTime(int time ) {
		this.time= time ;
	}
	
	public int getTime() {
		return this.time ;
	}
	
	
	public void setSubject(String subject) {
		this.subject= subject ; 
	}
	
	public String getSubject () {
		return this.subject ; 
	}
	
	public void addQuestion( Question question) {
		this.questions.add(question)  ; 
	}
	
	public void removeQuestion( int index) {
		this.questions.remove(index) ; 
	}
	
	public ArrayList<Question> getQuestions(){
		return this.questions ;
	}
	
	
	public int getNrOfQuestions() {
		return this.questions.size() ;
	}
	
	public int getPoints() {
		for (int i = 0 ; i< this.questions.size() ; i++) {
	   		if (this.questions.get(i).isTrue()) points = points + this.questions.get(i).getPoints();
	 	}
		return points ;
	}
	
	
	//This is override method used mostly for database to simplify printing of data in database
	@Override
	public String toString() {
		String str = "" , s1  ;
		str = String.format("%d\n%d\n" , this.questions.size() , this.time )  ;
		for (int i = 0  ; i< this.questions.size() ; i++) {
			s1=this.questions.get(i).toString() ; 
			str =str + s1 ;
		}
		return str  ; 
	}
	
	//This is a method needed to take directly a string and covert to class parameter 
	//Used to simplify fetching data from database
	public void toClass(String str) {
		Scanner sc = new Scanner (str) ; 
		int size  = sc.nextInt() ; 
		this.time = sc.nextInt() ;
		Question question ;
		str = str.substring(4, str.length()) ;
		String [] list = str.split(";\n") ;
		for (int i = 0   ; i<size  ; i++) {
			question =  new Question() ;
			question.toClass(list[i]);
			this.addQuestion(question);
		}
		
		sc.close();
	}
	
}
