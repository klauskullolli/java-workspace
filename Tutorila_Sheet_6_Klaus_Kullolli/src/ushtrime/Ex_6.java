package ushtrime;

import java.util.Scanner;
public class Ex_6 {

	public static void main(String[] args) {
	
Scanner get=new Scanner(System.in);
	
System.out.println("Celcius   Fahrenheit  | Fahrenheit    Celcius ");
	
System.out.println("_________________");
	
	
double cel=25;//get.nextDouble(); 
	double far=155;//get.nextDouble();
	
System.out.print(cel);
	System.out.print(celToFahr(cel));
	System.out.print("   ");

	System.out.print(far);
	System.out.print(fahrToCel(far));
	
	get.close();
	}
	
public static double celToFahr (double celsius) {
		return 9.0/5*celsius+32;
		
	}
	
public static double fahrToCel (double fahrenheit) {
		return 5.0/9*fahrenheit-32;
		
	}

}
