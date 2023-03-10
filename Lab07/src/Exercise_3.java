import java.util.Scanner;

import SRC_CODES.ArrayStack;

public class Exercise_3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		
		// Used to take input 
		String str = input.nextLine() ;
		
		// this array string is used to take each char separately
		String [] strings = str.split(" ");
		
		ArrayStack<Double> stack = new ArrayStack<>() ; 


		
		// the entire work is done
		//all actions are saved in stack
		try {
			for (int i = 0 ; i<strings.length ; i++) {
				
				if(strings[i].equals("*")) stack.push(stack.pop()*stack.pop());
				else if(strings[i].equals("/")) stack.push(stack.pop()/stack.pop());
				else if(strings[i].equals("+")) stack.push(stack.pop()+stack.pop());
				else if(strings[i].equals("-")) stack.push(stack.pop()-stack.pop());
				
				//if is not an operation push into stack
				else stack.push(Double.parseDouble(strings[i]));
			}
			
		} catch (Exception e) {
			System.out.println("Error");
		}
        
		//the remaining element is the answer
		System.out.println(stack.top());
		
	} 

}
