package ushtrime;

public class Rectangle extends GeometricObject implements Colorable{
	private double side1, side2;
	static int nr ;
	
	public Rectangle() {
		nr++ ;
	}
	
	public Rectangle(double side1, double side2) {
		this.side1 = side1;
		this.side2 = side2;
		nr++ ;
	}
	
	public Rectangle( String color , boolean filled , double side1, double side2) {
		super(color , filled);
		this.side1 = side1;
		this.side2 = side2;
		nr++ ;
	}
	@Override
	public void howToColor() {
		System.out.println("\tColor all four sides");
	}

	@Override
	public double getArea() {
		return side1 * side2;
	}

	@Override
	public double getPerimeter() {
		return 2 * side1 + 2 * side2;
	}

	@Override
	public String name() {
		return "Rectangle";
	}
	
	public String toString() {
		return this.name() + nr + ": "+nr + 
				String.format("\n\t Area = %.2f" ,this.getArea()) 
				 + String.format("\n\t Perimeter = %.2f" ,this.getPerimeter()) 
				 + "\n\t Color = " +  super.getColor() 
				 +"\n\t Is filled? " + super.getFilled() ;
	}
	
}
