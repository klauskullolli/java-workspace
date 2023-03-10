package ushtrime;

import java.util.*;

public class Ex_1 {
    
	public static  void  sort (ArrayList<Integer> arr) {
		int i, j, min_idx;  
		  
	    // One by one move boundary of unsorted subarray  
	    for (i = 0; i < arr.size()-1; i++)  
	    {  
	        // Find the minimum element in unsorted array  
	        min_idx = i;  
	        for (j = i+1; j <arr.size() ; j++)  
	        if (arr.get(j) < arr.get(min_idx))  
	            min_idx = j;  
	  
	        // Swap the found minimum element with the first element  
	        int temp = arr.get(min_idx) ; 
	        arr.set(min_idx , arr.get(i)) ;
	        arr.set(i, temp) ;
	    }  
	}
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ; 
		ArrayList<Integer> arr = new ArrayList<Integer>() ;
		int  n  ; 
		for ( int i =0 ; i< 5 ; i++) {
			n = input.nextInt();
			arr.add(n) ;
		}
		sort(arr) ;
		for( int el : arr) {
			System.out.print(el +  " ") ;
		}
		
       input.close(); 
	}

}
