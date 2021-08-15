package trees;

public class ExpressionTreeNode {
    public char data;
    public ExpressionTreeNode left, right;

    public ExpressionTreeNode(char data) {
	this.data = data;
	left = null;
	right = null;
    }

    public char getData() {
	return data;
    }

    public void setData(char data) {
	this.data = data;
    }

    public ExpressionTreeNode getLeft() {
	return left;
    }

    public void setLeft(ExpressionTreeNode left) {
	this.left = left;
    }

    public ExpressionTreeNode getRight() {
	return right;
    }

    public void setRight(ExpressionTreeNode right) {
	this.right = right;
    }
}
