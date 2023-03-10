package ushtrime;

public class Circle extends GeometricObject {
	private double radius;
	static int nr ;
	
	public Circle() {
		nr++ ;
	}
	
	public Circle(  double radius) {
		this.radius = radius;
		nr++ ;
	}
	
	public Circle( String color , boolean filled , double radius) {
		super(color , filled) ;
		this.radius = radius;
		nr++ ;
	}
	
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String name() {
		return "Circle";
	}
	
	
	public void howToColor() {
		System.out.println("\tColor circumference. ");
	}
	
	public String toString() {
		return this.name() + nr + ": "+nr + 
				String.format("\n\t Area = %.2f" ,this.getArea()) 
				 + String.format("\n\t Perimeter = %.2f" ,this.getPerimeter()) 
				 + "\n\t Color = " +  super.getColor() 
				 +"\n\t Is filled? " + super.getFilled() ;
	}
}