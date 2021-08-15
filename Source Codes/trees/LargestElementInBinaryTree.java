package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LargestElementInBinaryTree {
    public int usingRecursion(BinaryTreeNode root) {
	int max = Integer.MIN_VALUE;
	if (root != null) {
	    int res = root.getData();
	    int maxLeft = usingRecursion(root.left);
	    int maxRight = usingRecursion(root.right);
	    max = maxLeft > maxRight ? maxLeft : maxRight;
	    max = max > res ? max : res;
	}
	return max;
    }

    public int withoutRecursion(BinaryTreeNode root) {
	if (root == null) {
	    return -1;
	}
	int max = Integer.MIN_VALUE;
	Queue<BinaryTreeNode> nodeQueue = new LinkedList<BinaryTreeNode>();
	nodeQueue.offer(root);
	while (!nodeQueue.isEmpty()) {
	    BinaryTreeNode temp = nodeQueue.poll();
	    if (temp.getData() > max) {
		max = Math.max(max, temp.getData());
	    }
	    if (temp.left != null) {
		nodeQueue.offer(temp.left);
	    }
	    if (temp.right != null) {
		nodeQueue.offer(temp.right);
	    }
	}
	return max;
    }
}