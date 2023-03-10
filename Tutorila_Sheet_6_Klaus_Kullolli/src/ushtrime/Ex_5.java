package ushtrime;

import java.util.Scanner;

public class Ex_5 {
    
	static boolean prime (int nr) {
		boolean c = true ;
		if (nr == 1) return false ;
		else if (nr ==2 ) return true ;
		else {
			for(int i=2 ; i<=Math.sqrt(nr); i++) {
				if (nr %i==0) {
					c=false ;
					break ;
				}
			}
			return c ;
		}
		
	}
	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in);
		System.out.print("Enter a number:");
		int c =0 ; 
		int nr = input.nextInt() ;
		for(int i = 1 ; i<=nr  ; i++) 
			if (prime(i)) c++ ;
		System.out.print(c);
		
		input.close();
	}

}
