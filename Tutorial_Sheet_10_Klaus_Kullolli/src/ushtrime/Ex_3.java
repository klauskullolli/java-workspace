package ushtrime;

import java.util.*;
public class Ex_3 {

	public static ArrayList<Integer> union( ArrayList<Integer> list1, ArrayList<Integer> list2){
		list1.addAll(list2) ;
		return  list1 ;	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		int n ;
		ArrayList<Integer> list1 = new ArrayList<Integer>() ; 
		ArrayList<Integer> list2 = new ArrayList<Integer>() ;
		System.out.print("Enter five integers for list1: ");
		for (int i = 0 ; i< 5 ; i++ ) {
			n = input.nextInt() ;
			list1.add(n) ;
		}
		
		System.out.print("Enter five integers for list2: ");
		for (int i = 0 ; i< 5 ; i++ ) {
			n = input.nextInt() ;
			list2.add(n) ;
		}
		list1 = union(list1 , list2) ;
		System.out.print("The combined list is ");
		for ( int el : list1) {
			System.out.print(el + " ");
		}
		input.close();

	}

}
