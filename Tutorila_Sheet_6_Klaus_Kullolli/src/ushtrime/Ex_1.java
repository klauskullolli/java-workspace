package ushtrime;

import java.util.Scanner;
import java.io.*;
public class Ex_1 {
    
	public static int len_2 (String s) {
		int c=0 ;
		
		try {
		for (int i=0 ; s.charAt(i)!='\0' ; i++) c++;
		}
	  catch (StringIndexOutOfBoundsException e) {
			
		}
		
		return c ;
	}
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		String s ;
		s= input.nextLine() ;
		System.out.print(len_2(s));
		input.close();
		
	}

}
