//Link For Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

package trees;

import java.util.Stack;

public class KthSmallestElementInBST {

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

	public int kthSmallest(TreeNode root, int k) {
		return solve(root, k).val;
	}

	public TreeNode solve(TreeNode root, int k) {
		if (root == null)
			return null;

		Stack<TreeNode> st = new Stack<TreeNode>();
		while (root != null) {
			st.push(root);
			root = root.left;
		}

		int count = 0;
		while (!st.isEmpty()) {
			count += 1;
			if (count == k)
				return st.peek();

			TreeNode temp = st.pop();
			root = temp.right;

			while (root != null) {
				st.push(root);
				root = root.left;
			}
		}
		return null;
	}
}
