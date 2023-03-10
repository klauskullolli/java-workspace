

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
		private Node insert(Node node, int data ) {
			//Base case when end is reached can and a node
			if (node == null) {
				node = new Node(data);
			
				} 
			
			//Continue left if data < than current node data 
			else if (data < node.data)
				node.left = insert(node.left, data);
			
			//continue right if  data > than current node data
			else if (data > node.data)
				node.right = insert(node.right, data);

			return node; 
		}
		
		
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
		
		//find if BTS is balanced by calling recursive function with the same name
		public boolean sizeBalanced() {
			return sizeBalanced(root) ;
		}
		
		
		//find if a node is balanced or no using recursion 
		private  boolean sizeBalanced(Node node) {
			
			if(node == null) return true ; 
			
			if (maxDepth(node.left)-maxDepth(node.right)==1 ||maxDepth(node.left)-maxDepth(node.right)==0 || maxDepth(node.left)-maxDepth(node.right)==-1) return true ;
			
			return sizeBalanced(node.left) && sizeBalanced(node.right) ;
		}
		
}
