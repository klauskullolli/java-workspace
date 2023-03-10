package SumLeaves;


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
	
	
	//this static integer is needed to calculate the sum of leaf nodes
	public static int sum = 0 ;

	static Node Insert(int v, Node top) {
		if (top == null)
			top = new Node(v);
		else if (top.val < v)
			top.right = Insert(v, top.right);
		else if (top.val > v)
			top.left = Insert(v, top.left);

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
	
	
	//this is the function that calculate leaf node sum
	public static void leaf_sum (Node node ) {
		
		//if node is null the recursion is terminated 
		if(node == null) return ;
		
		//if reaches the leaf add the leaf value to the sum
		if(node.left==null && node.right==null) {
			sum=sum+node.val ;
			
		}
		//call the recursive function
		leaf_sum(node.left);
		leaf_sum(node.right);
		
		
	}

	public static void main(String[] args) throws IOException {
		//Scanner in = new Scanner(new FileReader("input.txt")); // 
		Scanner in = new Scanner(System.in); 
		int num, n = in.nextInt();
		
		Node root = null;

		for (int i = 0; i < n; i++) {
			num = in.nextInt();
			root = Insert(num, root);
		}
		
	/*	Node MaxNode=FindMax(root);
		System.out.println("Max is: "+ MaxNode.val);
		Node MinNode=FindMin(root);
		System.out.println("Min is: "+ MinNode.val);*/
		
	 
		//call the function
		leaf_sum(root);
		
		//print the sum
		System.out.println(sum);
		
		

	}

}