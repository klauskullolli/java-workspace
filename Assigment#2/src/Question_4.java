
public class Question_4 {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree() ;
		tree.insert(4);
		tree.insert(2);
		tree.insert(9);
		
		tree.printAllOrders();
		
		System.out.println(tree.nr_nodes());
		
		//tree.insert(12);
		//tree.insert(11);
		tree.updateOrInsert(9);
		tree.printAllOrders();
		System.out.print(tree.exist_sum(7));
		
		
	}

}
