import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ex_3 {

	
	public static boolean isDouble(ArrayList<Integer> arr)  {
		
		for (int i = 0  ; i<arr.size()  ; i++) {
			int occurrences = Collections.frequency(arr, arr.get(i));
			if (occurrences==2) return true ; 	
		}
		return false ; 
	}
	
	public static boolean isCouple(ArrayList<Integer> arr)  {
		Collections.sort(arr);  
		int nr   ; 
		if(arr.size() %2 == 0 ) nr = arr.size() /2 ; 
		else nr = (arr.size() /2) + 1  ;
		
		
		for (int i = 0  ; i<nr; i++) {
			int occurrences = Collections.frequency(arr, arr.get(i));
			if (occurrences==2) {
				for (int j = i+ 1 ; j< nr ; j++){
					int occurrences1 = Collections.frequency(arr, arr.get(j));
					if (occurrences1==2) return true ;
				} 
			}
		}
		return false ; 
	}
	
	
	
	public static boolean isTriple(ArrayList<Integer> arr)  {
		Collections.sort(arr);  
		int nr   ; 
		if(arr.size() %2 == 0 ) nr = arr.size() /2 ; 
		else nr = (arr.size() /2) + 1  ;
		
		for (int i = 0  ; i<nr ; i++) {
			int occurrences = Collections.frequency(arr, arr.get(i));
			if (occurrences==3) return true ; 	
		}
		return false ; 
	}
	
	

	public static boolean isColor(ArrayList<Integer> arr)  {
		Collections.sort(arr);
		int nr = arr.get(0) ; 
		for (int i = 1  ; i< arr.size() ;  i++) {
			if((nr + i) != arr.get(i)) return false ; 
		}
		 
		return true ;	
	}
	
	public static boolean sameColor(ArrayList<Integer> col)  {
		Collections.sort(col);
		
		if(Collections.frequency(col, col.get(0))==5) return true ;
		 
		return false ;	
	}
	

	public static boolean isDoubleTriple(ArrayList<Integer> arr)  {
		Collections.sort(arr);  
		int nr   ; 
		if(arr.size() %2 == 0 ) nr = arr.size() /2 ; 
		else nr = (arr.size() /2) + 1  ;
		
		
		for (int i = 0  ; i<nr; i++) {
			int occurrences = Collections.frequency(arr, arr.get(i));
			if (occurrences==2) {
				for (int j = i+ 1 ; j< nr ; j++){
					int occurrences1 = Collections.frequency(arr, arr.get(j));
					if (occurrences1==3) return true ;
				} 
			}
		}
		return false ; 
	}
	
	public static boolean isBomb(ArrayList<Integer> arr)  {
		Collections.sort(arr);  
		int nr   ; 
		if(arr.size() %2 == 0 ) nr = arr.size() /2 ; 
		else nr = (arr.size() /2) + 1  ;
		
		for (int i = 0  ; i<nr ; i++) {
			int occurrences = Collections.frequency(arr, arr.get(i));
			if (occurrences==4) return true ; 	
		}
		return false ; 
	}
	
	
	 public static int handValue (Integer value[], Integer color []) {
		 ArrayList<Integer> arr = new  ArrayList<Integer>() ;
		 ArrayList<Integer> col = new  ArrayList<Integer>() ;
		 Collections.addAll(arr, value);
		 Collections.addAll(col, color);
		 Collections.sort(arr);  
		 
		 if (isColor(arr) && sameColor(arr) && arr.get(0)==10 )  return 9 ; 
		 if(isColor(arr) && sameColor(arr)) return 8  ;
		 if(isBomb(arr)) return 7 ;
		 if(isDoubleTriple(arr)) return 6 ; 
		 if(sameColor(arr)) return 5 ;
		 if(isColor(arr))  return 4 ;
		 if (isTriple(arr)) return 3 ;
		 if(isCouple(arr)) return 2 ;
		 if(isDouble(arr)) return 1 ;
		 else return 0 ;
		 
		 
	 }
	
	public static void main(String[] args) {
		
	}

}
