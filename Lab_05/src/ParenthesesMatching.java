


import java.util.Scanner;
import java.util.Stack;

import SRC_CODES.ArrayStack;


public class ParenthesesMatching {
	/**
	 * output the matched parenthesis pairs in the string expr
	 * 
	 * @param <E>
	 */

	public static <E> void printMatchedPairs(String expr) {

	
		ArrayStack<Integer> s = new ArrayStack<Integer>();
		
		int length = expr.length(); 

		// scan expression expr for ( and )
		for (int i = 0; i < length; i++)
			if (expr.charAt(i) == '(')
				s.push(new Integer(i)); // => s.push(Integer.valueOf(i));
			else if (expr.charAt(i) == ')')
				try {// remove location of matching '(' from stack
					System.out.println(s.pop() + "  " + i);
				} catch (Exception e) {// stack was empty, no match exists
					System.out.println("No match for right parenthesis" + " at " + i);
				}

		// remaining '(' in stack are unmatched
		while (!s.isEmpty())
			System.out.println("No match for left parenthesis at " + s.pop());
	}

	/** test program */
	public static void main(String[] args) {
		// define the input stream to be the standard input stream
		Scanner keyboard = new Scanner(System.in);

		// input the expression
		System.out.println("Type an expression with no spaces");
		String expression = keyboard.nextLine();

		// output the pairs of matched parentheses
		System.out.println("The pairs of matching parentheses in");
		System.out.println(expression);
		System.out.println("are (indexing begins at 0)");
		printMatchedPairs(expression);
		keyboard.close();
	}
}
