package Question3;

import java.util.ArrayList;



public class Exercise5 {
	
	
	
	
	public static ArrayList<Character>removeDuplicates(ArrayList<Character> data) {
		ArrayList<Character> data1 = new ArrayList<>() ;
		for (int i =0 ; i<data.size() ; i++) {
			if(data1.contains(data.get(i))) continue ;
			
			data1.add(data.get(i)) ;
		}
		return data1;
	}
	
	public static void odd_nr (int nr) {
		if(nr<=0) return ;
		
		if (nr%2==0) odd_nr(nr-1);
		
		else {
			odd_nr(nr-2);
			System.out.print(nr + " ");
		}
	}
	

	public static void main(String[] args) {
		
		ArrayList<Character> data = new ArrayList<>() ;
		data.add('e') ;
		data.add('e') ;
		data.add('d') ;
		data.add('d') ;
		data=removeDuplicates(data) ;
		System.out.print(data);
		
	}

}
