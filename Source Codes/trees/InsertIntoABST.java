//Link For Problem: https://leetcode.com/problems/insert-into-a-binary-search-tree/

package trees;

public class InsertIntoABST {

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

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
			root.left = null;
			root.right = null;
			return root;
		}

		else if (root.val > val)
			root.left = insertIntoBST(root.left, val);

		else
			root.right = insertIntoBST(root.right, val);

		return root;
	}

	//Iterative Solution
	public TreeNode iterativeInsert(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
			root.left = null;
			root.right = null;
			return root;
		}

		TreeNode current = root;
		if (val < root.val) {
			while (current != null) {
				if (val < current.val) {

					if (current.left == null)
						break;

					else
						current = current.left;
				}
				if (val > current.val) {

					if (current.right == null)
						break;

					else
						current = current.right;
				}
			}
		}

		if (val > root.val) {
			while (current != null) {
				if (val > current.val) {

					if (current.right == null)
						break;

					else
						current = current.right;
				}
				if (val < current.val) {

					if (current.left == null)
						break;

					else
						current = current.left;
				}
			}
		}

		if (current.left == null && val < current.val)
			current.left = new TreeNode(val);

		else
			current.right = new TreeNode(val);

		return root;
	}
}
