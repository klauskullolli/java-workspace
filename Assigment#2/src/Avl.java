import java.util.ArrayList;

public class Avl {
	
	
	private class Node{
		int value;
		Node left, right;
		public int data;
		
		Node(int value){
			this.value=value;
			this.left=null;
			this.right=null;
		}
	}
	
	 Node root;
	 
	 Avl(){
		 this.root=null;
	 }
	 
	 //a)
	 // count number of nodes using recursion 
	 private int NrOfNodes(Node node) {
		 if(node==null) 
			 return 0 ;
		 
		 return NrOfNodes(node.left) + NrOfNodes(node.right) + 1 ;
	 }
	 
	 //create public function with same name and call recursive one because we can use it as a instance of avl class
	 public int NrOfNodes() {
		 return NrOfNodes(this.root);
	 }
	 
	 
	 
	 //b)
	 //maximum height of n given nodes 
	 public int maxHeight(int n) {
		 
		 return n-1 ;
	 }
	 
	 
	 //minimum height of n given nodes in a binary tree 
	 public int minHeight (int n) {
		 return (int) (Math.floor(Math.log(n)/Math.log(2))) ;
	 }
	 
	 
	 //c)
	 private ArrayList<Node> array = new ArrayList() ;
	 
	 //this is a function that convert a tree into a array in inorder way 
	 private void list(Node node) {
		 
		 if(node==null)
			 return  ;
		 list(node.left);
		 	array.add(node) ;
		 list(node.right);
	 }
	 
	
	 //return predecessor
	 public Node predecessor(Node node) {
		 //array convention of tree
		 list(root);
		 //if is equal to root return null means no predecessor.
		 if (node.data==array.get(0).data) 
			 return null ;
		 
		 for (int i=1; i< this.array.size(); i++ ) {
			 if(array.get(i).data==node.data)
				 return array.get(i-1) ;
		 }
		 
		 //if not in array 
		 return null ;
	 }
	 
	 public Node successor(Node node) {
		//array convention of tree
		 list(root);
		
		 
		 for (int i=1; i< this.array.size(); i++ ) {
			 if(array.get(i).data==node.data) 
				 return array.get(i+1) ;
		 }
		 
		 // if not in array
		 return null ;
	 }
	 
	 
	 //d)
	 //function of height used as a instance of class
	 //using recursion of private maxHeigt function 
	 public int max_Heigt() {
			
		
			int i=max_Heigt(this.root); 
			return i ; 
		}
		
	
	 //recursive function of height of a binary tree node
		private int max_Heigt(Node node) {
			
			//base case
			if(root==null)
		            return 0;
		        else
		        {    
		        	//find left and right height using recursion 
		        	int Left=max_Heigt(root.left);
		            
		            int Right=max_Heigt(root.right);
		            
		            //compare which branch has the highest height
		            
		            if(Left > Right)
		                return (Left + 1);
		            else return (Right + 1);
		        }
		}
		
		//use as the instance of class calling the recursive function with the same name 
		public boolean sizeBalanced() {
			return sizeBalanced(root) ;
		}
		
		
		//boolean function that find if tree is balanced or no 
		private  boolean sizeBalanced(Node node) {
			
			//base case that reach the end of node so is balanced because has height 0
			if(node == null) return true ; 
			
			//case where is balanced with balance factor 0, 1 , -1
			if (max_Heigt(node.left)-max_Heigt(node.right)==1 ||max_Heigt(node.left)-max_Heigt(node.right)==0 || max_Heigt(node.left)-max_Heigt(node.right)==-1) return true ;
			
			
			//recursive call
			return sizeBalanced(node.left) && sizeBalanced(node.right) ;
		}
	 

public static void main(String[] args) {
          Avl tree = new Avl() ;
         
}
}