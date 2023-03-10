import java.util.Scanner;

import SRC_CODES.ArrayStack;

public class Exercise_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;
		
		//string needed to take input from user
		String s1 = input.nextLine() ;
		
		// Split the string and create array string
		String [] s2 = s1.split(" ") ;
		ArrayStack<String> stack = new ArrayStack<>() ;
		
		//push into stack all elements 
		for (int i=0 ; i< s2.length ; i++) stack.push(s2[i]);
		
		//print stack elements
	    while(!stack.isEmpty()) System.out.print(stack.pop()+ " ");
	}

}
