package Question3;

import ArrayQueue.*;
import LinkedQueue.Queue;
import LinkedQueue.SinglyLinkedList;
import SRC_CODES.ArrayStack;
import SRC_CODES.Stack;



public class Solver {
	

	public static <E> Stack<E> buildStack(E[] a) {
		
		Stack<E> stack = new ArrayStack<E> () ;
		
        for (int i =0 ; i<a.length ; i++)
        {
        	stack.push(a[i]);
        }
		
		
			
		return stack;  /// to be changed 
	}
	
   //this function that provide the method to find element and to keep unchanged the stack
	public static <E> boolean check(Stack<E> S, Queue<E> Q, E e) {
		boolean flag=false;
		
		//this single linked list is needed because queue have different order than stack 
		SinglyLinkedList<E> s1 = new SinglyLinkedList<E>() ;
		while (S.top()!=null) {
			if(S.top()==e) flag = true ;
			s1.addFirst(S.top());;
			S.pop();
		}
		
		//add element of single list into queue because we have to use it 
		while (!s1.isEmpty()) {
			Q.enqueue(s1.first());
			s1.removeFirst() ;
		}
		
		
		// from queue we can insert element in stack in a same order as in the beginning 
		while(Q.first()!=null) {
			S.push(Q.first());
			Q.dequeue() ;
		}
	  
		return flag;
	}
	
	
	
	
    public static void main(String[] args) {
		
    	// TODO Auto-generated method stub
		Integer [] Numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Stack<Integer> S = new ArrayStack<>();
    	Queue<Integer> Q = new ArrayQueue<>();
    	int key = 1;
    	
    	// Print the content of the stack 
 		S=buildStack(Numbers);
 		
 		//just print the stack 
 		System.out.println(S) ;
 		
 	
 		
 		if(check(S, Q, 1))
 			System.out.println("Found");
 		else 
 			System.out.println("Not Found");
 		
 		// Print the content of the stack 
 		System.out.println(S) ;

	}

}
