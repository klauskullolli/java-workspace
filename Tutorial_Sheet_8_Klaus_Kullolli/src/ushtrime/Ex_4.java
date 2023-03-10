package ushtrime;

import java.util.*; 
public class Ex_4 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		double a ,b, c ;
		System.out.print("Enter the coefficients a, b, and c:") ; 
		a=input.nextDouble();
		b=input.nextDouble();
		c=input.nextDouble();
		
		Quadratic q1 = new Quadratic(a,b,c) ;
		
		if (q1.getDiscriminant()>0) {
			System.out.println("There are two roots.") ;
			System.out.format("Root1 : %.2f \n",q1.getRoot1() ) ;
			System.out.format("Root1 : %.2f \n", q1.getRoot2()) ;
			
		}

		else if (q1.getDiscriminant()==0) {
			System.out.println("There is one root.") ;
			System.out.format("Root1 : %.2f \n",q1.getRoot1() ) ;
			
			
		}
		else {
			System.out.println("There is on root.") ;
		}
		input.close() ;
		

	}

}
