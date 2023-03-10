package ushtrime;

import java.util.Scanner;
public class Ex_3 {
    
	static  int max ( int a , int b) {
		return a>b?a:b;
	}
	
	static  double max ( double a , double b) {
		return a>b?a:b;
	}
	
	static  double max ( double a , double b , double c) {
		double max= a>b?a:b;
		return max>c ? max: c ;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		
		
		input.close();
		

	}

}
