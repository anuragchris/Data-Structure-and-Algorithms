//Link For Problem: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

package slidingWindowProblems;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubArrayWithAbsoluteDiffLessOrEqualToLimit {

	public int longestSubarray(int[] nums, int limit) {
		int ans = 0;

		Deque<Integer> maxQueue = new ArrayDeque<>();
		Deque<Integer> minQueue = new ArrayDeque<>();

		int start = 0, end = 0;

		while (end < nums.length) {
			int x = nums[end];

			while (!minQueue.isEmpty() && nums[minQueue.peekLast()] >= x)
				minQueue.pollLast();

			minQueue.offerLast(end);

			while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= x)
				maxQueue.pollLast();

			maxQueue.offerLast(end);

			int minIdx = minQueue.peekFirst(), maxIdx = maxQueue.peekFirst();

			if (nums[maxIdx] - nums[minIdx] > limit) {
				start += 1;

				if (start > minQueue.peekFirst())
					minQueue.pollFirst();

				if (start > maxQueue.peekFirst())
					maxQueue.pollFirst();
			} else {
				ans = Math.max(ans, end - start + 1);
				end += 1;
			}
		}

		return ans;
	}
}
