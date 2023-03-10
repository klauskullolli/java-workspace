package ushtrime;
import java.util.*;

public class Ex_2 {
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Circle circle = new Circle();
		double radius  ;
		String color ;
		boolean filled ;
		System.out.print("Radius: ");
		radius = input.nextDouble();
		
		System.out.print("Color: ");
		 color = input.next();
		
		System.out.print("Is the circle filled? true/false: ");
		filled = input.nextBoolean();
		
		
		input.close();
		Circle circle = new Circle(color ,filled  ,radius);
		System.out.println(circle);
		
	}

}
	
	


