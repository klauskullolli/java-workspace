import java.util.ArrayList;
import java.util.Scanner;


public class Exercise_4 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		
		// these are the required numbers 
		
		int m = input.nextInt()  , n= input.nextInt() ;
		
		
		//Arraylist is needed to create a list with numbers till the index given 
		ArrayList<Integer>  list = new ArrayList<>() ;
		
		for (int i = 1 ; i<=m ; i++) {
			list.add(i) ;
		}
		
		
		//this the required algorithm of the exercise 
		// for the hot potato
		while(list.size()>1) {
		 n = n%list.size() ;
         list.remove(n) ;
         n++ ;
        	
		}
		
		//output the remaining element in the array 
		System.out.println(list.get(0)) ;
	}

}
