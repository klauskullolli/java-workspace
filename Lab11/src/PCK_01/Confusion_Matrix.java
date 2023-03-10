package PCK_01;


import java.util.HashMap;
import java.util.Scanner;



public class Confusion_Matrix {

	public static void main(String[] args) {
		
		//create hashmap class to keep corresponding array index of fruits strings
		HashMap<String , Integer> hashtable = new HashMap<>() ;
		
		Scanner input = new Scanner(System.in) ;
		
		int a=input.nextInt() , b=input.nextInt() ;
		String fruit ,fruit1 ;
		
		//here hash map if filled with indexes for corresponding strings
		for (int i=0 ; i<a ; i++) {
			fruit = input.next() ;
			hashtable.put(fruit, i) ;
			
		}
		
		//2d array needed to keep track of predictions and actuals  
		int array[][] = new int[a][a] ;
		
		for(int i=0 ; i<b ; i++) {
			
			//input actual value and predictions 
			fruit = input.next() ;
			fruit1 = input.next() ;
			//increment by 1 value of array for corresponding cell for an actual value and prediction 
			array[hashtable.get(fruit)][hashtable.get(fruit1)]+=1 ; ;
		}
		
		
		//print created array
		for(int i = 0 ; i<a ;i++) {
			for(int j=0 ; j<a ; j++){
				System.out.print( array[i][j]+" ");
			}
			System.out.println();
		}
		
		input.close();
		
		
		
	}

}
