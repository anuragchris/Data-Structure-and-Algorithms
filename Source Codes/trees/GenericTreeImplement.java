package trees;

public class GenericTreeImplement {
    public static void main(String Args[]) {
	GenericTreeNode root = new GenericTreeNode();
	root.setData(1);
	root.firstChild = new GenericTreeNode();
	root.firstChild.setData(2);
	root.firstChild.nextSibling = new GenericTreeNode();
	root.firstChild.nextSibling.setData(3);

	GenericTreeOperations op = new GenericTreeOperations();
	// System.out.println(op.findSum(root));
	// int[] p = { -1, 0, 1, 6, 6, 0, 0, 2, 7 };
	// System.out.println(op.depthFromParentArray(p));
	// System.out.println(op.numberOfSiblings(root.firstChild));
	System.out.println(op.countChild(root));
    }

}
