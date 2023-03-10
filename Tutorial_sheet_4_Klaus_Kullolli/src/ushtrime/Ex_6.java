package ushtrime;

import java.util.Scanner;
public class Ex_6 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		System.out.println("Enter a number for  0 to 6: ");
		int nr = input.nextInt() ;
		switch (nr) {
		case 0:  System.out.println("Monday"); break ; 
		case 1:  System.out.println("Tuesday"); break ; 
		case 2:  System.out.println("Wednesday"); break ; 
		case 3:  System.out.println("Thursday"); break ; 
		case 4:  System.out.println("Friday"); break ; 
		case 5:  System.out.println("Saturday"); break ;
		case 6:  System.out.println("Sunday"); break ;
		default: System.out.println("Not a number between(0-7)");
		
		}
		input.close();
	}

}
