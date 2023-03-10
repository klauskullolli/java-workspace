package Average_Depth;


import java.util.*;


import java.io.*;

class Node {
	int val;
	Node left, right;

	Node(int v) {
		val = v;
		left = right = null;
	}
}


public class solver {
	
	//this static value is needed to count number of nodes inserted 
	//needed later on to calculate average depth 
	public static int node_nr = 0 ;

	static Node Insert(int v, Node top) {
		if (top == null) {
			top = new Node(v);
			
		}
		else if (top.val < v) {
			top.right = Insert(v, top.right);
			
		}
		else if (top.val > v) {
			top.left = Insert(v, top.left);
			
		}

		return top;
	}

	
	public  static Node FindMin(Node T) {
		if (T == null)
			return null;
		if (T.left == null)
			return T;
		return FindMin(T.left);
	}

	public static  Node FindMax(Node T) {
		if (T == null)
			return null;
		while (T.right != null)
			T = T.right;
		return T;
	}
	
	
	//this is the function that calculate the sum of depths of all nodes
	public static int totalDepth(Node node, int depth) 
	{
	    if(node == null) 
	    {
	        return 0;
	    }
        
	    node_nr ++ ;
	    
	    //call the recursive function till the end of node 
	    return depth                            
	     + totalDepth(node.left, depth + 1)   
	     + totalDepth(node.right, depth + 1); 
	}


	public static void main(String[] args) throws IOException {
		//Scanner in = new Scanner(new FileReader("input.txt")); // 
		Scanner in = new Scanner(System.in); 
		int num, n = in.nextInt();
		
		Node root = null;

		//input BST elements 
		for (int i = 0; i < n; i++) {
			num = in.nextInt();
			root = Insert(num, root);
		}
		
	   //print the average depth using totalDepth / node_nr
	   System.out.println(Double.valueOf(totalDepth(root, 0))/node_nr);
		
		
		

	}

}