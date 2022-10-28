//Link For Problem: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

package trees;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

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

	public void flatten(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> st = new Stack<>();
		st.push(root);

		while (!st.isEmpty()) {
			TreeNode current = st.pop();

			if (current.right != null)
				st.push(current.right);

			if (current.left != null)
				st.push(current.left);

			if (!st.isEmpty())
				current.right = st.peek();

			current.left = null;
		}
	}

	TreeNode prev = null;

	public void flattenRecursive(TreeNode root) {
		if (root == null)
			return;

		flattenRecursive(root.right);
		flattenRecursive(root.left);

		root.right = prev;
		root.left = null;
		prev = root;
	}
}
