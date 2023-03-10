mport java.util.Scanner;
public class MarioTS6_3 {

	public static void main(String[] args) {
		max(3,4);
		max(3.2,2.4);
		max(2.3,1.4,6.3);

	}
	
	public static void max (int a,int b) {
		if (a > b) {
			System.out.println("The max  of"+ a+ " and " + b +" is " + a);
		}
		else {
			System.out.println("The max  of"+ a+ " and " + b +" is " + b);
		}
		
		
	}
	
	
	public static void max (double a,double b) {
		if (a > b) {
			System.out.println("The max  of"+ a+ " and " + b +" is " + a);
		}
		else {
			System.out.println("The max  of"+ a+ " and " + b +" is " + b);
		}
	}
	
	public static void max (double a,double b,double c) {
		if (a >= b && a >= c)
			System.out.println("The max  of"+ a+ " ," + b +" and "+ c+" is " + a);
	      else if (b >= a && b >= c)
	    	  System.out.println("The max  of"+ a+ " ," + b +" and "+ c+" is " + b);
	      else
	    	  System.out.println("The max  of"+ a+ " ," + b +" and "+ c+" is " + c);
	}
}