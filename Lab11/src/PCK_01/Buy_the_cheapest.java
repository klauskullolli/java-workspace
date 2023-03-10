package PCK_01;

import java.util.HashMap;
import java.util.Scanner;

//class to make easier accessing values of product 
class product {
	int min ; 
	int max ;
	
	public product(int a , int b) {
		min = Math.min(a, b) ;
		max = Math.max(a, b) ;
	}
}


public class Buy_the_cheapest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		
		int n=input.nextInt()  , m=input.nextInt()  ;
		//need to have a faster access for specific id values 
		//id needed as a accessing key and product that is going to be accessed
		HashMap<Integer , product> hashtable = new HashMap<>() ;
		
		
		//here have id and prices for specific id 
		int a , b , c ; 
		
		//put into hash map for better and faster access
		for (int i = 0 ; i<n ; i++) {
			a= input.nextInt() ;
			b= input.nextInt() ;
			c= input.nextInt() ;
			hashtable.put(a, new product(b, c)) ;
		}
		
		
		
		int sum = 0 ; 
		
		//find sum of the lowest prices for given products
		for (int i = 0 ; i<m ; i++) {
			a= input.nextInt() ;
			//if not in hash table continue without adding 
			if(hashtable.containsKey(a))
				sum=sum + hashtable.get(a).min ;
		}
		
		//print sum
		System.out.println(sum);
		input.close();
	}

}
