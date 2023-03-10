package ushtrime;

import java.util.Scanner;
public class Ex_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ; 
        double w , h ; 
        System.out.print("Enter weight in kilograms:") ;
        w= input.nextDouble() ;
        System.out.print("Enter height in meters:") ;
        h= input.nextDouble() ;
        double ibm = w/Math.pow(h, 2) ;
        System.out.format("BMI is %f\n", ibm);
        if(ibm<18.5) System.out.println("Underweight") ;
        else if (ibm>=18.5 && ibm<25) System.out.println("Normal") ;
        else if (ibm>=25 && ibm<30) System.out.println("Overweight") ;
        else  System.out.println("Obese");
        input.close();
	}

}
