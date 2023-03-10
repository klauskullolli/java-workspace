package Questions;







public class BinarySearchTree {

	/*
	 * --Node-- The binary tree is built using this nested node class. Each node
	 * stores one data element, and has left and right sub-tree pointer which may be
	 * null. The node is a "dumb" nested class -- we just use it for storage; it
	 * does not have any methods.
	 */
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

	/**
	 * Creates an empty binary tree -- a null root pointer.
	 */
	public void BinaryTree() {
		root = null;
	}

	/**
	 * Inserts the given data into the binary tree. Uses a recursive helper.
	 */
	public void insert(int data) {
		root = insert(root, data);
	}

	/**
	 * Recursive insert -- given a node pointer, recur down and insert the given
	 * data into the tree. Returns the new node pointer (the standard way to
	 * communicate a changed pointer back to the caller).
	 */
	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else if (data < node.data)
			node.left = insert(node.left, data);
		else if (data > node.data)
			node.right = insert(node.right, data);

		return (node); // in any case, return the new pointer to the caller
	}
	
	/** Implemet your methods here.
	 * 
	 */

	//2
	public  boolean isEmpty() {
		if (root == null) return true ;
		else return false ;
		
	} 
	
	
	//3
	public void printAllOrders() {
		System.out.print("Inorder: ");
		inOrder(this.root);
		System.out.println();
		System.out.print("Preorder: ");
		preOrder(this.root);
		System.out.println();
		postOrder(this.root);
		System.out.println();
		LevelOrder(this.root);
		System.out.println();

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
	
	
	
	private void LevelOrder(Node root) {
		
		// this is needed to include every level
		int depth= maxDepth(this.root) ;
		
		//print nodes for every level
		for (int i = 1 ; i<depth  ; i++ ) {
			LevelPrint(root , i ) ;
		}
		
	}
	
	
	private void LevelPrint(Node root , int lev) {
		// Termination case of recursion 
		if (root ==null) return ;
		
		
		// case when reach required level after a decreasing by 1 each step 
		if (lev==1) 
			System.out.print( root.data + " ");
		
		// there is where required level is not reached ... recursive function is called 
		if (lev > 1) 
        { 
			LevelPrint(root.left, lev-1); 
			LevelPrint(root.right, lev-1); 
        } 
	}
	
	//8
	public int maxDepth() {
		
		//call the private max depth function 
		int i = maxDepth(this.root) ; 
		return i ; 
	}
	
	private int maxDepth(Node node) {
		
		// when reaches the end depth is 0
		if(root == null)
	            return 0;
	        else
	        {   
	        	//use recursion to calculate depth of right and left branches  
	        	
	        	int Leftdepth = maxDepth(root.left);
	            
	            int Rightdepth = maxDepth(root.right);
	            
	            // compare which branch has the highest depth 
	            
	            if(Leftdepth > Rightdepth)
	                return (Leftdepth + 1);
	            else return (Rightdepth + 1);
	        }
	}
	
	
	
	//4
	public int minValue() {
		int i ;
		
		// call private function 
		i = minValue(this.root) ;
		return i ;
	
	}
	

	private int minValue(Node node) {
	
		//while node is different from null
		// Iterate till we reach the most left node
		while (node.left != null)
			node = node.left;
		return node.data;	
		}
	
	
	
	//5
	public int maxValue() {
        int i ;
		
		// call private function 
		i = maxValue(this.root) ;
		return i ;
	}


	private int maxValue(Node node) {

		//while node is different from null
		// Iterate till we reach the most right node
		while (node.right != null)
			node = node.right;
		return node.data;	
		}

	
	
	//6
    public int size() {
     	
    	// call the private function with parameter root 
        int i = size(this.root) ;
        return i ;
    }
    
    
	private int size(Node node) {
		
		// base case of recursion 
		if (node==null) return 0 ; 
		
		// each time it is passed to a new node is added by 1
		return size(node.left) + 1 + size(node.right) ;
	}

	
	
	//7
	public boolean find(int data) {
		return find(this.root , data) ;
	}

	private boolean find(Node node, int data) {
		
		// reach the leaf of bst and dont find data 
	   if (node == null)
		        return false;
		 
		
	   // if data is found  
	   if (node.data == data)
		        return true;
		 
        // for every node check if is a data equal to inputed data 
	    boolean c = find(node.left, data);
		   
		//if found from left branch return and terminate recursion 
	    if(c) return true;
		 
	    boolean c1 = find(node.right, data);
		 
	  //if found from right branch return and terminate recursion 
	    return c1;
	}
	
	
	//9
	public boolean isBST() {
		int max = this.maxValue() ;
		int min  = this.minValue() ;
		return  isBST(this.root , max ,min) ;
	}
	
	
	private boolean isBST(Node node, int max , int min) {
		
		// Base case. An empty tree is a BST.
		if (node == null)
			return true;
		// Checking if a key is outside the permitted range.
		if (node.data < min)
			return false;
	  if (node.data > max)
			return false;
		// Sending in updates ranges to the right and left subtree
		return isBST(node.right, node.data, max) && 
	  isBST(node.left, min, node.data);	
	}
	
	
	
	//11
	public void deleteNode(int key) {
		this.root = deleteNode(root, key) ;
	}
	private Node deleteNode(Node root, int key) {
	
		
		// base case of recursion
        if (root == null)
            return root;
 
        // reach in tree branches using order 
        //if key smaller than data proceed in left branch  
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        //if if key bigger  than data proceed in right branch  
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
 
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.data = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }
 
        return root;
	}
	
	}

	



