//Link For Problem: https://leetcode.com/problems/minimum-size-subarray-sum/

package slidingWindowProblems;

public class MinimumSizeSubArraySum {

	public int minSubArrayLen(int target, int[] nums) {
		int left = 0, total = 0;

		int res = Integer.MAX_VALUE;

		for (int right = 0; right < nums.length; right++) {
			total += nums[right];

			while (total >= target) {
				res = Math.min(res, right - left + 1);
				total -= nums[left];
				left += 1;
			}
		}

		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
