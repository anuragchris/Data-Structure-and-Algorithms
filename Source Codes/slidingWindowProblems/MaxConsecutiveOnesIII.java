//Link For Problem: https://leetcode.com/problems/max-consecutive-ones-iii/

package slidingWindowProblems;

public class MaxConsecutiveOnesIII {

	public int longestOnes(int[] nums, int k) {
		int left = 0, right = 0, max = 0;

		int zeroes = 0;

		for (right = 0; right < nums.length; right++) {
			if (nums[right] == 0)
				zeroes += 1;

			if (zeroes > k) {
				if (nums[left] == 0)
					zeroes -= 1;

				left += 1;
			}

			if (zeroes <= k)
				max = Math.max(max, right - left + 1);
		}

		return max;
	}
}
