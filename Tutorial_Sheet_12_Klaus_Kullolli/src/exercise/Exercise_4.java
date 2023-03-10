package exercise;
import java.io.*;
import java.util.*;
public class Exercise_4 {

	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in) ;
		String str  ; 
		try {
			File file = new File("students.txt") ;
			PrintWriter output = new PrintWriter(file);
			System.out.print("Name Lastname ID or q to quit: ") ; 
			str= input.nextLine() ;
			
			
			while (!str.equals("q")) {
				output.println(str);
				System.out.print("Name Lastname ID or q to quit: ") ; 
				str= input.nextLine() ;
				
			}
			output.close();
		}
		
		catch(Exception e){
			
				System.out.println(e.toString()) ;
		}
	
		input.close();
        
	}
	

}
