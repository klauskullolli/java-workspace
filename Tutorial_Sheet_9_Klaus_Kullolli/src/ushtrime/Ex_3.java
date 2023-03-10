package ushtrime;

import java.util.*;

public class Ex_3 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		
		Fan f1 =new Fan( Fan.Speed.FAST ,Fan.Status.ON ,10 , "Yellow"  )   ;
		f1.ToString();
		
		Fan f2 = new Fan()  ;
		f2.ToString();
		input.close() ;

	}

}
