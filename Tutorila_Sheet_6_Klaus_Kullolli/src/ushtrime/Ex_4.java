package ushtrime;

import java.util.Scanner;
public class Ex_4 {

	static  void space (int n ) {
		for (int i = 1 ; i<= n ; i++ ) System.out.print(" ") ;
	}
	
	static  void display (int n ) {
		int c= n ;
		for (int i = 1 ; i<= n ; i++ ) {
			space(c) ;
			for (int j= -i ; j<0; j++ ) 
					System.out.print(Math.abs(j));
			System.out.println();
			c-- ;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		int n =7 ;
		display(n) ;
		
		input.close();

	}

}
