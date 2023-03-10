package ushtrime;

import java.util.Scanner;

public class Ex_3 {
	
	public static double average(double[] arr  ) {
		double sum= 0 ; 
		int c=0 ;
		for (int i=0 ;arr[i]>0 ; i++) {
			sum=sum+arr[i] ;
			c++ ;
		}
		return (double)sum/c ;
	}
	
	public static int above_avg (double[] arr){
		int c = 0 ;
		double avg = average(arr) ;
		for (int i = 0 ; arr[i]>0 ; i++) {
			if(arr[i]>=avg) c++ ;
		}
		return c ;
	}
	
	public static int below_avg (double[] arr){
		int c = 0 ;
		double avg = average(arr) ;
		for (int i = 0 ; arr[i]>0; i++) {
			if(arr[i]<avg) c++ ;
		}
		return c ;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		
		double [] arr = new double[200] ;
		for (int i = 0 ; i<200 ; i++) { 
			arr[i]=input.nextInt() ;
			if (arr[i]<0) {
				arr[i]=0 ;
				break ;
			}
		}
		
		System.out.println("Average:" + average(arr));
		System.out.println("Number of elements above or equal the average: " + above_avg(arr));
		System.out.println("Number of elements below the average: " +below_avg(arr));
		input.close();

	}

}
