package ushtrime;
import java.util.*;
public class Ex_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		int nr  , quiz  , mid , exam ; 
		String name  , surname  ;
		Student s1 = new Student() ;
		
		Student s2 = new Student() ;
		
		System.out.print("Enter the student Id ");
		nr  = input.nextInt() ; 
		s1.setId(nr);
		System.out.println("Student id is:  " + s1.getId());
		
		System.out.print("Name:  ");
		name = input.next() ;
		
		System.out.print("Surname: ");
		surname = input.next()  ; 
		
		System.out.print("Quiz grade ");
		quiz  = input.nextInt() ;
		
		System.out.print("Midtearm grade ");
		mid  = input.nextInt() ;
		
		System.out.print("Final exam grade ");
		exam  = input.nextInt() ;
		
		s1 =new Student(nr  ,name , surname , quiz , mid , exam) ;
		System.out.println("The average is  " + s1.getAverage());
		System.out.println("Total students are  " + s1.nrOfstudents());
		
	}

}
