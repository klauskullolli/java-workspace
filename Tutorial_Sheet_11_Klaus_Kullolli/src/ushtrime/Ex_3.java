package ushtrime;

public class Ex_3 {

	public static void main(String[] args) {
    GeometricObject[] object = new GeometricObject[3];
		
		object[0] = new Triangle("blue", true ,2, 5, 6);
		object[1] = new Circle("black" , false ,5.5);
		object[2] = new Square("green" , true , 2.7);
		
		System.out.println(object[0]);
		System.out.println(object[1]);
		System.out.println(object[2]);
		object[2].howToColor();
	}

}
