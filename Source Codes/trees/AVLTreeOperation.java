package trees;

import javax.management.RuntimeErrorException;

public class AVLTreeOperation {
    private AVLTreeNode root;

    public AVLTreeOperation() {
	root = null;
    }

    public int height(AVLTreeNode root) {
	if (root == null) {
	    return -1;
	} else {
	    return root.getHeight();
	}
    }

    void updateHeight(AVLTreeNode root) {
	root.setHeight(1 + Math.max(root.getLeft().getHeight(), root.getRight().getHeight()));
    }

    int getBalance(AVLTreeNode root) {
	if (root == null) {
	    return 0;
	} else if (root.getRight() != null && root.getLeft() == null) {
	    return root.getRight().getHeight();
	} else if (root.getLeft() != null && root.getRight() == null) {
	    return root.getLeft().getHeight();
	} else {
	    return (root.getRight().getHeight() - root.getLeft().getHeight());
	}
    }

    AVLTreeNode rotateRight(AVLTreeNode node) {
	if (node == null) {
	    return null;
	} else {
	    AVLTreeNode x = node.getLeft();
	    AVLTreeNode z = x.getRight();
	    x.setRight(node);
	    node.setLeft(z);
	    updateHeight(node);
	    updateHeight(x);
	    return x;
	}
    }

    AVLTreeNode rotateLeft(AVLTreeNode node) {
	if (node == null) {
	    return null;
	} else {
	    AVLTreeNode x = node.getRight();
	    AVLTreeNode z = x.getLeft();
	    x.setLeft(node);
	    node.setRight(z);
	    updateHeight(node);
	    updateHeight(x);
	    return x;
	}
    }

    AVLTreeNode reBalance(AVLTreeNode z) {
	updateHeight(z);
	int balance = getBalance(z);
	if (balance > 1) {
	    if (z.getRight().getRight().getHeight() > z.getRight().getLeft().getHeight()) {
		z = rotateLeft(z);
	    } else {
		z.setRight(rotateRight(z.getRight()));
		z = rotateLeft(z);
	    }
	} else if (balance < -1) {
	    if (z.getLeft().getLeft().getHeight() > z.getLeft().getRight().getHeight()) {
		z = rotateRight(z);
	    } else {
		z.setLeft(rotateLeft(z.getLeft()));
		z = rotateLeft(z);
	    }
	}
	return z;
    }

    AVLTreeNode insertNode(AVLTreeNode root, int key) {
	if (root == null) {
	    root = new AVLTreeNode();
	    root.setData(key);
	    return root;
	} else if (root.getData() > key) {
	    root.setLeft(insertNode(root.getLeft(), key));
	} else if (root.getData() < key) {
	    root.setRight(insertNode(root.getRight(), key));
	} else {
	    throw new RuntimeErrorException(null, "Duplicate Key");
	}
	return reBalance(root);
    }

    AVLTreeNode delete(AVLTreeNode root, int key) {
	if (root == null) {
	    return null;
	} else if (root.getData() > key) {
	    root.setLeft(delete(root.getLeft(), key));
	} else if (root.getData() < key) {
	    root.setRight(delete(root.getRight(), key));
	} else {
	    if (root.getLeft() == null || root.getRight() == null) {
		root = (root.getLeft() == null) ? root.getRight() : root.getLeft();
	    } else {
		AVLTreeNode leftMostChild = leftMostChild(root.getRight());
		root.setData(leftMostChild.getData());
		root.setRight(delete(root.getRight(), key));
	    }
	}
	if (root != null) {
	    root = reBalance(root);
	}
	return root;
    }

    AVLTreeNode leftMostChild(AVLTreeNode root) {
	if (root == null) {
	    return null;
	} else {
	    while (root.getLeft() != null) {
		root = root.getLeft();
	    }
	}
	return root;
    }
}
