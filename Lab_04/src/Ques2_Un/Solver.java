package Ques2_Un;

import java.util.Scanner;

public class Solver {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list = new LinkedList();
		Scanner scan=new Scanner(System.in);

		// Declare aother variables
		String name ;
		String surname ; 
		Double amount ;
		
	
		
		
		
		//Read the number of donors and the number of donors to be displayed
		int nrDon = scan.nextInt() ;
		int M = scan.nextInt() ;
		
		// Iteration is used to fill data for each donor  
		
		for (int i=0; i<nrDon ; i++) {
			
			//input parameters for every node 
			name = scan.next() ;
			surname = scan.next() ;
			amount = scan.nextDouble() ;
			list.add(name, surname, amount);
		}
		// Print the first top M donurs.
		list.pritntFirstN(M);
	}
}