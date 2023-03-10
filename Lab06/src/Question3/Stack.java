package Question3;

import java.util.LinkedList;

public class Stack<E> {
	
	private LinkedList<E> stack = new LinkedList<>() ;
	
	public Stack() { } 
	
	public int size() { return stack.size(); }
	
	
	public boolean isEmpty() { return stack.isEmpty(); }
	
	public void push(E element) { stack.addFirst(element); }
	
	public E pop() { return stack.removeFirst(); }
	
	public E top() { return stack.getFirst(); }
	
	public String toString() {
	    return stack.toString();
	  }

}
