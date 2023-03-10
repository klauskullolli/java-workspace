package ushtrime;

import java.util.*; 
public class Ex_6 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		
		String course , name  ; 
		System.out.print("Enter the Course Name: ") ;
		course= input.nextLine() ;
		Course c1 = new Course(course) ;
		
		
		System.out.println("Enter the students name for this course, 0 to quit: ") ;
		name= input.next() ;
		while (!name.equals("0")) {
			c1.addStudent(name);
			name= input.next() ;
			
		}
		
		String [] Students = c1.getStudents() ;
		System.out.println("Object Oriented ") ;
		for (int i = 0 ; i<c1.getNrOfStudent() ; i++ ) {
			System.out.print((i+1)+". " + Students[i] ) ;
			System.out.println();
		}
		
		System.out.print("Add new Student: ") ;
		name= input.next() ;
		c1.addStudent(name);
		Students = c1.getStudents() ;
		System.out.println("Updated student list of Object Oriented ") ;
		for (int i = 0 ; i<c1.getNrOfStudent() ; i++ ) {
			System.out.print((i+1)+". " + Students[i] ) ;
			System.out.println();
		}
		
		System.out.print("Enter the name students who will be dropped: ") ;
		name= input.next() ;
		System.out.println( name + "is dropped from Object Oriented ") ;
		c1.dropStudent(name);
		System.out.println( "Updated student list of Object Oriented:") ;	
		Students = c1.getStudents() ;
		for (int i = 0 ; i<c1.getNrOfStudent() ; i++ ) {
			System.out.print((i+1)+". " + Students[i] ) ;
			System.out.println();
		}
		input.close();

	}

}
