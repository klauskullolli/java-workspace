package ushtrime;
//import java.util.*; 
public class Ex_3 {

	public static void main(String[] args) {
		Polygon poly1 = new Polygon();
		Polygon poly2 = new Polygon(8, 5);
		System.out.println("Polygon 1: ");
		System.out.println(" # of sides: " + poly1.getN());
		System.out.println(" length of a side: " + poly1.getSide());
		System.out.println(" Area: " + poly1.getArea());
		System.out.println(" Perimeter: " + poly1.getPerimeter());
		System.out.println("Polygon 2: ");
		System.out.println(" # of sides: " + poly2.getN());
		System.out.println(" length of a side: " + poly2.getSide());
		System.out.println(" Area: " + poly2.getArea());
		System.out.println(" Perimeter: " + poly2.getPerimeter());
		System.out.println(Polygon.count() + " polygon was created until now.");

	}

}
