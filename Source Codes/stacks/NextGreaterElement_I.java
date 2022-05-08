//Link For Problem: https://leetcode.com/problems/next-greater-element-i/

package stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_I {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		Stack<Integer> st = new Stack<Integer>();

		for (int i : nums2) {

			while (!st.isEmpty() && st.peek() < i)
				hm.put(st.pop(), i);

			st.push(i);
		}

		for (int i = 0; i < nums1.length; i++)
			nums1[i] = hm.getOrDefault(nums1[i], -1);

		return nums1;
	}

	public int[] anotherSolution(int nums1[], int nums2[]) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		Deque<Integer> dq = new ArrayDeque<Integer>();

		for (int i : nums2) {

			while (!dq.isEmpty() && dq.peekFirst() < i)
				hm.put(dq.pollFirst(), i);

			dq.offerFirst(i);
		}

		while (!dq.isEmpty())
			hm.put(dq.pollFirst(), -1);

		for (int i = 0; i < nums1.length; i++)
			nums1[i] = hm.get(nums1[i]);

		return nums1;
	}
}
