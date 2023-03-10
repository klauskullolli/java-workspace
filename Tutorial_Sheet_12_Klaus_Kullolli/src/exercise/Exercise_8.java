package exercise;
import java.io.*;
import java.util.Scanner;
public class Exercise_8 {

	
	
	public static int count (String s , char a) {
		int c= 0 ;
		for (int i = 0 ; i<s.length() ; i++  ) {
			if (s.charAt(i)==a) c++ ;
		}
		
		return c ; 
	}
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in)  ;
		String str ,s="" ;
		System.out.print("Enter a file name: ") ; 
		str = input.nextLine() ;
		try {
			input = new Scanner (new File(str)) ;
			while(input.hasNext()) {
				s= s.concat(input.nextLine()) ;
			}
			System.out.println("Number of Adenine: "+ count(s  , 'a')) ;
			System.out.println("Number of Thymine: "+ count(s  , 't')) ;
			System.out.println("Number of Cytosine: "+ count(s  , 'c')) ;
			System.out.println("Number of Guanine: "+ count(s  , 'g')) ;
		
		}
		catch (Exception e) {
			System.out.println(e.toString()) ;
			e.printStackTrace();
		}
		
		input.close();
	}

}
