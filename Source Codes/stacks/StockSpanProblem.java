package stacks;

import java.util.ArrayList;
import java.util.Stack;

class pair {
	private int value;
	private int index;

	public pair(int value, int index) {
		this.value = value;
		this.index = index;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}

public class StockSpanProblem {
	static void stockSpan(int price[]) {
		if (price.length == 0)
			return;
		Stack<pair> st = new Stack<pair>();
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < price.length; i++) {
			while (!st.isEmpty() && st.peek().getValue() <= price[i])
				st.pop();
			if (st.isEmpty())
				al.add(-1);
			else
				al.add(st.peek().getIndex());
			st.push(new pair(price[i], i));
		}

		for (int i = 0; i < al.size(); i++)
			al.set(i, i - al.get(i));

		for (int i = 0; i < al.size(); i++)
			System.out.print(al.get(i) + " ");
	}

	static void stockSpanWithoutPair(int price[]) {
		if (price.length == 0)
			return;

		Stack<Integer> st = new Stack<Integer>();
		int ans[] = new int[price.length];
		st.push(0);
		ans[0] = 1;

		for (int i = 1; i < price.length; i++) {
			while (!st.isEmpty() && price[st.peek()] <= price[i])
				st.pop();
			ans[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
			st.push(i);
		}

		for (int i : ans)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {
		//		int price[] = { 10, 4, 5, 90, 120, 80 };
		//				stockSpan(price);
		//		stockSpanWithoutPair(price);
	}
}
