//Link For Problem: https://leetcode.com/problems/next-greater-element-ii/

package stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class NextGreaterElement_II {

	public int[] nextGreaterElements(int[] nums) {
		int ans[] = new int[nums.length];
		Stack<Integer> st = new Stack<Integer>();

		for (int i = nums.length - 1; i >= 0; i--)
			st.push(nums[i]);

		for (int i = nums.length - 1; i >= 0; i--) {

			while (!st.isEmpty() && st.peek() <= nums[i])
				st.pop();

			if (st.isEmpty())
				ans[i] = -1;
			else
				ans[i] = st.peek();

			st.push(nums[i]);
		}

		return ans;
	}

	public int[] anotherSolution(int nums[]) {
		int res[] = new int[nums.length];
		int n = nums.length;

		Deque<Integer> dq = new ArrayDeque<Integer>();
		Arrays.fill(res, -1);

		for (int i = 0; i < n * 2; i++) {
			int current = i % n;

			while (!dq.isEmpty() && nums[dq.peekFirst()] < nums[current]) {
				int idx = dq.pollFirst();

				res[idx] = nums[current];
			}

			dq.offerFirst(current);
		}

		return res;
	}
}
