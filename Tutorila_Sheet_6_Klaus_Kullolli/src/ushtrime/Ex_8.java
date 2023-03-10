package ushtrime;


//import java.util.Scanner;


public class Ex_8 {
   
	static char  rand_car () {
		return (char)(97 + (int)(Math.random()*(122-97+1)) )  ;
	}
	
	public static void main(String[] args) {
		///System.out.print(rand_car());
		for(int i=1 ; i<= 10  ; i++)
		{
			for (int j=1 ; j<= 10  ; j++) {
				System.out.print(rand_car());
			}
			System.out.println();
		}
	}

}
