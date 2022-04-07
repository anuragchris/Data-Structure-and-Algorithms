//Link For Problem: https://leetcode.com/problems/cousins-in-binary-tree/

package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CousinsInABinaryTree {

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

	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null)
			return false;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode current = q.poll();

				if (current.left != null) {
					q.offer(current.left);
					hm.put(current.left.val, current.val);
				}

				if (current.right != null) {
					q.offer(current.right);
					hm.put(current.right.val, current.val);
				}
			}

			if (hm.containsKey(x) && hm.containsKey(y) && hm.get(x) != hm.get(y))
				return true;

			else if (hm.containsKey(x) || hm.containsKey(y))
				return false;
		}

		return false;
	}
}
