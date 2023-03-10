
public class LinkedList {
	private Node head;

	public LinkedList() {
		head = null;
	}

	void add(String name) {
		
		head = new Node(name, head);
		
	}

	/**
	 * Removes the head node and returns true if the list contains at least one
	 * node. Returns false if the list is empty.
	 */
	public boolean deleteFirstNode() {

		// Your code needs to be added here
		if(head == null) return false ;
		
		else {
			head=head.getNext() ;
			
			return true;
		}
		
	}

	/**
	 * Returns the number of nodes in the list.
	 */
	public int size() {
		// Your code needs to be added here
		
		//used to count number of nodes 
		int c = 0 ; 
		
		//this temp node used not to change position of head node
		Node temp = head ;
		while (temp!=null) {
			c++ ; 
			temp.getNext() ;
		}
		
		
		
		return c;
	}

	public boolean contains(String item) {
		return (find(item) != null);
	}

	/**
	 * Finds the first node containing the target item, and returns a reference to
	 * that node. If target is not in the list, null is returned.
	 */
	private Node find(String target) {
		Node position = head;
		String itemAtPosition;
		while (position != null) {
			itemAtPosition = position.getName();
			if (itemAtPosition.equals(target))
				return position;
			position = position.getNext();
		}
		return null; // target was not found
	}

	
	public boolean deleteNode(String target) {
		// Your code needs to be added here
		
		//if empty can not delete
		if (head==null) return false ;  
		
		
		else {
			Node temp = head ;
			Node temp2=head.getNext() ;
			
			if (temp.getName()==target) {
				head=temp.getNext()  ;
			}
			
			
			while (temp2!= null ) {
				
				// Delete node that contain that string 
				if( temp2.getName() ==target) {
					temp.setNext(temp2.getNext()) ;
					return true ;
				}
				temp2=temp2.getNext() ;
				temp= temp.getNext() ;
			}
			
			// there is not such string to delete
			return false;}
	}
	

	void print() {
		//Use that temp not to change position of head node
		Node temp = head ;
		// Iterate over all nodes and print data of each of them 
		while (temp != null ) {
			System.out.println(temp);
			temp= temp.getNext() ;
		}
	}
}
