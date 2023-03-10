package ushtrime;

public class Student {
    
	private int id  ;
	private String name , surname  ;
	private int quiz , mid ,  exam ;
	static int nr  ; 
	
	// constructor 
	public Student() {	
		nr++ ; 
	}
	
	//constructor with parameters 
	public Student( int id  , String name , String   surname , int quiz , int mid , int exam ) {	
		this.id = id ;
		this.name = name ; 
		this.surname = surname  ;
		this.quiz = quiz ; 
		this.mid = mid ;
		this.exam = exam ; 
	}
	
	// return id 
	public int getId() {
		return this.id ;
	}
	
	public void setId(int id) {
        this.id = id ;
	}
	// return name  
	public String getName() {
		return this.name ;
	}
	// return surname 
	public String getSurname() {
		return this.surname ;
	}
	
	public int getQuiz() {
		return this.quiz ;
	}
	
	public int getMid() {
		return this.mid ;
	}
	
	public int getExam() {
		return this.exam ;
	}
	
	// return nr of students
    public static int nrOfstudents() {
    	return nr ;
    }
    
    // return average grade
    public double getAverage() {
    	return 0.1 * quiz + 0.4 * mid + 0.5*exam ; 
    }
}
