//Link For Problem: https://leetcode.com/problems/maximum-subarray/?envType=list&envId=rdtb6ags

package slidingWindowProblems;

public class MaximumSubArray {

	public int maxSubArray(int[] nums) {
		int ans = nums[0], current = 0;

		for (int n : nums) {
			if (current < 0)
				current = 0;

			current += n;
			ans = Math.max(ans, current);
		}

		return ans;
	}
}
