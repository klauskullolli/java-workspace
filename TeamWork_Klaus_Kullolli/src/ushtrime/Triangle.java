package ushtrime;

public class Triangle extends GeometricObject {
	double s, s1, s2, s3;
	static int nr  ;
	
	public Triangle() {
		nr++  ; 
	}
	
	public Triangle(double s1, double s2, double s3) {
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		nr++ ;
	}
	
	public Triangle(String color , boolean filled , double s1, double s2, double s3) {
		super (color , filled) ;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		nr++ ;
	}
	
	
	@Override
	public double getArea() {
		s = (s1 + s2 + s3) / 2;
		return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
	}

	@Override
	public double getPerimeter() {
		return s1 + s2 + s3;
	}

	@Override
	public String name() {
		return "Triangle";
	}

	@Override
	public void howToColor() {
		System.out.println("\tColor three sides.");
	}
	
	
	public String toString() {
		return this.name() + nr + ": "+nr + 
				 "\n\t Area = " + this.getArea() 
				 +"\n\t Perimeter = " + this.getPerimeter()
				 + "\n\t Color = " +  super.getColor() 
				 +"\n\t Is filled? " + super.getFilled() + "\n";
	}
	
}