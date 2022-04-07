//Link For Problem: https://leetcode.com/problems/count-complete-tree-nodes/

package trees;

public class CountCompleteTreeNodes {

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

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	public int countNodesOptimized(TreeNode root) {
		if (root == null)
			return 0;

		int leftLevel = 1;
		TreeNode left = root.left;

		while (left != null) {
			left = left.left;
			leftLevel += 1;
		}

		int rightLevel = 1;
		TreeNode right = root.right;

		while (right != null) {
			right = right.right;
			rightLevel += 1;
		}

		if (leftLevel == rightLevel)
			return (int) (Math.pow(2, leftLevel)) - 1;

		return 1 + countNodesOptimized(root.left) + countNodesOptimized(root.right);
	}
}
