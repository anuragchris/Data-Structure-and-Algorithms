package trees;

public class BinarySearchTreeImplement {
	public static void main(String args[]) {
		BinarySearchTreeOperation tree = new BinarySearchTreeOperation();

		tree.root = new BinarySearchTreeNode(6);
		tree.root.left = new BinarySearchTreeNode(5);
		tree.root.right = new BinarySearchTreeNode(7);
		tree.root.left.left = new BinarySearchTreeNode(4);
		tree.root.right.right = new BinarySearchTreeNode(8);
		tree.root.right.right.right = new BinarySearchTreeNode(9);
		tree.root.right.right.right.right = new BinarySearchTreeNode(12);
		tree.root.right.right.right.right.left = new BinarySearchTreeNode(11);
		// System.out.println(tree.search(tree.root, 5).data);
		// System.out.println(tree.searchWithoutRecursion(tree.root, 5).data);
		// System.out.println(tree.minimumElement(tree.root).getData());
		// System.out.println(tree.minimumElementWithRecursion(tree.root).data);
		// System.out.println(tree.inOrderPredecessor(tree.root, null, 6).data);
		// tree.insertElement(tree.root, 10);
		// tree.insertElement(tree.root, 9);
		// // tree.inOrderTraversal(tree.root);
		// tree.insertElementWithoutRecursion(tree.root, 10);
		// tree.insertElementWithoutRecursion(tree.root, 1);
		// tree.inOrderTraversal(tree.root);
		// System.out.println(tree.LCA(tree.root, 8, 7).getData());
		// System.out.println(tree.shortestPath(tree.root, 8, 4));
		// System.out.println(tree.distanceFromRoot(tree.root, 4));
		// System.out.println(tree.verifyBST(tree.root));
		// System.out.println(tree.verifyBSTwithTraversal(tree.root));
		// System.out.println(tree.KthSmallestElement(tree.root, 4, 0).getData());
		// System.out.println(tree.floor(tree.root, 9).getData());
		// System.out.println(tree.ceil(tree.root, 5).getData());
		//	tree.printInRange(tree.root, 2, 11);

		tree.allPairsWithGivenSum(tree.root, 12);
	}
}
