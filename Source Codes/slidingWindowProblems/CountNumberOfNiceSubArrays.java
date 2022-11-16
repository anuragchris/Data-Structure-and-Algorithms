//Link For Problem: https://leetcode.com/problems/count-number-of-nice-subarrays/

package slidingWindowProblems;

import java.util.LinkedList;

public class CountNumberOfNiceSubArrays {

	public int numberOfSubarrays(int[] nums, int k) {
		var deque = new LinkedList<Integer>();
		deque.add(-1);

		int ans = 0;

		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & 1) == 1)
				deque.add(i);

			if (deque.size() > k + 1)
				deque.pop();

			if (deque.size() == k + 1)
				ans += deque.get(1) - deque.get(0);
		}

		return ans;
	}

	public int anotherSolution(int nums[], int k) {
		int j = 0, odd = 0, count = 0, total = 0;

		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & 1) == 1) {
				odd += 1;

				if (odd >= k) {
					count = 1;

					while ((nums[j++] & 1) == 0)
						count += 1;

					total += count;
				}
			}

			else if (odd >= k)
				total += count;
		}

		return total;
	}
}
