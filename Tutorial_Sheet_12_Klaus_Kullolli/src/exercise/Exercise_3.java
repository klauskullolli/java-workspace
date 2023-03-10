package exercise;

import java.io.*;

import java.util.*;
public class Exercise_3 {

	public static void main(String[] args)  {
		String a , b ; 
		int  c ;
		try {
			File file = new File("students.txt") ;
			Scanner input = new  Scanner(file) ;
			while(input.hasNext()) {
			  a=input.next(); 
			  b= input.next() ; 
			  c = input.nextInt() ;
			  System.out.println(a+ " " + b + " " + c  ) ;
			  
		}
			input.close();
		}
		
		catch(Exception e){
			
			System.out.println(e.toString()) ;
		}
		
	
	}

}
