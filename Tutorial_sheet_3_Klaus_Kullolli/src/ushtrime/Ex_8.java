package ushtrime;
import java.util.Scanner ;
public class Ex_8 {
	
	static boolean  upper (char a) {
		boolean c=false;
		if (a>='A' && a<='Z') c=true ;
		return c ;
	}
	
	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in);
		System.out.print("Enter the sentence:");
		String s= input.nextLine() ;
		int nr= 0 ;
		for (int i= 0 ; i<s.length(); i++) {
			if (upper(s.charAt(i))) { 
				nr++ ;	
			}
		}
		System.out.format("There are %d uppercase letters in this sentence", nr);
	}

}
