package exercise;
import java.io.*;
import java.util.*;
public class Exercise_6 {

	public static void main(String[] args) {
		int nr = 0 ; 
		double sum = 0 ;
		try {
			File file = new File("score.txt") ;
				Scanner input = new Scanner (file) ;
				while (input.hasNext()) {
					sum = sum + input.nextDouble() ;
					nr++ ;
					
					}
				System.out.format("Total is: %.2f\n" , sum);
				System.out.format("Total is: %.2f\n" , (sum/nr));
				input.close();
				}
		catch (Exception e) {
			System.out.println(e.toString()) ;
		}
		
		
		
	}

}
