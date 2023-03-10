
public class BTS {
	
	class Node {
		Node left;
		Node right;
		int data;

		Node(int newData) { 
			left = null;
			right = null;
			data = newData;
		}
		}
	
	
	
	static Node root ; 
	
	
	//A
	
	//
	public  static int node_count(Node node) {
		
	
		if (node==null) return 0;
		
		
		return 1 + node_count(node.left) + node_count(node.right) ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
