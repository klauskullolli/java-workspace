import java.util.ArrayList;
import java.util.Scanner;



public class Matrix {

	//This is the function that finds all paths in a n x n matrix
	//Parameter are initial position values a dynamic array needed to store position for every step
	// size of array when we should find the path
	public static void path(int x ,int y ,ArrayList<Integer> path , int n  ) {
		
		//base case when excite the array dimensions terminate the recursion
		if(x>=n || y>=n) return ;
		
		//every step is saved in path array as a linear position not as a 2D matrix 
		path.add(x*n + y) ;
		
		//case when it reaches the end of matrix so path it is found
		if(x==n-1 && y==n-1) {
			//print numerical position of the path
			System.out.println(path.toString());
			int c=0 ; 
			
			//print with 1s the path shown in 2D matrix representation 
			for(int i=0 ; i<n ; i++) {
				for(int j = 0 ; j<n ; j++) {
					if((i*n+j) ==path.get(c)) {
						System.out.print(1 + " ");
						c++ ;
					}
					else System.out.print(0 + " ");
				}
				System.out.println();
			}
		
			return ;
		}
		
		// use this approach to solve exercises
		// each time a horizontal movement is done a new path is created with all element of previous one
		// this is done not to loose initial positions and find every branch each time a particular deviation is done
		// same happen if we follow same logic but putting new path in vertical movement
		/*
		 * path(x+1 , y , new ArrayList<>(path) ,  n) ;
		 * path(x, y+1 , path  , n) ;
		 * 
		 * */
		path(x , y+1 , new ArrayList<>(path) ,  n) ;
			
		path(x+1, y , path  , n) ;
			
			
	}
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in) ;
		int n ; 
		System.out.print("Input array size: ");
		n=input.nextInt() ;
		
		//create a empty array list to keep as a path storing way 
		ArrayList<Integer> path1 = new ArrayList<>() ;
		
		//call the function here
		path(0,0,path1 ,n );
		
	   input.close();
	}
	
	

}