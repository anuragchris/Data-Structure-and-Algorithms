//Link For Problem: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/

package binarySearch;

public class MaximumCountOfPositiveAndNegativeInteger {

	public int maximumCount(int[] nums) {
		int n = nums.length;
		int low = 0, high = n - 1;
		int firstPositive = -1, lastNegative = -1;

		if (nums[0] == 0 && nums[n - 1] == 0)
			return 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] < 0) {
				lastNegative = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		low = 0;
		high = n - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] > 0) {
				firstPositive = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		if (firstPositive == -1 && lastNegative == -1)
			return 0;

		if (lastNegative == -1)
			return n - firstPositive;

		if (firstPositive == -1)
			return lastNegative + 1;

		return Math.max(n - firstPositive, lastNegative + 1);
	}
}
