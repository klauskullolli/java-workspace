import java.util.ArrayList;


// This is a class that contain a list of subject
public class SubjectList {
	
	//Subject list that is the main  point o of this class
	private ArrayList<String> subjects =  new ArrayList<String>()  ;
	
	//default list of subject
	// if needed you can add other subjects
	SubjectList(){
		this.subjects.add("Computer Organisation") ;
		this.subjects.add("Calculus 1") ;
		this.subjects.add("C Programming") ; 
		this.subjects.add("Object Oriented") ;
	}
	
	//method for adding subject
	public void addSubject(String subject) {
		this.subjects.add(subject) ;
	}
	
	//method for removing subjects using index
	public void removeSubject(int index) {
		this.subjects.remove(index) ;
	}
	
	//method used to remove using name 
	public void removeSubject(String subject) {
		this.subjects.remove(this.subjects.indexOf(subject)) ;
	}
	
	// this retun a array list of subjects
	public ArrayList<String> getSubjectList(){
		return this.subjects ;
	}
}
