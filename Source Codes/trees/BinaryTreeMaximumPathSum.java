//Link For Problem: https://leetcode.com/problems/binary-tree-maximum-path-sum/

package trees;

public class BinaryTreeMaximumPathSum {

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

	int result = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxPathSumUtil(root);

		return result;
	}

	public int maxPathSumUtil(TreeNode root) {
		if (root == null)
			return 0;

		int left = maxPathSumUtil(root.left);
		int right = maxPathSumUtil(root.right);

		int straight = Math.max(Math.max(left, right) + root.val, root.val);
		int case2 = Math.max(straight, left + right + root.val);

		result = Math.max(case2, result);

		return straight;
	}
}
