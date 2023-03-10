package ushtrime;

public class Ex_7 {

	public static void main(String[] args) {
		Shape sh = new Shape("blue" , true) ;
		Circle c = new Circle (10) ;
		Rectangle r  = new Rectangle (10 , 5 , "green" , false) ;
		Square s = new Square (20 , "cyan", true) ;
		
		System.out.println(sh);
		System.out.println(c);
		System.out.format("Area of the circle is %.3f and the perimeter is %.3f.\n" , c.getArea(), c.getPerimeter());
		System.out.println(r);
		System.out.format("Area of the rectangle is %.1f and the perimeter is %.1f.\n" , r.getArea() , r.getPerimeter());
		System.out.println(s);
		System.out.format("Area of the square is %.1f and the perimeter is %.1f.\n" , s.getArea() , s.getPerimeter());
	}

}
