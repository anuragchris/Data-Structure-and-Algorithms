//Link For Problem: https://leetcode.com/problems/subarray-product-less-than-k/

package twoPointer;

public class SubarrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1)
			return 0;

		int prod = 1, left = 0, right = 0, ans = 0;
		for (right = 0; right < nums.length; right++) {
			prod *= nums[right];

			while (prod >= k)
				prod /= nums[left++];

			ans += right - left + 1;
		}

		return ans;
	}
}
