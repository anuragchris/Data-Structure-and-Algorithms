//Link For Problem: https://leetcode.com/problems/count-good-nodes-in-binary-tree/

package trees;

public class CountGoodNodes {

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

	public int goodNodes(TreeNode root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		int goodNodes = 1; //Include Root.

		goodNodes += search(root.left, root.val);
		goodNodes += search(root.right, root.val);

		return goodNodes;
	}

	static int search(TreeNode current, int max) {
		if (current == null)
			return 0;

		int count = 0;
		if (current.val >= max) {
			count += 1;
			max = current.val;
		}

		if (current.left != null)
			count += search(current.left, max);

		if (current.right != null)
			count += search(current.right, max);

		return count;
	}
}
