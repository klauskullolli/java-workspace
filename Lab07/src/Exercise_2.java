
import ArrayQueue.ArrayQueue;
import SRC_CODES.ArrayStack;

public class Exercise_2 {
	
	public static void stack_fill (ArrayStack<Integer> stack , int [] arr  ) {
		for(int i=0 ; i<arr.length ; i++ ) stack.push(arr[i]);
	}

	public static void main(String[] args) {
		
		ArrayStack<Integer> stack1=new ArrayStack<>() , stack2 = new ArrayStack<>() ; 
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>() ; 
		
		//Point a of exercise 
		stack1.push(-1);
		stack1.push(15);
		stack1.push(23);
		stack1.push(44);
		stack1.push(4);
		stack1.push(99);
		
		//point b of exercise 
		while(!stack1.isEmpty()) {
			stack2.push(stack1.top());
			queue.enqueue(stack1.pop());
		}
		
		//point c of exercise 
		
		while(!stack2.isEmpty()) {
			System.out.println(stack2.pop() + "  " + queue.dequeue());
		}
		
		
		//point d of exercise 
		int [] arr = {-1, 15, 23, 44, 4, 99} ;
		ArrayStack<Integer> stack3 = new ArrayStack<>() ;
		
		stack_fill(stack3, arr);
		
		 
	}

}
