//Link For Problem : https://leetcode.com/problems/sliding-window-maximum/

package slidingWindowProblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	static int[] maxSlidingWindow(int[] nums, int k) {

		if (nums == null || nums.length == 0 || k == 0)
			return new int[] {};

		if (k >= nums.length) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < nums.length; i++) {
				max = Math.max(max, nums[i]);
			}
			return new int[] { max };
		}

		if (k == 1)
			return nums;

		Deque<Integer> dq = new ArrayDeque<Integer>();
		int ans[] = new int[nums.length - k + 1];
		int temp = 0;
		int i = 0, j = 0;
		while (j < nums.length) {
			while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[j])
				dq.pollLast();
			dq.addLast(j);
			if (j - i + 1 < k)
				j += 1;
			else if (j - i + 1 == k) {
				ans[temp] = nums[dq.peekFirst()];
				temp += 1;
				if (dq.peekFirst() < temp)
					dq.pollFirst();
				i += 1;
				j += 1;
			}
		}
		return ans;
	}

	static int[] anotherApproach(int nums[], int k) {

		if (nums == null || nums.length == 0 || k == 0)
			return new int[] {};

		if (k >= nums.length) {
			int max = Integer.MIN_VALUE;

			for (int i : nums)
				max = Math.max(max, i);

			return new int[] { max };
		}

		if (k == 1)
			return nums;

		Deque<Integer> dq = new LinkedList<Integer>();
		int ans[] = new int[nums.length - k + 1];
		int temp = 0;

		for (int i = 0; i < nums.length; i++) {

			if (!dq.isEmpty() && dq.peekFirst() <= (i - k))
				dq.pollFirst();

			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
				dq.pollLast();

			dq.addLast(i);
			if (i >= (k - 1)) {
				ans[temp] = nums[dq.peekFirst()];
				temp += 1;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int nums[] = { -7, -8, 7, 5, 7, 1, 6, 0 };
		int k = 4;
		int ans[] = maxSlidingWindow(nums, k);
	}
}
