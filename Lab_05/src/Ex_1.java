import java.io.File;
import java.io.FileNotFoundException;
import java.util.* ;

import SRC_CODES.LinkedStack;


public class Ex_1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Create LinkedStack object
		
		LinkedStack<String> sentence = new LinkedStack<String> () ;
		
		//create a file object
		File text = new File("file.txt");
		Scanner input = new Scanner(text) ;
		
		//read file and put into stuck 
		while (input.hasNext()) {
		  sentence.push(input.next()) ;
	}
		
		//pop element from stuck till it is empty 
		while (!sentence.isEmpty()){
			System.out.print(sentence.top()+ " ");
			sentence.pop() ;
	}
		input.close();
}
}



