package ushtrime;

import java.util.Scanner;
public class Ex_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ; 
		int n1= (int)(Math.random()*10) , n2= (int)(Math.random()*10) ;
		System.out.format("What is %d – %d? " ,n1 ,n2) ;
		int ans = input.nextInt() ; 
		if (ans == n1- n2) System.out.println("You are correct!");
		else System.out.format("You are wrong! It is %d" ,(n1-n2)) ;
	    input.close();
	}

}
