package PCK_01;

import java.util.HashMap;
import java.util.Scanner;





public class Birthday_Celebration {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		
		//Array that contain all months 
		String months[] = {"Jan" , "Feb" , "Mar", "Apr" , "May" ,"Jun" ,"Jul" , "Aug" , "Sep" ,"Oct" ,"Nov" ,"Dec" };
		
		//Use hashmap object to convert months to specific indexes for array 
		HashMap<String, Integer> hashtable = new HashMap<>() ;
		
		//Here hashmap object is filled with indexes for specific month 
		for (int i=0 ; i<12 ; i++) {
			hashtable.put(months[i], i);
		}
		
		//number of students 
		int n= input.nextInt() ;
		
		//keep record how many students are born in same month 
		int array[] = new int[12] ;
		
		
		String name , month ;
		
		int day , year ;
		
		
		//here is counted nr of student for corresponding month
		for(int i =0 ; i< n ; i++) {
			name= input.next() ;
			day=input.nextInt() ;
			month = input.next() ;
			year=input.nextInt() ;
			array[hashtable.get(month)] += 1 ;
		}
		
		month=input.next() ;
		
		//output for a month asked by user 
		System.out.println(array[hashtable.get(month)]);
		
		input.close(); 
	}
	

}
