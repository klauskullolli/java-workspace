package ushtrime;


import java.util.Scanner;

public class Ex_7 {

	static double sum_serie (int a) {
		double sum = 0 ; 
		for (int i =1 ; i<=a  ; i++) {
			sum=sum + (double) i/(i+1) ; 
			
		}
		return sum  ;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		System.out.print("Enter a number: ");
		int n = input.nextInt() ;
		for (int i=1 ; i<=n ; i++  )
		input.close() ;

	}

}
