package ushtrime;

public class Ex_4 {

	public static void main(String[] args) {
	
			GeometricObject[] a = {new Circle(5), new Square(6), new Rectangle (2, 3), new Triangle(1, 2, 2)};
			
			System.out.println("Area of Circle: " + Math.round(a[0].getArea()*100)/100.0);
			System.out.println("Area of Square: " + Math.round(a[1].getArea()*100)/100.0);
			System.out.println("Area of Rectangle: " + Math.round(a[2].getArea()*100)/100.0);
			System.out.println("Area of Triangle: " + Math.round(a[3].getArea()*100)/100.0 );
			System.out.println("The total area is " + sumArea(a));
			
			System.out.println("\n******************************************\n");
			
			
			System.out.println("The total area of colorable object is " + sumClArea(a));
		}
		
	
	
		public static double sumArea(GeometricObject[] a){

               double sum = 0;
			
			for (int i = 0; i < a.length; i++) {
					sum += a[i].getArea();
			}
			return Math.round(sum*100)/100.0;
		}
		

		public static double  sumClArea(GeometricObject[] a){
			double sum = 0;
			
			for (int i = 0; i < a.length; i++) {
				if (a[i] instanceof Colorable) {
					sum += a[i].getArea();
				}
			}
			return Math.round(sum*100)/100.0;
		}
	
	}


