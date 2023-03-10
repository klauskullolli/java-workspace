import java.util.*;

public class Ex_2 {

	public static <E extends Comparable<E>> E max(ArrayList<E> list) {
		E max = list.get(0) ; 
		for (int i= 1 ; i<list.size() ; i++ ) {
			if(max.compareTo(list.get(i))<0) max = list.get(i) ;
		}
		return max ;
	}
	
	
	public static void main(String[] args) {
		Integer[] arr1 = {3 , 2, -1 ,7 , 5} ;
		Double[] arr2 = {2.3 , 4.4 , -2.7 , 3.8 , 1.1} ;
		
		ArrayList<Integer>  array =  new ArrayList<Integer>(Arrays.asList(arr1)) ;
		ArrayList<Double>  array1 =  new ArrayList<Double>(Arrays.asList(arr2)) ;
		
		System.out.println(max(array));
		System.out.println(max(array1));
		
}
	
}
