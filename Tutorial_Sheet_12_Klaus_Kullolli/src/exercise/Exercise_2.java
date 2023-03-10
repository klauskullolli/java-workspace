package exercise;

import java.util.*;

public class Exercise_2 {

	public static void main(String[] args) {
		 Scanner input = new Scanner (System.in) ;
         int arr[] = new int [100] ,  c;
         boolean con = true ;
         Random random = new Random() ;
		 for (int i=0 ; i<100 ; i++) {
			 arr[i] = random.nextInt() ;
		 }
		 try {
			 System.out.print("Enter an integer number please:") ;
			 c= input.nextInt() ; 
			 System.out.format("The %d. element is: %d\n", c , arr[c]) ;
			 con=false ;
		 }
		 
		 catch (ArrayIndexOutOfBoundsException e) {
			 do {
				 try {
					 System.out.println("This index out of bounds") ;
					 System.out.print("Please enter the index of the array AGAIN: ") ;
					 input.nextLine() ; 
					 c= input.nextInt() ; 
					 System.out.format("The %d. element is: %d\n", c , arr[c]) ;
					 con=false ;
			      }
				 catch (ArrayIndexOutOfBoundsException e1) {}
				 }
			 while(con) ;
			 
		 input.close();
	}

}
}