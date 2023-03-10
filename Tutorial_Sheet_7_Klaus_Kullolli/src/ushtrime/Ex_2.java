package ushtrime;

import java.util.Scanner;
public class Ex_2 {

	
	static void reverse(int [] arr ){
		int i = 0 , tem; 
		int j = arr.length -1 ;
		while (i<j) {
			tem =arr[i] ;
			arr[i]=arr[j] ;
			arr[j]=tem ;
			i++; 
			j-- ;
		}
		
	} 
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in) ;
		int nr ;
		nr= input.nextInt();
		int [] arr = new int[nr] ;
		for (int i = 0 ; i<nr ; i++) arr[i]=input.nextInt() ;
		reverse (arr) ;
		for (int i = 0 ; i<nr ; i++) System.out.print(arr[i]+" " ); ;
		input.close();
		
		
		
	}

}
