package ushtrime;
import java.util.Scanner;
public class EX_1 {

	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in) ;
		System.out.print("Enter a degree in Celsius:");
		int c = input.nextInt() ; 
		double f= 1.8 *c + 32 ;
		System.out.println( f +" Fahrenheit");
		
		

	}

}
