import java.lang.Math;
import java.util.Scanner;






public class BinarySearchTree {
	
	//node is a class that represent a binary tree with data and left and right nodes 
	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int newData) { 
			left = null;
			right = null;
			data = newData;
		}
	}
	
	// Root node pointer. Will be null for an empty tree.
	private Node root;
	
	//constructor of binary serch tree class 
	public void BinaryTree() {
		root = null;
	}
	
	
	//this is an insert method that calls the recursive function insert 
	public void insert (int data) {
		root = this.insert(root ,data) ;
	}
	
	//is private firstly that only is accessed inside class
	//is a recursive function that follows the rules of a BTS insertion 
	private Node insert(Node node, int value ) {
		//Base case when end is reached can and a node
		if (node == null) {
			node = new Node(value);
		
			} 
		
		//Continue left if data < than current node data 
		else if (value < node.data)
			node.left = insert(node.left, value);
		
		//continue right if  data > than current node data
		else if (value > node.data)
			node.right = insert(node.right, value);

		return node; 
	}
	
	
	
	
	//A
	// this is a function that access recursive function with the same name 
	public int nr_nodes() {
		return nr_nodes(this.root) ;
	}
	
	//A
	// recursive function that count number of nodes 
	public  static int nr_nodes(Node node) {
		
		//base case when leafs are reached 
		if (node==null) return 0;
		
		// each time a new node is reached add by one to count nr of nodes
		return 1 + nr_nodes(node.left) + nr_nodes(node.right) ;
	}
	
	
	//B
	// is a function that count maximum height and minimum height for a binary tree and minimum height for a given number of nodes 
	//return type is a class named Pair 
	public Pair max_min(int n) {
		
		int max_height = n-1 ; 
		int min_height =(int)  Math.floor(Math.log(n)/Math.log(2)) ;
		
		return new Pair(max_height , min_height) ;
	}
	
	
	//C)
	// call the function that is recursive with the same name 
	//so is used as a methode accessed easier by a BTS objec 
	public void updateOrInsert(int data) {
		this.root = updateOrInsert(root, data) ;
	}
	
	
	//C)
	//This int is just needed to check if a new node is added or no in BTS
	private int c=0 ;
	
	//This is the function that update node if is same as a node that is inserted 
	private Node updateOrInsert( Node node , int data  ) {
		if (node == null) {
			node = new Node(data);
		    c=1 ;
			} 
		else if (data < node.data)
			node.left = insert(node.left, data);
		else if (data > node.data)
			node.right = insert(node.right, data);
		
		// check if node is not inserted 
		if(c==0) {
			// add other value and repeat the insertion recursion 
			Scanner input = new Scanner(System.in) ;
			System.out.format("Insert other value because %d exist in tree: " , data);
			int d = input.nextInt() ;
			input.close();
			node = insert(node, d) ;
		}
		return node; 
	}
	
	
	//D)
	//this function check if a specific value exist in BTS
	public static Boolean is_equal_value ( Node rootNode , int k) {
		
		//base case if leaf is reached 
		if(rootNode==null) return false ;
		// if data exist
		if (rootNode.data== k) return true ;
		
		// call recursively till it reach end or if data exist 
		return is_equal_value(rootNode.left, k) || is_equal_value(rootNode.right, k) ;
		
	}
	
	// this recursive function find if exist a couple of number that have given sume
	public static Boolean exist_sum( Node rootNode  , int  k) {
		
		// if leaf is reach means is not find 
		if (rootNode==null) return false ;
		
		// for every number in node find if exist an other one that is sum - number
		if (is_equal_value(rootNode, k-rootNode.data)) return true ;
		
		//call it recursively 
		return exist_sum(rootNode.left, k) || exist_sum(rootNode.right, k) ;
	}
	
	// this is used to be access direcely from a bts object 
	public Boolean exist_sum(int k) {
		return exist_sum(root, k) ;
	  }
	
	
	
	private void inOrder(Node root){
		if (root==null) return ;
		inOrder(root.left); 
		
		System.out.print(root.data + " ");
		
		inOrder(root.right);
		
		 
		
	}
	
	
	
	private void preOrder(Node root) {
		 if (root==null) return ;
			
		 System.out.print(root.data + " "); 
		 inOrder(root.left); 
		 inOrder(root.right);
	}
	
	private void postOrder(Node root) {
		
		if (root==null) return ;
		
		inOrder(root.left); 
		inOrder(root.right);
		System.out.print(root.data + " "); 
	}
	
	
	public void printAllOrders() {
		System.out.print("Inorder: ");
		inOrder(this.root);
		System.out.println();
		System.out.print("Preorder: ");
		preOrder(this.root);
		System.out.println();
		System.out.print("Postorder: ");
		postOrder(this.root);
		System.out.println();
		
	}
	
	
	Node leftRotate(Node a) {
		Node y = a.right ;
		Node t = y.left ;
		y.left = a ;
		a.right=t ;
		return y ;
	}
	
	// this is a recursive function that check if 2 binary trees are eaual 
	private Boolean equalTree (Node a , Node b) {
		
		//base case here reach the end of node and are both null return true 
		if(a==null && b==null) return true ;
		
		// if one null and the other and one not return false
		if (a==null || b==null) return false ;
		
		
		// check if node data are equal and continue to next leafs left and right recursively 
		return a.data==b.data && equalTree ( a.left , b.left) && equalTree (a.right , b.right) ;
	}
	
	
	public boolean isSubtree(Node a , Node b) {
		
		// if subtree is null means that all null nodes are subtrees
		if(b==null) return true ;
		//but if tree is null means that don't have subtrees
		if(a==null) return false ;
		
		
		//if the are equal return true
		if (equalTree(a ,b)) return true ;
		
		// check recursively every node of the tree to find the sub tree
		return isSubtree(a.left, b) || isSubtree(a.right, b) ; 
	}
	
}






