package ushtrime;

class Square extends GeometricObject implements Colorable {
	
	double side;
	static int nr ;
	
	public Square() {
		nr++ ;
	}
	
	public Square( double side) {
		this.side = side;
		nr ++ ;
	}
	public Square(String color  , boolean filled , double side) {
		super(color , filled) ;
		this.side = side;
		nr ++ ;
	}
	
	public void howToColor() {
		System.out.println("\tColor all four sides.");
	}

	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public double getPerimeter() {
		return side * 4;
	}

	@Override
	public String name() {
		return "Square";
	}
	
	public String toString() {
		return this.name() + nr + ": "+ nr + 
				String.format("\n\t Area = %.2f" ,this.getArea()) 
				 + String.format("\n\t Perimeter = %.2f" ,this.getPerimeter()) 
				 + "\n\t Color = " +  super.getColor() 
				 +"\n\t Is filled? " + super.getFilled() + "\n" ;
}
}