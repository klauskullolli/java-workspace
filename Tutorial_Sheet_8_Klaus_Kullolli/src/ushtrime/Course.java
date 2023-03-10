package ushtrime;

public class Course {
   private String courseName ;
   private int nrOfStudent = 0 ; 
   private String[] students = new String[nrOfStudent]  ;
   
   Course (String courseName ) {
	   this.courseName=courseName ;
   }
   
   public String getCourseName() {
	   return this.courseName ;
   }
   
   public String[] getStudents() {
	   return this.students ;
   }
   
   public int  getNrOfStudent(){
	   return nrOfStudent ;

   }
   
   public void addStudent(String student) {
	   nrOfStudent++ ;
	   String[] temp= new String [nrOfStudent] ;
	   for (int i = 0 ; i<nrOfStudent-1 ; i++ ) temp[i]=this.students[i] ;
	   temp[nrOfStudent-1] =student ;
	   this.students=temp ;
		   
	  
   }
   
   public void dropStudent(String student) {
	   nrOfStudent-- ;
	   String[] temp= new String [nrOfStudent] ;
	   int j = 0 ;
	   for (int i = 0 ; i<nrOfStudent+1 ; i++ ) {
		   if(this.students[i].equals(student)) continue ;
		   else {
		   temp[j]=this.students[i] ;
		   j++ ; }
		   }
	   this.students=temp ;
		   
	  
   }
   
   public void clear() {
	   nrOfStudent = 0 ;
	   String[] st = new String[nrOfStudent]  ;
	   this.students= st ;
   }
}
