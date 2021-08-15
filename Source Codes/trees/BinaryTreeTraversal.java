package trees;

import java.util.Stack;

public class BinaryTreeTraversal {
    BinaryTreeNode root;

    public BinaryTreeTraversal() {
	root = null;
    }

    public void preOrderTraversal(BinaryTreeNode root) {
	if (root == null) {
	    return;
	}
	System.out.println(root.data);
	preOrderTraversal(root.left);
	preOrderTraversal(root.right);
    }

    public void iterativePreOrderTraversal(BinaryTreeNode root) {
	if (root == null) {
	    return;
	}
	Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
	nodeStack.push(root);
	while (nodeStack.empty() == false) {
	    BinaryTreeNode myNode = nodeStack.peek();
	    System.out.println(myNode.getData());
	    nodeStack.pop();
	    if (myNode.right != null) {
		nodeStack.push(myNode.right);
	    }
	    if (myNode.left != null) {
		nodeStack.push(myNode.left);
	    }
	}
    }

    public void inOrderTraversal(BinaryTreeNode root) {
	if (root == null) {
	    return;
	}
	inOrderTraversal(root.left);
	System.out.println(root.getData());
	inOrderTraversal(root.right);
    }

    public void inOrderTraversalWithoutRecursion(BinaryTreeNode root) {
	if (root == null) {
	    return;
	}
	Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
	BinaryTreeNode current = root;
	while (current != null || nodeStack.size() > 0) {
	    while (current != null) {
		nodeStack.push(current);
		current = current.left;
	    }
	    current = nodeStack.pop();
	    System.out.println(current.getData());
	    current = current.right;
	}
    }

    public void postOrderTraversal(BinaryTreeNode root) {
	if (root == null) {
	    return;
	}
	postOrderTraversal(root.left);
	postOrderTraversal(root.right);
	System.out.println(root.getData());
    }

    public void postOrderTraversalWithoutRecursion(BinaryTreeNode root) {
	if (root == null) {
	    return;
	}
	Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
	Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
	stack1.push(root);
	while (stack1.isEmpty() == false) {
	    BinaryTreeNode temp = stack1.pop();
	    stack2.push(temp);
	    if (temp.left != null) {
		stack1.push(temp.left);
	    }
	    if (temp.right != null) {
		stack1.push(temp.right);
	    }
	}
	while (stack2.isEmpty() == false) {
	    BinaryTreeNode temp = stack2.pop();
	    System.out.println(temp.getData());
	}
    }

    public void postOrderTraversalUsingOneStack(BinaryTreeNode root) {
	if (root == null) {
	    return;
	}
	Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
	nodeStack.push(root);
	BinaryTreeNode prev = null;
	while (!nodeStack.isEmpty()) {
	    BinaryTreeNode current = nodeStack.peek();
	    if (prev == null || prev.left == current || prev.right == current) {
		if (current.left != null) {
		    nodeStack.push(current.left);
		} else if (current.right != null) {
		    nodeStack.push(current.right);
		}
	    } else if (current.left == prev) {
		if (current.right != null) {
		    nodeStack.push(current.right);
		}
	    } else {
		System.out.println(current.getData());
		nodeStack.pop();
	    }
	    prev = current;
	}
    }

    // public void printLeveLOrder() {
    // int h = height(root);
    // for (int i = 0; i < h; i++) {
    // printGivenLevel(root, i);
    // }
    // }
    //
    // public int height(BinaryTreeNode root) {
    // if (root == null) {
    // return 0;
    // } else {
    // int leftHeight = height(root.left);
    // int rightHeight = height(root.right);
    // if (leftHeight > rightHeight) {
    // return (leftHeight + 1);
    // } else {
    // return (rightHeight + 1);
    // }
    // }
    // }
    //
    // public void levelOrderTraversal(BinaryTreeNode root) {
    //
    // }
}