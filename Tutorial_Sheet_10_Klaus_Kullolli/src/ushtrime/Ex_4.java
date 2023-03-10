package ushtrime;
import java.util.*;


public class Ex_4 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		Random random = new Random() ; 
		ArrayList<Integer> anslist = new ArrayList<Integer>() ; 
		int a= random.nextInt(100), b= random.nextInt(100)  ;
		System.out.format("What is %d + %d? " , a ,b);
		int ans = input.nextInt() ; 
		
		while (ans!=(a+b) ) {
			
			if (anslist.contains(ans)) {
				System.out.format("You already entered %d. Try again: " , ans);
				ans=input.nextInt() ;
			}
			else {
				anslist.add(ans) ; 
				System.out.format("Wrong answer. Try again. What is %d + %d? " , a ,b);
				
			}
		}
		System.out.println("You got it!");
		
		input.close();

	}

}
