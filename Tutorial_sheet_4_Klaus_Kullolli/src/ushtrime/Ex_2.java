package ushtrime;

import java.util.Scanner;
public class Ex_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ; 
		int n1= (int)(Math.random()*10) , n2= (int)(Math.random()*10) ;
		System.out.format("What is %d – %d? " ,n1 ,n2) ;
		int ans = input.nextInt() ;
		while (ans!=n1-n2) {
			System.out.print("You are wrong! Try again:") ;
			ans = input.nextInt() ;
			
		}
		System.out.print("Congratulations, at last !") ;
		input.close();
	}   
	  

}
