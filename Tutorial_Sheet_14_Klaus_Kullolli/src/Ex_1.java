import java.util.*;
public class Ex_1 {

	public static <T> void shuffle(T[] list) {
		 Collections.shuffle(Arrays.asList(list));
	  	
	}
	
	public static void main(String[] args) {
		
			String []names = {"Deni" , "Beni", "Max"  , "Hans"} ;
			Integer [] numbers = {1 ,2, 3,4,5} ;
			String [] cities  = {"Tiran"  ,"Durres" , "Shkoder" , "Elbasan"  ,"Lushnje" }  ;
			shuffle(names) ;
			System.out.println(Arrays.toString(names));
			shuffle(numbers) ;
			System.out.println(Arrays.toString(numbers));
			shuffle(cities) ;
			System.out.println(Arrays.toString(cities));
			
			
	}

}
