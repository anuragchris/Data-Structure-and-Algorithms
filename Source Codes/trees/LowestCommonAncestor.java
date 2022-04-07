//Link For Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

package trees;

public class LowestCommonAncestor {

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

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val == p.val || root.val == q.val)
			return root;

		if (root.left == null && root.right == null)
			return null;

		TreeNode left = null, right = null;

		if (root.left != null)
			left = lowestCommonAncestor(root.left, p, q);

		if (root.right != null)
			right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null)
			return root;

		return left == null ? right : left;
	}

	public TreeNode lcs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;

		TreeNode left = lcs(root.left, p, q);
		TreeNode right = lcs(root.right, p, q);

		if (left == null)
			return right;

		else if (right == null)
			return left;

		return root;
	}
}
