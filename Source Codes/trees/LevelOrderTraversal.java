//Link For Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/

package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

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

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<List<Integer>>();

		ArrayList<List<Integer>> al = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode current = q.poll();
				temp.add(current.val);

				if (current.left != null)
					q.offer(current.left);

				if (current.right != null)
					q.offer(current.right);
			}
			al.add(temp);
		}

		return al;
	}
}
