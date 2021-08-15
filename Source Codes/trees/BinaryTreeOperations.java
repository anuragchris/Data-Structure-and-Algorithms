package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeOperations {
    public boolean searchingUsingRecursion(BinaryTreeNode root, int data) {
	if (root == null) {
	    return false;
	}
	if (root.getData() == data) {
	    return true;
	}
	return (searchingUsingRecursion(root.left, data) || searchingUsingRecursion(root.right, data));
    }

    public boolean searchingWithoutRecursion(BinaryTreeNode root, int data) {
	boolean result = false;
	if (root == null) {
	    return false;
	}
	if (root.getData() == data) {
	    return true;
	}
	Queue<BinaryTreeNode> nodeQueue = new LinkedList<BinaryTreeNode>();
	nodeQueue.offer(root);
	while (!nodeQueue.isEmpty()) {
	    BinaryTreeNode temp = nodeQueue.poll();
	    if (temp.getData() == data) {
		result = true;
	    }
	    if (temp.left != null) {
		nodeQueue.offer(temp.left);
	    }
	    if (temp.right != null) {
		nodeQueue.offer(temp.right);
	    }
	}
	return result;
    }

    public void insertingElement(BinaryTreeNode root, int data) {
	if (root == null) {
	    root.setData(data);
	    System.out.println("Created a New Tree with Root :" + root.getData());
	    return;
	}
	Queue<BinaryTreeNode> nodeQueue = new LinkedList<BinaryTreeNode>();
	nodeQueue.offer(root);
	while (!nodeQueue.isEmpty()) {
	    BinaryTreeNode temp = nodeQueue.poll();
	    if (temp.left == null) {
		temp.left = new BinaryTreeNode(data);
		System.out.println("Added a new Node to the Left");
		break;
	    } else {
		nodeQueue.offer(temp.left);
	    }
	    if (temp.right == null) {
		temp.right = new BinaryTreeNode(data);
		System.out.println("Added a new Node to the Right");
		break;
	    } else {
		nodeQueue.offer(temp.right);
	    }
	}
    }

    public int sizeUsingRecursion(BinaryTreeNode root) {
	if (root == null) {
	    return 0;
	}
	int left = sizeUsingRecursion(root.left);
	int right = sizeUsingRecursion(root.right);
	return 1 + left + right;
    }

    public int sizeWithoutRecursion(BinaryTreeNode root) {
	if (root == null) {
	    return 0;
	}
	int size = 1; // root already included
	Queue<BinaryTreeNode> nodeQueue = new LinkedList<BinaryTreeNode>();
	nodeQueue.offer(root);
	while (!nodeQueue.isEmpty()) {
	    BinaryTreeNode temp = nodeQueue.poll();
	    if (temp.left != null) {
		nodeQueue.offer(temp.left);
		size += 1;
	    }
	    if (temp.right != null) {
		nodeQueue.offer(temp.right);
		size += 1;
	    }
	}
	return size;
    }

    public void deleteTree(BinaryTreeNode root) {
	root = null;
	// Garbage Collector will take care of the rest.
    }

    public void levelOrderTraversalInReverse(BinaryTreeNode root) {
	if (root == null) {
	    return;
	}
	Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
	Queue<BinaryTreeNode> nodeQueue = new LinkedList<BinaryTreeNode>();
	nodeQueue.offer(root);
	while (!nodeQueue.isEmpty()) {
	    BinaryTreeNode temp = nodeQueue.poll();
	    if (temp.left != null) {
		nodeQueue.offer(temp.left);
	    }
	    if (temp.right != null) {
		nodeQueue.offer(temp.right);
	    }
	    nodeStack.push(temp);
	}
	while (!nodeStack.isEmpty()) {
	    System.out.println(nodeStack.pop().getData());
	}
    }

    public int heightUsingRecursion(BinaryTreeNode root) {
	if (root == null) {
	    return 0;
	}
	int leftDepth = heightUsingRecursion(root.left);
	int rightDepth = heightUsingRecursion(root.right);
	if (leftDepth > rightDepth) {
	    return leftDepth + 1;
	} else {
	    return rightDepth + 1;
	}
    }

    public int heightUsingIteration(BinaryTreeNode root) {
	if (root == null) {
	    return 0;
	}
	Queue<BinaryTreeNode> nodeQueue = new LinkedList<BinaryTreeNode>();
	nodeQueue.offer(root);
	int height = 0;
	while (!nodeQueue.isEmpty()) {
	    int size = nodeQueue.size();
	    while (size-- > 0) {
		BinaryTreeNode current = nodeQueue.poll();
		if (current.left != null) {
		    nodeQueue.offer(current.left);
		}
		if (current.right != null) {
		    nodeQueue.offer(current.right);
		}
	    }
	    height += 1;
	}
	return height;
    }

    public int minimumDepth(BinaryTreeNode root) {
	if (root == null) {
	    return 0;
	}
	Queue<BinaryTreeNode> nodeQueue = new LinkedList<BinaryTreeNode>();
	nodeQueue.offer(root);
	int depth = 0;
	while (!nodeQueue.isEmpty()) {
	    BinaryTreeNode current = nodeQueue.poll();
	    if (current != null) {
		if (current.left != null) {
		    nodeQueue.offer(current.left);
		}
		if (current.right != null) {
		    nodeQueue.offer(current.right);
		}
	    }
	    if (current.left == null && current.right == null) {
		return depth;
	    } else {
		depth += 1;
	    }
	}
	return -1;
    }

    public void deepestNode(BinaryTreeNode root) {
	if (root == null) {
	    return;
	}
	Queue<BinaryTreeNode> nodeQueue = new LinkedList<BinaryTreeNode>();
	ArrayList<BinaryTreeNode> temp = new ArrayList<>();
	BinaryTreeNode current = null;
	nodeQueue.offer(root);
	while (!nodeQueue.isEmpty()) {
	    current = nodeQueue.poll();
	    if (current != null) {
		if (current.left != null) {
		    nodeQueue.offer(current.left);
		}
		if (current.right != null) {
		    nodeQueue.offer(current.right);
		}
		if (current.left == null && current.right == null) {
		    temp.add(current);
		}
	    }
	}
	for (int i = 0; i < temp.size(); i++) {
	    System.out.println(temp.get(i).getData());
	}
    }

    public int numberOfLeafsUsingRecursion(BinaryTreeNode root) {
	if (root == null) {
	    return 0;
	}
	if (root.left == null && root.right == null) {
	    return 1;
	} else {
	    return getLeafCount(root.left) + getLeafCount(root.right);
	}
    }

    int getLeafCount(BinaryTreeNode root) {
	return numberOfLeafsUsingRecursion(root);
    }

    public int numberOfLeafsWithoutRecursion(BinaryTreeNode root) {
	if (root == null)
	    return 0;
	Queue<BinaryTreeNode> nodeQueue = new LinkedList<BinaryTreeNode>();
	nodeQueue.offer(root);
	int leaf = 0;
	while (!nodeQueue.isEmpty()) {
	    BinaryTreeNode current = nodeQueue.poll();
	    if (current != null) {
		if (current.left != null) {
		    nodeQueue.offer(current.left);
		}
		if (current.right != null) {
		    nodeQueue.offer(current.right);
		}
		if (current.left == null && current.right == null) {
		    leaf += 1;
		}
	    }
	}
	return leaf;
    }

    public int numberOfFullNodesWithoutRecursion(BinaryTreeNode root) {
	if (root == null)
	    return 0;
	Queue<BinaryTreeNode> nodeQueue = new LinkedList<BinaryTreeNode>();
	nodeQueue.offer(root);
	int fullNodes = 0;
	while (!nodeQueue.isEmpty()) {
	    BinaryTreeNode current = nodeQueue.poll();
	    if (current != null) {
		if (current.left != null && current.right != null) {
		    fullNodes += 1;
		}
		if (current.left != null) {
		    nodeQueue.offer(current.left);
		}
		if (current.right != null) {
		    nodeQueue.offer(current.right);
		}
	    }
	}
	return fullNodes;
    }

    public int NumberOfFullNodesUsingRecursion(BinaryTreeNode root) {
	if (root == null) {
	    return 0;
	}
	int fullNode = 0;
	if (root.left != null && root.right != null) {
	    fullNode += 1;
	}
	fullNode += (NumberOfFullNodesUsingRecursion(root.left) + NumberOfFullNodesUsingRecursion(root.right));
	return fullNode;
    }

    public boolean structurallyIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
	if (root1 == null && root2 == null) {
	    return true;
	}
	if (root1 == null || root2 == null) {
	    return false;
	}
	return (structurallyIdentical(root1.left, root2.left) && structurallyIdentical(root1.right, root2.right));
    }

    static class A {
	int ans = Integer.MIN_VALUE;
    }

    public int diameter(BinaryTreeNode root) {
	if (root == null) {
	    return 0;
	}
	A a = new A();
	int height_of_tree = height(root, a);
	return a.ans;
    }

    public int height(BinaryTreeNode root, A a) {
	if (root == null) {
	    return 0;
	}
	int left_Height = height(root.left, a);
	int right_Height = height(root.right, a);
	a.ans = Math.max(a.ans, 1 + left_Height + right_Height);
	return 1 + (left_Height + right_Height);
    }

    public boolean isomorphic(BinaryTreeNode root1, BinaryTreeNode root2) {
	if (root1 == null && root2 == null) {
	    return true;
	}
	if (root1 == null && root2 != null || root1 != null && root2 == null) {
	    return false;
	}
	return (isomorphic(root1.getLeft(), root2.getLeft())) && isomorphic(root1.getRight(), root2.getRight());
    }

    public boolean quasiIsomorphic(BinaryTreeNode root1, BinaryTreeNode root2) {
	if (root1 == null && root2 == null) {
	    return true;
	}
	if (root1 == null && root2 != null || root1 != null && root2 == null) {
	    return false;
	}
	return (quasiIsomorphic(root1.getLeft(), root2.getLeft()))
		&& (quasiIsomorphic(root1.getRight(), root2.getRight()))
		|| (quasiIsomorphic(root1.getLeft(), root2.getRight())
			&& (quasiIsomorphic(root1.getRight(), root2.getLeft())));
    }

    public void toDLL(BinaryTreeNode root) {
	BinaryTreeNode prev = null;
	LinkedList<BinaryTreeNode> list = new LinkedList<BinaryTreeNode>();
	list = toDLLFromTree(root, list, prev);
	for (int i = 0; i < list.size(); i++) {
	    System.out.println(list.get(i).getData());
	}
    }

    public LinkedList<BinaryTreeNode> toDLLFromTree(BinaryTreeNode root, LinkedList<BinaryTreeNode> list,
	    BinaryTreeNode prev) {
	if (root == null) {
	    return null;
	}
	toDLLFromTree(root.getLeft(), list, prev);
	if (prev == null) {
	    list.add(root);
	} else {
	    root.left = prev;
	    list.add(root);
	}
	prev = root;
	toDLLFromTree(root.getRight(), list, prev);
	return list;
    }
}
