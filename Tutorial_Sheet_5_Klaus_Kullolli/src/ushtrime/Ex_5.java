package ushtrime;

import java.util.Scanner;
public class Ex_5 {
    
	static  void space (int n ) {
		for (int i = 1 ; i<= n ; i++ ) System.out.print(" ") ;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		System.out.print("Enter the number of lines: ");
		int n = input.nextInt() ,c=n ;
		for (int i = 1 ; i<= n ; i++ ) {
			space(c) ;
			for (int j= -i ; j<0; j++ ) 
					System.out.print(Math.abs(j));
			System.out.println();
			c-- ;
		}
		input.close();

	}
		
}

