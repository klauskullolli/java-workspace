package Questions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {

	
	//1
	public static BinarySearchTree biuldTree() {
		
		// create a tree object
		BinarySearchTree tree1 = new BinarySearchTree();
		
		Scanner input  = new Scanner("input.txt") ;
		
		int n = input.nextInt() ;
		
		// insert element in the tree 
		for ( int i=0 ; i<n ; i++) {
			tree1.insert(input.nextInt());
		}
		
		input.close();
		return tree1 ;
	}

	public static void main(String[] args) throws FileNotFoundException {
		/** 
		 * DO NOT CHANGE THE MAIN METHO
		 */

		/** 
        //Question 1
		BinarySearchTree tree1 = new BinarySearchTree();
		 */

		
		/** 
        //Question 2
		if (tree1.isEmpty())
			System.out.println("Tree is empty.");
		else
			System.out.println("Tree is not empty.");
		

		tree1 = biuldTree();

		if (tree1.isEmpty())
			System.out.println("Tree is empty.");
		else
			System.out.println("Tree is not empty.");
			*/

		
		
		
		/** 
        //Question 3
		tree1.printAllOrders();
		*/

		
		
		
		
		/** 
        //Question 4
		System.out.println("\nMin value is: " + tree1.minValue());
		*/
		
		
		
		/** 
        //Question 5
		System.out.println("\nMax vale is: " + tree1.maxValue());
		*/
		
		
		
		/** 
        //Question 6
		System.out.println("\nThe size of the tree is: " + tree1.size());
		*/
		
		
		
		
		/** 
        //Question 7

		int key = 8;
		if (tree1.find(key))
			System.out.println("The number " + key + " is found");
		else
			System.out.println("The number " + key + " is not found");
			*/
		
		
		
		
		/**
        //Question 8
		
		System.out.println("\nMax depth of the tree is: " + tree1.maxDepth());
		*/
		
		
		
		/** 
        //Question 9
		if (tree1.isBST())
			System.out.println("This is binary search tree.");
		else
			System.out.println("This is not binary search tree");
			*/
		
		
		
		/** 
        //Question 10
		BinarySearchTree tree2 = biuldTree();

		if (tree1.isSameBST(tree2))
			System.out.println("They are the same.");
		else
			System.out.println("They are not the same.");

		tree2.insert(50);

		if (tree1.isSameBST(tree2))
			System.out.println("They are the same.");
		else
			System.out.println("They are not the same.");
			*/

		
		
		
		/** 
        //Question 11
		int num = 5;
		tree1.deleteNode(num);
		tree1.printAllOrders();
		

		while (!tree1.isEmpty()) {
			tree1.deleteNode(tree1.minValue());
			tree1.printAllOrders();
		}
		
		*/

	}

}
