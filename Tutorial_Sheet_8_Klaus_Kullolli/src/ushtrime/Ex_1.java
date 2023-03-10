package ushtrime;

import java.util.Scanner;
public class Ex_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		double width , height  ;
		System.out.println("Rectangle 1: ") ;
		System.out.print("Width: ") ;
		width = input.nextDouble() ;
		System.out.print("Height: ") ;
		height = input.nextDouble() ;
		Rectangle retc1= new Rectangle(width , height) ;
		System.out.format("Area : %.2f \n", retc1.getArea()) ;
		System.out.format("Perimeter : %.2f \n", retc1.getPerimeter()) ;
		System.out.println("Rectangle 2: ") ;
		System.out.print("Width: ") ;
		width = input.nextDouble() ;
		System.out.print("Height: ") ;
		height = input.nextDouble() ;
		Rectangle retc2= new Rectangle(width , height) ;
		System.out.format("Area : %.2f \n", retc2.getArea()) ;
		System.out.format("Perimeter : %.2f \n", retc2.getPerimeter()) ;
		
		
		input.close();

	}

}
