package stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextLargestElement {
	static void nearestGreaterToRight(int arr[]) {
		if (arr.length == 0)
			return;
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();

		for (int i = arr.length - 1; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() <= arr[i])
				st.pop();
			if (st.isEmpty())
				ans.add(-1);
			else
				ans.add(st.peek());
			st.push(arr[i]);
		}
		Collections.reverse(ans);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " --> " + ans.get(i));
		}
	}

	static void nearestGreaterToLeft(int arr[]) {
		if (arr.length == 0)
			return;
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			while (!st.isEmpty() && st.peek() <= arr[i])
				st.pop();
			if (st.isEmpty())
				ans.add(-1);
			else
				ans.add(st.peek());
			st.push(arr[i]);
		}
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + " --> " + ans.get(i));
	}

	static void nearestSmallestToLeft(int arr[]) {
		if (arr.length == 0)
			return;
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {
			while (!st.isEmpty() && st.peek() >= arr[i])
				st.pop();
			if (st.isEmpty())
				System.out.println(arr[i] + " --> " + "-1");
			else
				System.out.println(arr[i] + " --> " + st.peek());
			st.push(arr[i]);
		}
	}

	static void nearestSmallerToRight(int arr[]) {
		if (arr.length == 0)
			return;
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() >= arr[i])
				st.pop();
			if (st.isEmpty())
				ans.add(-1);
			else
				ans.add(st.peek());
			st.add(arr[i]);
		}
		Collections.reverse(ans);
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + " --> " + ans.get(i));
	}

	public static void main(String[] args) {
		//		int arr[] = { 11, 13, 21, 3 };
		//		nearestGreaterToRight(arr);

		//		int[] arr = { 10, 5, 11, 10, 20, 12 };
		//		nearestGreaterToLeft(arr);

		//		int arr[] = { 1, 3, 0, 2, 5 };
		//		nearestSmallerToLeft(arr);

		int arr[] = { 11, 13, 21, 3 };
		nearestSmallerToRight(arr);

	}
}
