package ushtrime;

import java.util.Scanner;

public class Ex_4 {
    static double min(double []arr) {
    	double min =arr[0];
    	for(int i=1 ; i< 10 ; i++){
    		if (arr[i]<min) min=arr[i] ;
    	}
    	return min;
    }
    
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		double [] arr = new double[10] ;
		System.out.print("Enter ten numbers: ");
		for (int i = 0 ; i<10 ; i++) arr[i]=input.nextDouble() ;
		System.out.println("The minimum number is: " + min(arr));
		input.close();
		
	}

}
