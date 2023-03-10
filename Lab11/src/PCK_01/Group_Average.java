package PCK_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Group_Average {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		
		//number of inputs and nr of courses that are going to be shown 
		int n = input.nextInt() , m = input.nextInt() ;
		
		//used to access from courses number of students easier 
		HashMap<String, Integer> hashtable = new HashMap<>() ;
		
		// save all courses in an array to use as a key in hashtable to access values
		ArrayList< String> arr_course = new ArrayList<>();

		String course ; 
		int k ,temp ; 
		
		//here is the algorithm to fulfill the hashtabele and array list  
		for (int i = 0 ; i < n ; i++ ) {
			course = input.next() ; 
			k = input.nextInt() ;
			
			//if key already exist we just update it 
			if(hashtable.containsKey(course)) {
			    temp = hashtable.get(course);
				hashtable.replace(course, temp+k) ;
				
			}
			
			//add key otherwise 
			else {
				hashtable.put(course, k) ;
				arr_course.add(course) ;
			}
		} 
		
		//used to keep track of index of course with more students 
		int index = 0 ;
		
		//Algorithm to print in descending order 
		for (int i =0 ; i<m  ; i++) {
			
			//Put first element of map and array to be the biggest 
			String string = arr_course.get(0) ;
			int max = hashtable.get(arr_course.get(0)) ;
			
			//check for the biggest 
			for (int j=1 ; j < arr_course.size() ; j++) {
				if(max<hashtable.get(arr_course.get(j))) {
					max=hashtable.get(arr_course.get(j)) ;
					string = arr_course.get(j) ;
					index=j ;
				}
			}
			
			//print the biggest 
			System.out.println(string);
			
			//delete the biggest to find the second biggest and so on till a specific position 
			arr_course.remove(index) ;
			hashtable.remove(string) ;
		}
		
		input.close();
		

	}

}
