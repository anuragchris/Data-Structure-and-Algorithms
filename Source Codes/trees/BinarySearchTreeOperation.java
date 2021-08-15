package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeOperation {
    BinarySearchTreeNode root;

    public BinarySearchTreeOperation() {
	root = null;
    }

    public BinarySearchTreeNode search(BinarySearchTreeNode root, int data) {
	if (root == null) {
	    return null;
	}
	if (data < root.getData()) {
	    return search(root.getLeft(), data);
	} else if (data > root.getData()) {
	    return search(root.getRight(), data);
	} else {
	    return root;
	}
    }

    public BinarySearchTreeNode searchWithoutRecursion(BinarySearchTreeNode root, int data) {
	if (root == null) {
	    return null;
	}
	while (root != null) {
	    if (data < root.getData()) {
		root = root.getLeft();
	    } else if (data > root.getData()) {
		root = root.getRight();
	    } else if (data == root.data) {
		return root;
	    } else {
		return null;
	    }
	}
	return null;
    }

    public BinarySearchTreeNode minimumElement(BinarySearchTreeNode root) {
	if (root == null) {
	    return null;
	}
	while (root != null) {
	    if (root.getLeft() == null) {
		return root;
	    } else {
		root = root.getLeft();
	    }
	}
	return null;
    }

    public BinarySearchTreeNode minimumElementWithRecursion(BinarySearchTreeNode root) {
	if (root == null) {
	    return null;
	}
	if (root.getLeft() == null) {
	    return root;
	} else {
	    return minimumElementWithRecursion(root.getLeft());
	}
    }

    public BinarySearchTreeNode inOrderPredecessor(BinarySearchTreeNode root, BinarySearchTreeNode prec, int data) {
	if (root == null) {
	    return null;
	}
	if (data < root.getData()) {
	    return inOrderPredecessor(root.left, prec, data);
	} else if (data == root.getData()) {
	    if (root.left != null) {
		return maximum(root.left);
	    }
	} else {
	    prec = root;
	    return inOrderPredecessor(root.right, prec, data);
	}
	return prec;
    }

    public BinarySearchTreeNode maximum(BinarySearchTreeNode root) {
	if (root == null) {
	    return null;
	}
	while (root.getRight() != null) {
	    root = root.right;
	}
	return root;
    }

    public BinarySearchTreeNode insertElement(BinarySearchTreeNode root, int data) {
	if (root == null) {
	    root = new BinarySearchTreeNode(data);
	    root.setLeft(null);
	    root.setRight(null);
	} else if (data < root.getData()) {
	    root.setLeft(insertElement(root.getLeft(), data));
	    // System.out.println(root.getData());
	} else if (data > root.getData()) {
	    root.setRight(insertElement(root.getRight(), data));
	    // System.out.println(root.getData());
	}
	return root;
    }

    public BinarySearchTreeNode insertElementWithoutRecursion(BinarySearchTreeNode root, int data) {
	if (root == null) {
	    root = new BinarySearchTreeNode(data);
	    root.setLeft(null);
	    root.setRight(null);
	    return root;
	}
	BinarySearchTreeNode current = root;
	if (data < root.getData()) {
	    while (current != null) {
		if (data < current.getData()) {
		    if (current.getLeft() == null) {
			break;
		    } else {
			current = current.getLeft();
		    }
		}
		if (data > current.getData()) {
		    if (current.getRight() == null) {
			break;
		    } else {
			current = current.getRight();
		    }
		}
	    }
	}
	if (data > root.getData()) {
	    while (current != null) {
		if (data > current.getData()) {
		    if (current.getRight() == null) {
			break;
		    } else {
			current = current.getRight();
		    }
		}
		if (data < current.getData()) {
		    if (current.getLeft() == null) {
			break;
		    } else {
			current = current.getLeft();
		    }
		}
	    }
	}
	if (current.getLeft() == null && data < current.getData()) {
	    current.setLeft(new BinarySearchTreeNode(data));
	} else {
	    current.setRight(new BinarySearchTreeNode(data));
	}
	return root;
    }

    public void inOrderTraversal(BinarySearchTreeNode root) {
	if (root == null) {
	    return;
	}
	inOrderTraversal(root.getLeft());
	System.out.println(root.getData());
	inOrderTraversal(root.getRight());
    }

    public BinarySearchTreeNode deleteElement(BinarySearchTreeNode root, int element) {
	if (root == null) {
	    return null;
	}
	if (element < root.getData()) {
	    root.left = deleteElement(root.getLeft(), element);
	} else if (element > root.getData()) {
	    root.right = deleteElement(root.getRight(), element);
	} else {
	    if (root.getLeft() != null && root.getRight() != null) {
		BinarySearchTreeNode temp = maximum(root.getLeft());
		root.setData(temp.getData());
		root.left = deleteElement(root.getLeft(), root.getData());
	    } else {
		// BinarySearchTreeNode temp = root;
		if (root.left == null) {
		    root = root.getRight();
		}
		if (root.right == null) {
		    root = root.getRight();
		}
	    }
	}
	return root;
    }

    public BinarySearchTreeNode LCA(BinarySearchTreeNode root, int a, int b) {
	if (root == null) {
	    return null;
	}
	if (root.getData() == a || root.getData() == b) {
	    return root;
	}
	if (Math.max(a, b) < root.getData()) {
	    return LCA(root.getLeft(), a, b);
	} else if (Math.min(a, b) > root.getData()) {
	    return LCA(root.getRight(), a, b);
	} else {
	    return root;
	}
    }

    public int distanceFromRoot(BinarySearchTreeNode root, int a) {
	if (root.getData() == a) {
	    return 0;
	}
	if (root.getData() < a) {
	    return 1 + distanceFromRoot(root.getRight(), a);
	} else {
	    return 1 + distanceFromRoot(root.getLeft(), a);
	}
    }

    public int shortestPath(BinarySearchTreeNode root, int a, int b) {
	if (root == null) {
	    return -1;
	}
	if (a == b) {
	    return 0;
	}
	if (Math.max(a, b) < root.getData()) {
	    return shortestPath(root.getLeft(), a, b);
	}
	if (Math.min(a, b) > root.getData()) {
	    return shortestPath(root.getRight(), a, b);
	}
	if ((a >= root.getData() && b <= root.getData()) || (a <= root.getData() && b >= root.getData())) {
	    return distanceFromRoot(root, a) + distanceFromRoot(root, b);
	}
	return -1;
    }

    public boolean verifyBST(BinarySearchTreeNode root) {
	int min = Integer.MIN_VALUE;
	int max = Integer.MAX_VALUE;
	return verifyBSTutil(root, min, max);
    }

    public boolean verifyBSTutil(BinarySearchTreeNode root, int min, int max) {
	if (root == null) {
	    return true;
	}
	if (root.getData() < min || root.getData() > max) {
	    return false;
	}
	return (verifyBSTutil(root.getLeft(), min, root.getData())
		&& verifyBSTutil(root.getRight(), root.getData(), max));
    }

    private int prev = Integer.MIN_VALUE;

    public boolean verifyBSTwithTraversal(BinarySearchTreeNode root) {
	if (root == null) {
	    return true;
	}
	if (!verifyBSTwithTraversal(root.getLeft())) {
	    return false;
	}
	if (root.getData() < prev) {
	    return false;
	}
	prev = root.getData();
	return verifyBSTwithTraversal(root.getRight());
    }

    public BinarySearchTreeNode fromLinkedListToTree(LinkedList<Integer> list) {
	BinarySearchTreeNode root, left;
	root = null;
	left = null;
	return fromLLToTree(list, list.size(), root, left);
    }

    public BinarySearchTreeNode fromLLToTree(LinkedList<Integer> list, int size, BinarySearchTreeNode root,
	    BinarySearchTreeNode left) {
	if (size <= 0) {
	    return null;
	}
	left = fromLLToTree(list, size / 2, root, left);
	root.setData(list.getFirst());
	root.left = left;
	list.poll();
	root.right = fromLLToTree(list, size - (size / 2) - 1, root, left);
	return root;
    }

    public BinarySearchTreeNode KthSmallestElement(BinarySearchTreeNode root, int k, int count) {
	if (root == null) {
	    return null;
	}
	Stack<BinarySearchTreeNode> nodeStack = new Stack<BinarySearchTreeNode>();
	while (root != null) {
	    nodeStack.push(root);
	    root = root.getLeft();
	}
	while (!nodeStack.isEmpty()) {
	    count += 1;
	    if (count == k) {
		return nodeStack.peek();
	    }
	    BinarySearchTreeNode temp = nodeStack.pop();
	    root = temp.getRight();
	    while (root != null) {
		nodeStack.push(root);
		root = root.getLeft();
	    }
	}
	return null;
    }

    public BinarySearchTreeNode floor(BinarySearchTreeNode root, int data) {
	BinarySearchTreeNode floor = null;
	if (root == null) {
	    return null;
	}
	while (root != null) {
	    if (data == root.getData()) {
		floor = root;
		return floor;
	    }
	    if (data > root.getData()) {
		if (root.getRight() != null && root.getRight().getData() <= data) {
		    root = root.getRight();
		    floor = root;
		} else if (root.getLeft() != null && data >= root.getLeft().getData()) {
		    root = root.getLeft();
		    floor = root;
		} else {
		    floor = root;
		    return floor;
		}
	    }
	    if (data < root.getData()) {
		if (root.getLeft() != null && root.getLeft().getData() >= data) {
		    root = root.getLeft();
		    floor = root;
		} else if (root.getRight() != null && data <= root.getRight().getData()) {
		    root = root.getRight();
		    floor = root;
		} else {
		    floor = root;
		    return floor;
		}
	    }
	}
	return null;
    }

    public BinarySearchTreeNode ceil(BinarySearchTreeNode root, int data) {
	BinarySearchTreeNode ceil = null;
	if (root == null) {
	    return null;
	}
	while (root != null) {
	    if (data == root.getData()) {
		return root;
	    }
	    if (data > root.getData()) {
		if (root.getRight() != null && root.getRight().getData() <= data) {
		    root = root.getRight();
		    ceil = root;
		} else if (root.getLeft() != null && root.getLeft().getData() >= data) {
		    root = root.getLeft();
		    ceil = root;
		} else if (root.getRight() != null && root.getRight().getData() >= data) {
		    root = root.getRight();
		    ceil = root;
		    if (root.getLeft() != null && root.getLeft().getData() >= data) {
			root = root.getLeft();
			ceil = root;
		    } else {
			return ceil;
		    }
		} else {
		    return ceil;
		}
	    } else if (data < root.getData()) {
		if (root.getLeft() != null && root.getLeft().getData() >= data) {
		    root = root.getLeft();
		    ceil = root;
		} else if (root.getRight() != null && root.getRight().getData() >= data) {
		    root = root.getRight();
		    ceil = root;
		    if (root.getLeft() != null && root.getLeft().getData() >= data) {
			root = root.getLeft();
			ceil = root;
		    } else {
			return ceil;
		    }
		} else {
		    ceil = root;
		    return ceil;
		}
	    }
	}
	return null;
    }

    public void interSection(BinarySearchTreeNode root1, BinarySearchTreeNode root2) {
	if (root1 == null || root2 == null) {
	    return;
	}
	Stack<BinarySearchTreeNode> nodeStack1 = new Stack<BinarySearchTreeNode>();
	Stack<BinarySearchTreeNode> nodeStack2 = new Stack<BinarySearchTreeNode>();
	BinarySearchTreeNode current = root1;
	while (current != null || nodeStack1.size() > 0) {
	    while (current != null) {
		nodeStack1.push(current);
		current = current.getLeft();
	    }

	}
    }

    public void printInRange(BinarySearchTreeNode root, int k1, int k2) {
	if (root == null) {
	    return;
	}
	Queue<BinarySearchTreeNode> nodeQueue = new LinkedList<BinarySearchTreeNode>();
	nodeQueue.add(root);
	while (!nodeQueue.isEmpty()) {
	    BinarySearchTreeNode temp = nodeQueue.remove();
	    if (temp.getData() >= k1 && temp.getData() <= k2) {
		System.out.println(temp.getData());
	    }
	    if (temp.getLeft() != null && temp.getLeft().getData() >= k1) {
		nodeQueue.add(temp.getLeft());
	    }
	    if (temp.getRight() != null && temp.getRight().getData() <= k2) {
		nodeQueue.add(temp.getRight());
	    }
	}
	nodeQueue.clear();
    }
}