package ushtrime;

import java.util.Scanner;

public class Ex_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		int nr ;
		System.out.print("Enter a number: ");
		nr=input.nextInt() ;
		System.out.println("Kilogram\t Pounds");
		for (int i= 1 ; i<=nr ; i++ ) {
			System.out.printf("%d\t \t%.2f\n", i , 2.2*i);
		}
		input.close(); 

	}

}
