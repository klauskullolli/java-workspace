package exercise;

import java.util.* ;
public class Exercise_1 {

	public static void main(String[] args) {
	  Scanner input = new Scanner (System.in) ;
	  int a , b ;
	  
	  try {
	 
		  a= input.nextInt() ; 
		  b= input.nextInt();
		  
		  System.out.println(" The sum of numbers is: " + (a+b)) ;
		  
	  }
	  
	  catch(InputMismatchException e) {
		  System.out.print("Incorrect input. Re-enter two integers: ") ;
		 input.nextLine() ;
		  a= input.nextInt() ; 
		  b= input.nextInt();
		  System.out.println(" The sum of numbers is: " + (a+b)) ;
	  }
          input.close();
	}

}
