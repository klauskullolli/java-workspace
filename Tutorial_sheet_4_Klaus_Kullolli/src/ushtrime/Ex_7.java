package ushtrime;

import java.util.Scanner;
public class Ex_7 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		System.out.print("Enter a, b and c coefficients: ") ;
		double a = input.nextDouble() , b= input.nextDouble() , c=input.nextDouble() ;
		double dall = b*b-4*a*c ; 
		if (dall>0) {
			System.out.format("r1= %.2f\n", (-b + Math.sqrt(dall))/2*a) ;
			System.out.format("r2= %.2f\n", (-b - Math.sqrt(dall))/2*a) ;
		}else if (dall<0) System.out.println("The equation has no real roots") ;
		else System.out.format("r1,2= %.2f\n", -b /2*a) ;
		
		input.close();

	}

}
