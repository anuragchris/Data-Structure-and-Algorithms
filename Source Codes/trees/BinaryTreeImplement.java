package trees;

public class BinaryTreeImplement {
    public static void main(String Args[]) {
	BinaryTreeTraversal tree = new BinaryTreeTraversal();
	tree.root = new BinaryTreeNode(1);
	tree.root.left = new BinaryTreeNode(2);
	tree.root.right = new BinaryTreeNode(3);
	tree.root.right.left = new BinaryTreeNode(8);
	tree.root.left.left = new BinaryTreeNode(5);
	tree.root.right.right = new BinaryTreeNode(4);

	BinaryTreeTraversal tree2 = new BinaryTreeTraversal();
	tree2.root = new BinaryTreeNode(1);
	tree2.root.left = new BinaryTreeNode(2);
	tree2.root.right = new BinaryTreeNode(3);
	tree2.root.left.left = new BinaryTreeNode(5);
	tree2.root.right.right = new BinaryTreeNode(4);
	tree2.root.right.right.right = new BinaryTreeNode(8);
	// tree.preOrderTraversal(tree.root);
	// tree.iterativePreOrderTraversal(tree.root);
	// tree.inOrderTraversal(tree.root);
	tree.inOrderTraversalWithoutRecursion(tree.root);
	// tree.postOrderTraversal(tree.root);
	// tree.postOrderTraversalWithoutRecursion(tree.root);
	// tree.postOrderTraversalUsingOneStack(tree.root);
	// LargestElement le = new LargestElement();
	// System.out.println(le.usingRecursion(tree.root));
	// System.out.println(le.withoutRecursion(tree.root));
	BinaryTreeOperations operations = new BinaryTreeOperations();
	// System.out.println(operations.searchingUsingRecursion(tree.root, 8));
	// System.out.println(operations.searchingWithoutRecursion(tree.root, 8));
	// operations.insertingElement(tree.root, 10);
	// System.out.println(operations.sizeUsingRecursion(tree.root));
	// System.out.println(operations.sizeWithoutRecursion(tree.root));
	// operations.levelOrderTraversalInReverse(tree.root);
	// System.out.println(operations.heightUsingRecursion(tree.root));
	// System.out.println(operations.heightUsingIteration(tree.root));
	// System.out.println(operations.minimumDepth(tree.root));
	// operations.deepestNode(tree.root);
	// System.out.println(operations.getLeafCount(tree.root));
	// System.out.println(operations.numberOfLeafsWithoutRecursion(tree.root));
	// System.out.println(operations.numberOfFullNodesWithoutRecursion(tree.root));
	// System.out.println(operations.NumberOfFullNodesUsingRecursion(tree.root));
	// System.out.println(operations.structurallyIdentical(tree.root, tree2.root));
	// System.out.println(operations.diameter(tree.root));
	// if (operations.isomorphic(tree.root, tree2.root)) {
	// System.out.println("Isomorphic");
	// } else {
	// System.out.println("Not Isomorphic");
	// }
	// System.out.println(operations.quasiIsomorphic(tree.root, tree2.root));
	// operations.toDLL(tree.root);
    }
}
