
public class Ex_3 {
	
	public static <E extends Comparable<E>> E max(E[] list) {
		E max = list[0] ; 
		for (int i= 1 ; i<list.length ; i++ ) {
			if(max.compareTo(list[i])<0) max = list[i] ;
		}
		return max ;
	}
	
	
	public static void main(String[] args) {
		Integer[] arr1 = {3 , 2, -1 ,7 , 5} ;
		Double[] arr2 = {2.3 , 4.4 , -2.7 , 3.8 , 1.1} ;
		
		
		System.out.println(max(arr1));
		System.out.println(max(arr2));
		
}
	
}

