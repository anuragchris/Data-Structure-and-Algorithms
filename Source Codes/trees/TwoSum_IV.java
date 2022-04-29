//Link For Problem: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

package trees;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class TwoSum_IV {

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

	public boolean findTarget(TreeNode root, int k) {
		return helper(root, k, new HashSet<Integer>(), false);
	}

	static boolean helper(TreeNode root, int k, HashSet<Integer> hs, boolean ans) {
		if (root == null)
			return false;

		int diff = k - root.val;
		if (hs.contains(diff))
			return true;

		hs.add(root.val);

		if (!ans && root.left != null)
			ans = helper(root.left, k, hs, ans);

		if (!ans && root.right != null)
			ans = helper(root.right, k, hs, ans);

		return ans;
	}

	//BFS Solution
	public boolean twoSumIV(TreeNode root, int k) {
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		HashSet<Integer> hs = new HashSet<Integer>();
		q.offer(root);

		while (!q.isEmpty()) {
			TreeNode current = q.poll();

			if (hs.contains(k - current.val))
				return true;

			hs.add(current.val);

			if (current.left != null)
				q.offer(current.left);

			if (current.right != null)
				q.offer(current.right);
		}

		return false;
	}
}
