package ushtrime;

import java.util.Scanner;
public class Ex_7 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		System.out.print("Enter enter a number: ");
		int nr = input.nextInt() ;
		int  a =0 ;
		double sum=0 ;
		while((2*a + 3)<=nr ) {
			sum=sum + (double)(2*a+1)/(2*a + 3) ;
			a++ ;
		}
		System.out.printf("%.2f" , sum);
		input.close();

	}

}
