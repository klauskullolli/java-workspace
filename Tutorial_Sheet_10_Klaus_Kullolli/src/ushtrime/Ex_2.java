package ushtrime;

import java.util.*;
public class Ex_2 {
    
	public static void removeDuplicate(ArrayList<Integer> list)
	{   
		ArrayList<Integer> list2= new ArrayList<Integer>(list) ;
	
		list.clear();
		
		for(int i = 0 ; i<list2.size() ; i++ ) {
			if (!(list.contains(list2.get(i)))){
				list.add(list2.get(i)) ;
			}
		}
	
	}
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		int n  ; 
		
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		System.out.print("Enter ten integers: ");
		for (int i = 0 ; i< 10 ; i++ ) {
			n = input.nextInt() ;
			list.add(n) ;
		}
		removeDuplicate( list);
		System.out.print("The distinct integers are ");
		for ( int el : list) {
			System.out.print(el + " ");
		}
		input.close();
	}
}


