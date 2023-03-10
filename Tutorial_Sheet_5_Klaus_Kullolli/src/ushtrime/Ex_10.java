package ushtrime;

import java.util.Scanner;

public class Ex_10 {
    
	static int  combination (int a , int b ) {
		int nr = 0 ; 
		for (int i=a ; i<=b ; i++) {
			for (int j=i + 1; j<=b ;j++) {
				System.out.format("(%d , %d )\n", i , j) ;
				nr++ ;
			}
		}
		return nr ;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		System.out.print("Enter range of numbers: ");
		int a =input.nextInt()  , b=input.nextInt() ;
		combination(a, b);
		System.out.println("The total number of all combinations is " + combination(a, b));
		
		input.close();

	}

}
