package ushtrime;

import java.util.Scanner;
public class Ex_4 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		System.out.print("Enter the number of lines: ");
		int n = input.nextInt() ;
		for (int i = n ; i>0 ; i-- ) {
			for (int j= 1 ; j<= i ; j++ )
				System.out.print(j);
			System.out.println();
		}
		input.close();

	}

}


