package ushtrime;
import java.util.*;;

public class Ex_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Triangle triangle = new Triangle();
		double a, b , c  ;
		String color ;
		boolean filled ;
		System.out.println("Enter three sides of a triangle:");
		
		System.out.print("\tSide 1 = ");
		a = input.nextDouble();
		
		System.out.print("\tSide 2 = ");
		b = input.nextDouble();
		
		System.out.print("\tSide 3 = ");
		c = input.nextDouble();
		
		System.out.print("Enter a triangle color: ");
		 color = input.next(); 
		
		
		System.out.print("Is the triangle filled? true/false: ");
		 filled = input.nextBoolean();
		
		 Triangle triangle = new Triangle(color , filled ,a,b,c);
		
		
		//System.out.println(triangle.name());
		System.out.println(triangle);
		//System.out.println("\tPerimeter: " + triangle.getPerimeter());
		//System.out.println("\tColor: " + triangle.getColor());
		//System.out.println("\tIs filled? " + triangle.getFilled());

		input.close();
	}

}
