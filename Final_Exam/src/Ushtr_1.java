import java.util.Scanner;

public class Ushtr_1 {
    
	
	public static double avg_less_x(double arr[][] , double x) {
		
		int c=0  ; 
		double sum = 0 ; 
		for (int i =0 ; i<arr.length  ; i++) 
			for (int j= 0 ; j<arr[i].length ; j++) {
				if(arr[i][j]<x) {
				c++  ;
				sum =sum + arr[i][j] ;
			}
		}
	return c>0? (double) sum/c : 0 ; 
		
	}	
	
	public static int row_more_el(double arr[][] , double x) {
		int max_row = 0  ; 
		int max_el = 0 ; 
		for (int i=0 ; i<arr[0].length ; i++) {
			if (arr[0][i]< x) {
				max_el++ ; 
			}
			max_row = 1 ; 
		}
		
		for (int i=1 ; i<arr.length ; i++) {
			int row = i+1 ; 
			int el = 0 ;
			for (int j= 0 ; j<arr[i].length ; j++) {
				if(arr[i][j]<x) {
					el++ ; 
					}
				}
			if(el>max_el) {
				max_el = el ;
				max_row = row ; 
			}
		
		}
		return max_row ; 
		
	}
	
	public static void main(String[] args) {
		int r , k ; 
		Scanner input = new Scanner(System.in) ;
		System.out.print("Enter numer of rows and colums:");
		r= input.nextInt() ; 
		k = input.nextInt() ; 
		
		double arr[][] = new double[r][k] ; 
		
		for (int i =0 ; i<r  ; i++) 
			for (int j= 0 ; j<k ; j++) {
				arr[i][j] = input.nextDouble() ;
			}
		
		System.out.print("Enter numer X:");
		double x = input.nextDouble() ; 
		
		System.out.format("Averge of elements less than X: %.2f\n", avg_less_x(arr ,x) );
		System.out.format("Row with more elements less than X is row %d\n", row_more_el(arr , x)) ;
		input.close();
		
	}

}
