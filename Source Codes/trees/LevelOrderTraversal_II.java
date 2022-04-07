//Link For Problem: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal_II {
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

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
		Collections.reverse(al);

		return al;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<List<Integer>>();

		ArrayList<List<Integer>> al = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			al.add(new ArrayList<Integer>());
			int last = al.size() - 1;

			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();

				if (temp == null)
					continue;

				al.get(last).add(temp.val);

				if (temp.left != null)
					q.offer(temp.left);

				if (temp.right != null)
					q.offer(temp.right);
			}
		}
		Collections.reverse(al);

		return al;
	}
}
