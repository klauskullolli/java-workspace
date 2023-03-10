package ushtrime;

import java.util.*;
public class Ex_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		Circle c1 = new Circle(2, 2, 5.5);
		System.out.format("The area of c1 is: %.2f\n" , c1.getArea());
		System.out.format("The perimeter of c1 is: %.2f\n" , c1.getPerimeter());
		System.out.format("The point (3, 3) is in the c1: %b\n" , c1.contains(3,3));
		System.out.format("The circle at (4, 5) with radius 10.5 contains c1: %b\n" , c1.contains(new Circle(4 , 5, 10.5)));
		System.out.format("The circle at (3, 5) with radius 2.3 overlaps c1: %b\n" , c1.overlaps(new Circle(3,5,2.3)));
		input.close();

	}

}
