class LinkedList<T> {
  Node head;

  // Node class
  class Node <T> {
    T value;
    Node next;

    public Node(T value){
      this.value = value;
      this.next  = null;
    }
  }

  void insert_begging(T value){
    Node newHead  = new Node<T>(value);

    newHead.next  = head;
    head          = newHead;
  }

  void insert_end(T value){
    Node<T> newHead = new Node<T>(value);
    Node last 		= head;

    while(last.next != null){
      last = last.next;
    }
    last.next = newHead;
  } 

  void print(){
    Node temp = head;

    while(temp != null){
      System.out.println(temp.value);
      temp = temp.next;
    }
  }
  
  int count() {
	  int cnt = 0;
	  
	  Node temporary = head;
	  
	  while(temporary != null) {
		  cnt++;
		  temporary = temporary.next;
	  }
	  return cnt;
  }
  
  void removeLast() {
	  if(head == null)
		  return;
	  
	  if (head.next == null) {
		head = null;
		return;
	  }
	  
	  Node temporary = head;
	  
	  while (temporary.next.next != null) {
		temporary = temporary.next;
	  }
	  
	  temporary.next = null;
  }
  
  T getNth(int index) {
	  int position = 0;
	   
	  Node temporay = head;
	  
	  while(temporay != null && position < index) {
		  temporay = temporay.next;
		  position++;
	  }
	  
	  if (position == index)
		return (T) temporay.value;
	
	  return null;
  }
  
  boolean exist(T element) {
	  Node temporary = head;
	  
	  while(temporary != null) {
		  if (temporary.value.equals(element)) {
			return true;
		  }
		  temporary = temporary.next;
	  }
	  return false;
  }
  
  void assignFifth() {
	  Node temporaryNode = head;
	  int counter = 0;
	  
	  while(counter < 4 && temporaryNode != null) {
		  temporaryNode = temporaryNode.next;
	  }
	  
	  if(temporaryNode != null) {
		  temporaryNode.value = 10;
	  }
  }
}