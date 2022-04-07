//Link For Problem: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

package trees;

public class BST_FromPreOrder {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	int i = 0;

	public TreeNode bstFromPreorder(int[] preorder) {
		return buildBST(preorder, Integer.MAX_VALUE);
	}

	public TreeNode buildBST(int preOrder[], int bound) {
		if (i == preOrder.length || preOrder[i] > bound)
			return null;

		TreeNode root = new TreeNode(preOrder[i++]);

		root.left = buildBST(preOrder, root.val);
		root.right = buildBST(preOrder, bound);

		return root;
	}

	public static void main(String[] args) {
		BST_FromPreOrder bst = new BST_FromPreOrder();
		int preOrder[] = { 8, 5, 1, 7, 10, 12 };
		TreeNode root = bst.bstFromPreorder(preOrder);
		System.out.println(root.val);
	}
}
