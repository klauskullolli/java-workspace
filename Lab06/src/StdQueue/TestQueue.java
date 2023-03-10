package StdQueue;
 
import java.util.NoSuchElementException; 

public class TestQueue {
	  public static void main(String[] args) {
	    java.util.Queue<Integer> Q = new java.util.LinkedList<>() ;
	    
	      Q.add(5);;                         // contents: (5)
		  Q.add(3);                          // contents: (3 ,5)
		  System.out.println(Q.size());          // contents: (3 ,5)     outputs 2
		  System.out.println(Q.remove());       // contents: (3)        outputs 5
		  System.out.println(Q.isEmpty());       // contents: (3)        outputs false
		  System.out.println(Q.remove());       // contents: (3)         outputs 5
		  System.out.println(Q.isEmpty());       // contents: ()         outputs true
		  System.out.println(Q.remove());       // contents: ()         outputs NoSuchElementException
		  Q.add(7);                          // contents: (7)
		  Q.add(9);                          // contents: (9, 7)
		  System.out.println(Q.element());         // contents: (9, 7)     outputs 7
		  Q.add(4);                          // contents: (7, 9, 4)
		  System.out.println(Q.size());          // contents: (7, 9, 4)  outputs 3
		  System.out.println(Q.element());         // contents: (7, 9, 4)    outputs 7
		  Q.add(6);                          // contents: (6, 7, 9, 4) 
		  Q.add(8);                          // contents: (8,6,7, 9, 4) 
		  System.out.println(Q.remove());       // contents: (6,7, 9, 4)  outputs 8
		  System.out.println(Q.size());          // contents: (6,7, 9, 4)  outputs 4
	    
	}
	  
	  
}

   