//Link For Problem: https://leetcode.com/problems/search-in-a-binary-search-tree/

package trees;

public class SearchInABST {

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

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null)
			return null;

		if (root.val == val)
			return root;

		else if (root.val > val)
			return searchBST(root.left, val);

		else
			return searchBST(root.right, val);
	}


	public TreeNode iterativeSearch(TreeNode root, int val) {
		if (root == null)
			return null;

		if (root.val == val)
			return root;

		while (root != null) {
			if (root.val == val)
				return root;

			else if (root.val > val)
				root = root.left;

			else
				root = root.right;
		}

		return null;
	}
}
