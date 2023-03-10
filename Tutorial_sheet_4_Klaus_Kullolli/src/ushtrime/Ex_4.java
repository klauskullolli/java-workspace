package ushtrime;

import java.util.Scanner;
public class Ex_4 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		System.out.print("Enter a year:") ;
		int y = input.nextInt() ;
		if (y%4==0 && y%100!=0) System.out.format("%d is a leap year? true", y);
		else System.out.format("%d is a leap year? false", y);
		input.close();

	}

}
