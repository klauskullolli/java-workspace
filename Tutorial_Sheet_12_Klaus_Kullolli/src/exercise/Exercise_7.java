package exercise;

//import java.io.File;
import java.util.Scanner;

import java.net.URL;
public class Exercise_7 {

	public static void main(String[] args) {
		int nr = 0 ; 
		double sum = 0 ;
		try {
			URL url= new URL("http://cs.armstrong.edu/liang/data/Scores.txt") ;
				Scanner input = new Scanner (url.openStream()) ;
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
