package ushtrime;

import java.util.Scanner;

public class Ex_1 {

	public static double average(double[] arr , int n ) {
		double sum= 0 ; 
		for (int i=0 ; i<n ; i++) sum=sum+arr[i] ;
		return (double)sum/n ;
	}
	
	public static int above_avg (double[] arr, int n){
		int c = 0 ;
		double avg = average(arr, n) ;
		for (int i = 0 ; i<n ; i++) {
			if(arr[i]>avg) c++ ;
		}
		return c ;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		int nr  ; 
		System.out.print("Enter the number of items: ");
		nr= input.nextInt();
		double []arr= new double [nr] ;
		System.out.print("Enter the numbers: ");
		for (int i = 0 ; i<nr ; i++) arr[i]=input.nextDouble() ;
		System.out.format ("Average is %.2f \n", average( arr,nr));
		System.out.format ("Number of elements above the average is %d \n ", above_avg( arr,nr));
		
		input.close();

	}

}
