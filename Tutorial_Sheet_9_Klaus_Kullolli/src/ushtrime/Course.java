package ushtrime;

import java.util.*; 
public class Course {
   private String courseName ;
   private int nrOfStudent = 0 ; 
   private ArrayList<String> students = new ArrayList<>()  ;
   
   Course (String courseName ) {
	   this.courseName=courseName ;
   }
   
   public String getCourseName() {
	   return this.courseName ;
   }
   
   public ArrayList<String>getStudents() {
	   return this.students ;
   }
   
   public int  getNrOfStudent(){
	   return nrOfStudent ;

   }
   
   public void addStudent(String student) {
	   nrOfStudent++ ;
	   students.add(student);
		   
	  
   }
   
   public void dropStudent(String student) {
	   
	   if(students.contains(student)) {students.remove(student) ;
	   nrOfStudent-- ; }
	  
   }
   
   public void clear() {
	   nrOfStudent = 0 ;
	   students.clear();
   }
}
