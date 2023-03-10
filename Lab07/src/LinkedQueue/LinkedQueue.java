package LinkedQueue;

public class LinkedQueue<E> implements Queue<E> {
 
  /** The primary storage for elements of the queue */
  private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty  list

  /** Constructs an initially empty queue. */
  public LinkedQueue() { }                  // new queue relies on the initially empty list

  /**
   * Returns the number of elements in the queue.
   * @return number of elements in the queue
   */
  @Override
  public int size() { return list.size(); }
 
  /**
   * Tests whether the queue is empty.
   * @return true if the queue is empty, false otherwise
   */
  @Override
  public boolean isEmpty() { return list.isEmpty(); }

  /**
   * Inserts an element at the rear of the queue.
   * @param element  the element to be inserted
   */
  @Override
  public void enqueue(E element) { list.addLast(element); }

  /**
   * Returns, but does not remove, the first element of the queue.
   * @return the first element of the queue (or null if empty)
   */
  @Override
  public E first() { return list.first(); }

  /**
   * Removes and returns the first element of the queue.
   * @return element removed (or null if empty)
   */
  @Override
  public E dequeue() { return list.removeFirst(); }

  /** Produces a string representation of the contents of the queue.
   *  (from front to back). This exists for debugging purposes only.
   */
  public String toString() { 
    return list.toString();
  }
  
  
  /** Demonstrates sample usage of a stack. */
  public static void main(String[] args) {
	  LinkedQueue<Integer> Q = new LinkedQueue<>();// contents: ()
	   
	  Q.enqueue(5);;                         // contents: (5)
	  Q.enqueue(3);                          // contents: (3 ,5)
	  System.out.println(Q.size());          // contents: (3 ,5)     outputs 2
	  System.out.println(Q.dequeue());       // contents: (3)        outputs 5
	  System.out.println(Q.isEmpty());       // contents: (3)        outputs false
	  System.out.println(Q.dequeue());       // contents: (3)         outputs 5
	  System.out.println(Q.isEmpty());       // contents: ()         outputs true
	  System.out.println(Q.dequeue());       // contents: ()         outputs null
	  Q.enqueue(7);                          // contents: (7)
	  Q.enqueue(9);                          // contents: (9, 7)
	  System.out.println(Q.first());         // contents: (9, 7)     outputs 7
	  Q.enqueue(4);                          // contents: (7, 9, 4)
	  System.out.println(Q.size());          // contents: (7, 9, 4)  outputs 3
	  System.out.println(Q.first());         // contents: (7, 9, 4)    outputs 7
	  Q.enqueue(6);                          // contents: (6, 7, 9, 4) 
	  Q.enqueue(8);                          // contents: (8,6,7, 9, 4) 
	  System.out.println(Q.dequeue());       // contents: (6,7, 9, 4)  outputs 8
	  System.out.println(Q.size());          // contents: (6,7, 9, 4)  outputs 4
  }
}
