package trees;

import java.util.Stack;

public class ExpressionTreeOperation {
    ExpressionTreeNode root;

    public ExpressionTreeOperation() {
	root = null;
    }

    boolean isOperator(char c) {
	if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
	    return true;
	}
	return false;
    }

    public void inOrderTraversal(ExpressionTreeNode root) {
	if (root == null) {
	    return;
	}
	inOrderTraversal(root.left);
	System.out.print(root.getData() + " ");
	inOrderTraversal(root.right);
    }

    public ExpressionTreeNode constructTree(char postfix[]) {
	Stack<ExpressionTreeNode> nodeStack = new Stack<ExpressionTreeNode>();
	for (int i = 0; i < postfix.length; i++) {
	    if (!isOperator(postfix[i])) {
		ExpressionTreeNode newNode = new ExpressionTreeNode(postfix[i]);
		nodeStack.push(newNode);
	    } else {
		ExpressionTreeNode newNode = new ExpressionTreeNode(postfix[i]);
		ExpressionTreeNode t1 = nodeStack.pop();
		ExpressionTreeNode t2 = nodeStack.pop();
		newNode.right = t1;
		newNode.left = t2;
		nodeStack.push(newNode);
	    }
	}
	ExpressionTreeNode t = nodeStack.peek();
	nodeStack.pop();
	return t;
    }
}
