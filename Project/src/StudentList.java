import java.util.ArrayList;
import java.util.Scanner;


//Class needed save student in a student list
public class StudentList {
	//this the main attribute student list created using array list
	private ArrayList<Student> students  = new ArrayList<Student>() ; 
	
	
	//Method used to add student
	public void addStudent(Student student) {
		student.setId(this.students.size() + 1 );
		this.students.add(student) ;
	}
	
	//Method used to remove student for a given index
	public void removeStudent(int id) {
		for (int i=0 ; i<this.students.size() ; i++ ) {
			if (id == this.students.get(i).getId()) this.students.remove(i) ; 
		}
		
	}
	
	//this return the list that contains student 
	public ArrayList<Student> getStudentList() {
		return this.students ;
	}
	
	//this return the student for a given index
	public Student getStudent(int index) {
		return this.students.get(index) ;
	}
	
	
	//this an override method used to convert the list in class needed later for printing data in database
	@Override
	  public String  toString() {
		  String str=null ;
		  str = String.format("%d\n", this.students.size()) ; 
		  for(int i = 0 ; i<this.students.size() ; i++) {
			  str  = str + String.format("%s", this.students.get(i)) ;
		  }
		  return str ;
	  }
	
	  // this is a method used to take a string and convert to class element and properties
	//Used mostly to take direct string from database and convert to class
	  public void toClass(String str) {
			Scanner input = new Scanner (str) ; 
			int size  = input.nextInt() ; 
			Student student ;
			str = str.substring(2, str.length()) ;
			String [] list = str.split(";\n") ;
			for (int i = 0   ; i<size  ; i++) {
				student =  new Student() ;
				student.toClass(list[i]);
				this.addStudent(student);
			}
			
			input.close();
		}
	  
}
