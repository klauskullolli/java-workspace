package Question1;

import LinkedQueue.LinkedQueue;
import LinkedQueue.Queue;

public class Solver {

	public static void main(String[] args) {
		Queue<Integer > q1 = new LinkedQueue<>() ;
		
		//just add the instruction according to the exercise in pdf
		// to see the queue content just use println()
		
		q1.enqueue(5);
		System.out.println(q1);
		q1.enqueue(3);
		System.out.println(q1);
		q1.dequeue();
		System.out.println(q1);
		q1.enqueue(2);
		System.out.println(q1);
		q1.enqueue(8);
		System.out.println(q1);
		q1.dequeue() ;
		System.out.println(q1);
		q1.dequeue();
		System.out.println(q1);
		q1.enqueue(9);
		System.out.println(q1);
		q1.enqueue(1);
		System.out.println(q1);
		q1.dequeue() ;
		System.out.println(q1);
		q1.enqueue(7);
		System.out.println(q1);
		q1.enqueue(6);
		System.out.println(q1);
		q1.dequeue() ; 
		System.out.println(q1);
		q1.dequeue() ;
		q1.enqueue(4);
		System.out.println(q1);
		q1.dequeue() ;
		System.out.println(q1);
		q1.dequeue() ;
		System.out.println(q1);
		
	}

}
