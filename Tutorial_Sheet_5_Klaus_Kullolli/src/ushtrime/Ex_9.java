package ushtrime;

import java.util.Scanner;
public class Ex_9 {
    
	public static Boolean perfect (int a ) {
		int sum = 1; 
	    for (int i = 2; i <=Math.sqrt(a) ; i++) 
	    { 
	        if (a % i==0) 
	        { 
	            if( i != Math.sqrt(a)) 
	                sum = sum + i + a / i; 
	            else
	                sum = sum + i; 
	        } 
	    }  
	    
	    if (sum == a && a != 1) 
	        return true; 
	    return false; 
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		System.out.print("Enter enter a number: ");
		int nr = input.nextInt() ;
		for (int i = 2  ; i<= nr ; i++)
			if(perfect(i)) System.out.println(i) ;
		input.close();
        
	}
}

