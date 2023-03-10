package Ques2_Un;

/** EPOKA UNIVERSITY
 * CEN254
 * @author F.Skuka
 * 
 * Lab 4
 * Student Name	   :
 * Student Surname :
 */

public class LinkedList {
	private class Node{
		private String name;
		private String surname;
		private double amount;
		private Node next;
		
		/** Constructs a new node with the specified parameters
		 * 
		 * @param name
		 * @param surname
		 * @param amount
		 * @param nextValue
		 */
		public Node(String name,String surname, double amount, Node nextValue) {
			// Your code needs to be added here
			this.name = name ;
			this.surname = surname ; 
			this.amount = amount ; 
			this.next = nextValue ;
			
			
			
			
			
		}
	}
	
	private Node head;
	private Node tail;
	
	public LinkedList() {
		head=tail=null;
	}
	
	/** Adds a node in sorted manner according to the amount value. (Largest to smallest)
	 * 
	 * @param name
	 * @param surname
	 * @param amount
	 */
	public void add(String name,String surname, double amount) {
		// Your code needs to be added here
	
		
		// The node is added in the beginning head node is empty
		if (head==null) {
			head = new Node(name, surname, amount, head);
		}
		
		//The node is added in the beginning if amount is bigger than first head node amount 
		else if ( amount > head.amount) {
			head = new Node(name, surname, amount, head) ;
		}
		
		else {
			// this constant is used to see if amount is bigger than any amount in linked list; 
			int c= 0  ; 
			
			
			//use two node to add between them another node if amount is bigger of any of nodes 
			Node prev = head ;
			Node temp = head.next ;
			while(temp!=null) {
				//insert node if amount is bigger 
				if(amount > temp.amount) {
					prev.next= new Node(name, surname, amount, temp) ;
					c=1 ;
					break ; 
				}
				temp = temp.next ; 
				prev=prev.next ; 
			}
			//inset in the end if previous condition don't fulfill 
			if (c==0) {
				prev.next= new Node(name, surname, amount, temp) ;
			}
		}
		
		
		
		
	}
	
	/** Adds a new node to the front of the list
	 * 
	 * @param name
	 * @param surname
	 * @param amount
	 */
	
	private void add2First(String name,String surname, double amount) {
		head = new Node(name, surname, amount, head);
	}
	
	/** Adds a new node to the end of the List
	 * 
	 * @param name
	 * @param surname
	 * @param amount
	 */
	private void add2Last(String name,String surname, double amount) {
		tail = tail.next = new Node(name, surname, amount, null);
	}
	
	/** returns the previous node.
	 * 
	 * @param amount
	 * @return
	 */
	
	private Node findPrev(double amount) {
		// Your code needs to be added here
		if (head==null) return null ; 
		
		//needed two node to keep track of previous node that is equal to amount
		Node prev = head ;
		Node temp = head.next  ; 
		while (temp!=null) {
			if (temp.amount==amount) {
				return prev ; 
				
				}
			}
		return null ; 
		}
	
	
	/** Prints the entire list
	 * 
	 */
		
	public void printList() {
		Node tmp=head;
		while(tmp!=null) {
			System.out.println(tmp.name + " " + tmp.surname+" "+ tmp.amount);
			tmp=tmp.next;
		}
		
	}
	
	/** Prints the content of the first n nodes in the linked list
	 * 
	 * @param n
	 */
	public void pritntFirstN(int n) {
		// Your code needs to be added here
		
		// Used to count nr of nodes 
		int c=0 ; 
		Node tmp=head;
		while (tmp!=null && c<n) {
			System.out.println(tmp.name + " " + tmp.surname+" "+ tmp.amount);
			tmp=tmp.next;
			c++ ; 
		}
	}
	
}
