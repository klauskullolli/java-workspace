

/** EPOKA UNIVERSITY
 * CEN254
 * @author F.Skuka
 * 
 * Lab 5
 * Student Name	   :
 * Student Surname :
 */

import java.util.*;



import java.io.*;

public class BalancedParenthesis {

	static boolean Opening(char ch) {
	    //check for ([{	paranthesis
		if(ch=='(' || ch=='['|| ch=='{')
			return true;
		return false;
	}

	static boolean Closing(char ch) {
		//check for )]}	paranthesis
		if(ch==')' || ch==']'|| ch=='}')
			return true;
		return false;
	}

	static char Convert(char ch) {
		//convert from  right  to left paranthesis. (Closing parenthesis to opening paranthesis)
		if (ch==')' ) return '(' ;
		if (ch=='}' ) return '{' ;
		if (ch==']' ) return'[' ;
		else return ch ;
	}

	public static void main(String[] args) throws IOException {
		
		Scanner keyboard = new Scanner(new FileReader("input.txt"));
		StringTokenizer stok = new StringTokenizer(keyboard.nextLine());

		Stack<Character> st = new Stack<>();

		boolean balanced = true;
		
		while (stok.hasMoreTokens() && balanced) {
			String tmp = stok.nextToken();
			
			int len = tmp.length();
			for (int i = 0; i < len; i++) {
				
				if(Opening(tmp.charAt(i)))
					
					//add to the stack
					{
					st.push(tmp.charAt(i));
					}
				if(Closing(tmp.charAt(i))) {
						
						//ty to remove the corosponding left paranthesis fromthe stack.
						 st.removeElement(Convert(tmp.charAt(i))) ;
						
					}
			}

			
		     
			}
		// change to false balance if is not empty 
		if(!st.empty())  balanced=false ;
		
		if (!balanced)
			System.out.println("Not Balanced");
		else
			System.out.println("Balanced");

	
}
}
