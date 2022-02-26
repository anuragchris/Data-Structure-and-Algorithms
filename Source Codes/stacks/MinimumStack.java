// Link For Problem : https://leetcode.com/problems/min-stack/

package stacks;

import java.util.Stack;

class MinStackWithExtraSpace {
	private Stack<Integer> st;
	private Stack<Integer> min;

	public MinStackWithExtraSpace() {
		this.st = new Stack<Integer>();
		this.min = new Stack<Integer>();
	}

	public void push(int val) {
		st.push(val);
		if (min.isEmpty() || min.peek() >= val)
			min.push(val);
	}

	public void pop() {
		int temp = st.pop();
		if (min.peek() == temp)
			min.pop();
	}

	public int top() {
		return st.peek();
	}

	public int getMin() {
		if (min.isEmpty())
			return -1;
		return min.peek();
	}
}

class MinStackWithoutExtraSpace {
	private Stack<Integer> st;
	private int min;

	public MinStackWithoutExtraSpace() {
		this.st = new Stack<Integer>();
	}

	public void push(int val) {
		if (st.isEmpty()) {
			st.push(val);
			min = val;
		} else {
			if (val >= min)
				st.push(val);
			else {
				st.push((2 * val) - min);
				min = val;
			}
		}
	}

	public void pop() {
		if (st.isEmpty())
			return;
		if (st.peek() >= min)
			st.pop();
		else {
			min = (2 * min) - st.peek();
			st.pop();
		}
	}

	public int top() {
		if (st.isEmpty())
			return -1;
		if (st.peek() >= min)
			return st.peek();
		else
			return min;
	}

	public int getMin() {
		if (st.isEmpty())
			return -1;
		return min;
	}
}

public class MinimumStack {

}
