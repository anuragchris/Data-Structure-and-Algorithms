package trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class Node {

	private int data;
	private Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return this.data;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getLeft() {
		return this.left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getRight() {
		return this.right;
	}

}

public class BinaryTree {

	private Node root;

	public BinaryTree() {
		this.root = null;
	}

	public void preOrder(Node root) {
		if (root == null)
			return;

		System.out.println(root.getData());
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	public void preOrderIterative(Node root) {
		if (root == null)
			return;

		Stack<Node> st = new Stack<Node>();
		st.push(root);

		while (!st.isEmpty()) {
			Node temp = st.pop();
			System.out.println(temp.getData());

			if (temp.getRight() != null)
				st.push(temp.getRight());

			if (temp.getLeft() != null)
				st.push(temp.getLeft());
		}
	}

	public void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.getLeft());
		System.out.println(root.getData());
		inOrder(root.getRight());
	}

	public void inOrderIterative(Node root) {
		if (root == null)
			return;

		Stack<Node> st = new Stack<Node>();
		Node current = root;

		while (current != null || !st.isEmpty()) {

			while (current != null) {
				st.push(current);
				current = current.getLeft();
			}
			current = st.pop();
			System.out.println(current.getData());
			current = current.getRight();
		}
	}

	public void postOrder(Node root) {
		if (root == null)
			return;

		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.println(root.getData());
	}

	public void postOrderIterative(Node root) {
		if (root == null)
			return;

		Stack<Node> st1 = new Stack<Node>();
		Stack<Node> st2 = new Stack<Node>();
		st1.push(root);

		while (!st1.isEmpty()) {
			Node temp = st1.pop();
			st2.push(temp);

			if (temp.getLeft() != null)
				st1.push(temp.getLeft());

			if (temp.getRight() != null)
				st1.push(temp.getRight());
		}

		while (!st2.isEmpty())
			System.out.println(st2.pop().getData());
	}

	public void levelOrder(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();
			System.out.println(temp.getData());

			if (temp.getLeft() != null)
				q.offer(temp.getLeft());

			if (temp.getRight() != null)
				q.offer(temp.getRight());
		}
	}

	public boolean search(Node root, int data) {
		if (root == null)
			return false;

		if (root.getData() == data)
			return true;

		return search(root.getLeft(), data) || search(root.getRight(), data);
	}

	public boolean searchIterative(Node root, int data) {
		if (root == null)
			return false;

		if (root.getData() == data)
			return true;

		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.getData() == data)
				return true;

			if (temp.getLeft() != null)
				q.offer(temp.getLeft());

			if (temp.getRight() != null)
				q.offer(temp.getRight());
		}

		return false;
	}

	public void insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}

		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();

			if (temp.getLeft() == null) {
				temp.setLeft(new Node(data));
				break;
			} else
				q.offer(temp.getLeft());

			if (temp.getRight() == null) {
				temp.setRight(new Node(data));
				break;
			} else
				q.offer(temp.getRight());
		}
	}

	public int size(Node root) {
		if (root == null)
			return 0;

		int left = size(root.getLeft());
		int right = size(root.getRight());

		return 1 + left + right;
	}

	public int sizeIterative(Node root) {
		if (root == null)
			return 0;

		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);
		int size = 1;

		while (!q.isEmpty()) {
			Node temp = q.poll();

			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
				size += 1;
			}

			if (temp.getRight() != null) {
				q.offer(temp.getRight());
				size += 1;
			}
		}

		return size;
	}

	public void deleteTree(Node root) {
		root = null;
	}

	public void reverseLevelOrder(Node root) {
		if (root == null)
			return;

		Stack<Node> st = new Stack<Node>();
		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();

			if (temp.getLeft() != null)
				q.offer(temp.getLeft());

			if (temp.getRight() != null)
				q.offer(temp.getRight());

			st.push(temp);
		}

		while (!st.isEmpty())
			System.out.println(st.pop().getData());
	}

	public int height(Node root) {
		if (root == null)
			return 0;

		int leftDepth = height(root.getLeft());
		int rightDepth = height(root.getRight());

		if (leftDepth > rightDepth)
			return leftDepth + 1;

		else
			return rightDepth + 1;
	}

	public int heightIterative(Node root) {
		if (root == null)
			return 0;

		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);
		int height = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			while (size-- > 0) {
				Node temp = q.poll();

				if (temp.getLeft() != null)
					q.offer(temp.getLeft());

				if (temp.getRight() != null)
					q.offer(temp.getRight());
			}
			height += 1;
		}

		return height;
	}

	public int minimumDepth(Node root) {
		if (root == null)
			return 0;

		if (root.getLeft() == null && root.getRight() == null)
			return 1;

		if (root.getLeft() == null)
			return 1 + minimumDepth(root.getRight());

		if (root.getRight() == null)
			return 1 + minimumDepth(root.getLeft());

		return Math.min(minimumDepth(root.getLeft()), minimumDepth(root.getRight())) + 1;
	}

	public int minimumDepthIterative(Node root) {
		if (root == null)
			return 0;

		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);
		int depth = 1;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node current = q.poll();

				if (current.getLeft() == null && current.getRight() == null)
					return depth;

				if (current.getLeft() != null)
					q.offer(current.getLeft());

				if (current.getRight() != null)
					q.offer(current.getRight());
			}
			depth += 1;
		}

		return depth;
	}

	public int deepestNode(Node root) {
		if (root == null)
			return -1;

		Node temp = null;
		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);

		while (!q.isEmpty()) {
			temp = q.poll();

			if (temp.getLeft() != null)
				q.offer(temp.getLeft());

			if (temp.getRight() != null)
				q.offer(temp.getRight());
		}

		return temp.getData();
	}

	public int leafCount(Node root) {
		if (root == null)
			return 0;

		if (root.getLeft() == null && root.getRight() == null)
			return 1;

		return leafCount(root.getLeft()) + leafCount(root.getRight());
	}

	public int leafCountIterative(Node root) {
		if (root == null)
			return 0;

		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);
		int leaf = 0;

		while (!q.isEmpty()) {
			Node temp = q.poll();

			if (temp != null) {
				if (temp.getLeft() != null)
					q.offer(temp.getLeft());

				if (temp.getRight() != null)
					q.offer(temp.getRight());

				if (temp.getLeft() == null && temp.getRight() == null)
					leaf += 1;
			}
		}

		return leaf;
	}

	// Link For Problem:
	// https://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/
	public boolean isValidSequence(Node root, int n, int pos, int arr[]) {
		if (root == null)
			return false;

		else if (pos == n)
			return false;

		else if (root.getData() != arr[pos])
			return false;

		else if (root.getLeft() == null && root.getRight() == null && pos == n - 1)
			return true;

		return isValidSequence(root.getLeft(), n, pos + 1, arr) || isValidSequence(root.getRight(), n, pos + 1, arr);
	}

	public void binaryTreeIn2D(Node root) {
		print2DBinaryTreeUtil(root, 0);
	}

	private void print2DBinaryTreeUtil(Node root, int space) {
		if (root == null)
			return;

		space += 10;

		print2DBinaryTreeUtil(root.getRight(), space);

		System.out.println("\n");

		for (int i = 10; i < space; i++)
			System.out.println(' ');

		System.out.print(root.getData() + "\n");

		print2DBinaryTreeUtil(root.getLeft(), space);
	}

	Node head, tail = null;

	public void binaryTreeToDLL(Node root) {
		if (root == null)
			return;

		binaryTreeToDLL(root.getLeft());

		if (head == null)
			head = tail = root;
		else {
			tail.setRight(root);
			root.setLeft(tail);
			tail = root;
		}

		binaryTreeToDLL(root.getRight());
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.setLeft(new Node(2));
		tree.root.setRight(new Node(3));
		tree.root.getLeft().setLeft(new Node(4));
		tree.root.getRight().setRight(new Node(5));

		// tree.inOrder(tree.root);
		// System.out.println();
		// tree.inOrderIterative(tree.root);

		// tree.preOrder(tree.root);
		// System.out.println();
		// tree.preOrderIterative(tree.root);

		// tree.postOrder(tree.root);
		// System.out.println();
		// tree.postOrderIterative(tree.root);

		// tree.levelOrder(tree.root);

		// System.out.println(tree.search(tree.root, 5));
		// System.out.println(tree.searchIterative(tree.root, 5));

		// tree.insert(tree.root, 6);
		// tree.levelOrder(tree.root);

		// System.out.println(tree.size(tree.root));
		// System.out.println(tree.sizeIterative(tree.root));

		// tree.reverseLevelOrder(tree.root);

		// System.out.println(tree.height(tree.root));
		// System.out.println(tree.heightIterative(tree.root));

		// System.out.println(tree.minimumDepth(tree.root));
		// System.out.println(tree.minimumDepthIterative(tree.root));

		// System.out.println(tree.deepestNode(tree.root));
		// System.out.println(tree.leafCount(tree.root));
		// System.out.println(tree.leafCountIterative(tree.root));

		// int arr[] = { 1, 2, 4 };
		// System.out.println(tree.isValidSequence(tree.root, arr.length, 0, arr));

		//		tree.binaryTreeIn2D(tree.root);

		tree.binaryTreeToDLL(tree.root);

		var current = tree.root;
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getRight();
		}
	}
}
