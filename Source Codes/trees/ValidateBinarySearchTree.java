//Link For Problem: https://leetcode.com/problems/validate-binary-search-tree/

package trees;

public class ValidateBinarySearchTree {
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

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;

		return checkBST(root, null, null);
	}

	static boolean checkBST(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null)
			return true;

		if (min != null && root.val <= min.val)
			return false;

		if (max != null && root.val >= max.val)
			return false;

		return checkBST(root.left, min, root) && checkBST(root.right, root, max);
	}
}
