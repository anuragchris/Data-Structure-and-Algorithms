//Link For Problem: https://leetcode.com/problems/sum-root-to-leaf-numbers/

package trees;

public class SumRootToLeafNumbers {

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

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;

		return dfs(root, 0);
	}

	static int dfs(TreeNode root, int val) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return val * 10 + root.val;

		return dfs(root.left, val * 10 + root.val) + dfs(root.right, val * 10 + root.val);
	}
}
