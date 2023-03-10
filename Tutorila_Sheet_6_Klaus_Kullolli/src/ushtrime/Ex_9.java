package ushtrime;

public class Ex_9 {
    
	static boolean letters_digits(String s ) {
		for(int i= 0 ; i<s.length() ; i++  ) {
			if(!(( s.charAt(i)>=48 && s.charAt(i)<=57 ) || ( s.charAt(i)>=65 && s.charAt(i)<=90 ) || ( s.charAt(i)>=97 && s.charAt(i)<=122 ) ))
				return false  ; 
			
		}
		return true ;
	}
	
	static boolean at_least(String s) {
		int c= 0 ;
		for(int i= 0 ; i<s.length() ; i++  ) {
			if( s.charAt(i)>=48 && s.charAt(i)<=57 ) {
				c++ ;
				if (c>=2) return true ;
		}	
	}
	return false ;
}
	
	static boolean password(String s) {
		if (s.length()>=8 && letters_digits(s ) && at_least( s)) return true ;
		return false ;
	}
	
	public static void main(String[] args) {
		//System.out.print(letters_digits("123wrtr_")) ;
		System.out.print(password("132re")) ;


	}

}
