package ushtrime;

import java.util.*; 

public class Ex_2 {

	public static void main(String[] args) {
		Random ran1 = new Random() ;
		Random ran2 = new Random() ;
		ran1.setSeed(1000);
		ran2.setSeed(1000);
		for (int i = 0  ;  i<10 ; i++ ) {
			System.out.print(ran1.nextInt(100) + " ") ;
		}
		System.out.println() ;
		for (int i = 0  ;  i<10 ; i++ ) {
			System.out.print(ran2.nextInt(100) + " ") ;
		}
	}

}
