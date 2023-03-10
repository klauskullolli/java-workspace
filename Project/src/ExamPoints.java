
//Class needed for students object to hold info for specific subject and their grades
public class  ExamPoints {
	
	
	private String subject ; 
	private int points ;
	
	//Needed to show that for this subject a student is graded or no
	private boolean completed = false ; 
	
	
	ExamPoints(){
	}
	
	ExamPoints(String subject ){
		this.subject = subject ; 
	}
	
	ExamPoints(String subject , int points ){
		this.subject = subject ; 
		this.points = points  ; 
		completed = true ;
	}
	
	public void setSubject(String subject) {
		this.subject= subject ;
	}
	
	public String getSubject() {
		return this.subject ;
	}
	
	
	public void setPoints(int points) {
		this.points = points ; 
		completed = true ;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	//Method that show if this subject is graded or not 
	public boolean isCompleted() {
		return  this.completed ; 
	}
	
	//convert all necessary class data to string needed later for database
	public String toString() {
		String str = null ;
		str = this.subject + "-" ; 
		if(this.completed) 
			str =str  + String.format("%b-%d\n", this.completed , this.points) ;
		else str =str  + String.format("%b\n", this.completed) ;
		return str  ; 
	}
}
