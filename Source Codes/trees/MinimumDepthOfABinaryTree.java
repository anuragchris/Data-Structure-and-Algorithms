//Link For Problem: https://leetcode.com/problems/minimum-depth-of-binary-tree/

package trees;

import java.util.ArrayDeque;
import java.util.Queue;

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

public class MinimumDepthOfABinaryTree {

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		if (root.left == null)
			return minDepth(root.right) + 1;

		if (root.right == null)
			return minDepth(root.left) + 1;

		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public int minDepthIterative(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.offer(root);
		int depth = 1;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode current = q.poll();

				if (current.left == null && current.right == null)
					return depth;

				if (current.left != null)
					q.offer(current.left);

				if (current.right != null)
					q.offer(current.right);
			}
			depth += 1;
		}

		return depth;
	}
}
