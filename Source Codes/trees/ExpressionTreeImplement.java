package trees;

public class ExpressionTreeImplement {
    public static void main(String Args[]) {
	String postFix = "ab+ef*g*-";
	char[] charArray = postFix.toCharArray();
	ExpressionTreeOperation et = new ExpressionTreeOperation();
	ExpressionTreeNode root = et.constructTree(charArray);
	et.inOrderTraversal(root);
    }
}
