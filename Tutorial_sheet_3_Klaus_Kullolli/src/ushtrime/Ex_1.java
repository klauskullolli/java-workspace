package ushtrime;
 
import java.util.Scanner ; 

public class Ex_1 {

	public static void main(String[] args) {
		
		int i = 44  +  (int) (Math.random() * (65-44) ); 
		System.out.println(i);
		int  j =  (int) (Math.random() * 1000 );
		System.out.println(j);
		double k = 3.5 +  (Math.random() * (35.5-3.5) ) ; 
		System.out.format( "%.2f" ,k);
	}

}
