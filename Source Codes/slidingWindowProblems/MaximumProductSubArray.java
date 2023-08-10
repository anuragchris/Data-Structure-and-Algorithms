//Link For Problem: https://leetcode.com/problems/maximum-product-subarray/

package slidingWindowProblems;

public class MaximumProductSubArray {

	public int maxProduct(int[] nums) {
		int max = nums[0], current = 1;

		for (int i : nums) {
			current *= i;
			max = Math.max(max, current);

			if (current == 0)
				current = 1;
		}

		current = 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			current *= nums[i];
			max = Math.max(max, current);

			if (current == 0)
				current = 1;
		}

		return max;
	}

	public int anotherSolution(int nums[]) {
		int res = Integer.MIN_VALUE;
		int currMin = 1, currMax = 1;

		for (int i : nums)
			res = Math.max(i, res);

		for (int i : nums) {
			if (i == 0) {
				currMin = 1;
				currMax = 1;
				continue;
			}

			int temp = currMax * i;

			currMax = Math.max(i * currMax, i * currMin);
			currMax = Math.max(currMax, i);

			currMin = Math.min(temp, i * currMin);
			currMin = Math.min(currMin, i);

			res = Math.max(res, currMax);
		}

		return res;
	}
}
