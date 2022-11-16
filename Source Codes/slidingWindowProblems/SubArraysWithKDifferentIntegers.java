//Link For Problem: https://leetcode.com/problems/subarrays-with-k-different-integers/

package slidingWindowProblems;

public class SubArraysWithKDifferentIntegers {

	public int subarraysWithKDistinct(int[] nums, int k) {
		return count(nums, k) - count(nums, k - 1);
	}

	public int count(int nums[], int k) {
		if (k == 0)
			return 0;

		int n = nums.length, total = 0, diff = 0, j = 0;

		int count[] = new int[20002];

		for (int i = 0; i < n; i++) {
			if (count[nums[i]] == 0)
				diff += 1;

			count[nums[i]] += 1;

			if (diff <= k)
				total += i - j + 1;
			else {
				while (j < n && j < i && diff > k) {
					count[nums[j]] -= 1;

					if (count[nums[j]] == 0)
						diff -= 1;

					j += 1;
				}

				total += i - j + 1;
			}
		}

		return total;
	}
}
