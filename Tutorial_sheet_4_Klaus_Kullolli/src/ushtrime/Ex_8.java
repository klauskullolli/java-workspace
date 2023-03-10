package ushtrime;

import java.util.Scanner;


public class Ex_8 {
	
	 static String  conver (int a ) {
		if (a==0) return "scissor" ;
		else if (a==1) return "rock" ;
		else return "paper" ;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ; 
		int nr1 = (int )(Math.random()*3) ;
		//System.out.println(conver(nr1));
		System.out.print("scissor (0), rock (1), paper (2):");
		int nr2 = input.nextInt() ;
		if ((nr2==0 && nr1==2)||(nr2==1 && nr1==0)||(nr2==2 && nr1==1)) 
			System.out.format("The computer is %s. You are %s. You won", conver(nr1), conver(nr2)) ;
		else if(nr1==nr2)  System.out.format("The computer is %s. You are %s too. It is a draw", conver(nr1), conver(nr2)) ;
		else System.out.format("The computer is %s. You are %s too. You lost", conver(nr1), conver(nr2)) ;
		 
		input.close();
	}

}
