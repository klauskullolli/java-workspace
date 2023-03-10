package ushtrime;

import java.util.Scanner;
public class Ex_5 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		int nr = (int) (10 + Math.random()*(100-10)) ;
		//System.out.println(nr);
		System.out.print("Enter your lottery pick (two digits): ");
		String s1 = input.next()  , s2=Integer.toString(nr) ;
		if (s1.equals(s2)) {
			System.out.format("The lottery number is %d\n", nr);
			System.out.println("Exact match: you win $10,000");	
		} else if(s2.compareTo(s1)==0) {
			System.out.format("The lottery number is %d\n", nr);
			System.out.println("Match all digits: you win $3,000");	

		}else if(s1.indexOf(s2.charAt(0))!=-1 || s1.indexOf(s2.charAt(1))!=-1) {
			System.out.format("The lottery number is %d\n", nr);
			System.out.println("Match one digit: you win $1,000");	
			
		}else {
			System.out.format("The lottery number is %d\n", nr);
			System.out.println("Sorry: no match");	
		}
		
		input.close();

	}

}
