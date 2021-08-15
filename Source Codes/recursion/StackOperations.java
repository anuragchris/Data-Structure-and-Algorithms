package recursion;

import java.util.Stack;

public class StackOperations {
	static void sortStack(Stack<Integer> st, int size) {
		if (size == 1) {
			return;
		}
		int temp = st.pop();
		sortStack(st, st.size());
		insert(st, temp);
	}

	static void insert(Stack<Integer> st, int temp) {
		if (st.size() == 0 || st.peek() <= temp) {
			st.push(temp);
			return;
		}
		int val = st.pop();
		insert(st, temp);
		st.push(val);
	}

	static Stack<Integer> deleteMid(Stack<Integer> st) {
		if (st.size() == 0) {
			return st;
		}
		int k = (st.size() / 2) + 1;
		midDelete(st, k);
		return st;
	}

	static void midDelete(Stack<Integer> st, int k) {
		if (k == 1) {
			st.pop();
			return;
		}
		int temp = st.pop();
		midDelete(st, k - 1);
		st.push(temp);
	}

	static void reverseStack(Stack<Integer> st) {
		if (st.isEmpty() || st.size() == 1) {
			return;
		}
		int temp = st.pop();
		reverseStack(st);
		insertAtBottom(st, temp);
	}

	static void insertAtBottom(Stack<Integer> st, int temp) {
		if (st.isEmpty()) {
			st.push(temp);
			return;
		}
		int element = st.pop();
		insertAtBottom(st, temp);
		st.push(element);

	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(200);
		st.push(20);
		st.push(100);
		st.push(10);
		sortStack(st, st.size());
		System.out.println(st);
		deleteMid(st);
		System.out.println(st);
		reverseStack(st);
		System.out.println(st);
	}
}
