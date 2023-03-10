
public class Node {
	private String name;
	private Node next;
	
	public Node() {
		name=null;
		next=null;
	}
	
	public Node(String name, Node nextValue) {
		this.name=name;
		this.next=nextValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "[name=" + name + "]";
	}
}
