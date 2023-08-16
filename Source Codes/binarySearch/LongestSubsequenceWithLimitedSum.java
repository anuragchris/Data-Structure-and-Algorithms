//Link For Problem: https://leetcode.com/problems/longest-subsequence-with-limited-sum/

package binarySearch;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {

	public int[] answerQueries(int[] nums, int[] queries) {
		Arrays.sort(nums);

		for (int i = 1; i < nums.length; i++)
			nums[i] += nums[i - 1];

		int ans[] = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			int temp = binarySearch(nums, queries[i]);
			ans[i] = temp;
		}

		return ans;
	}

	private int binarySearch(int nums[], int target) {
		int low = 0, high = nums.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == target)
				return mid + 1;

			if (nums[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}

		return nums[low] > target ? low : low + 1;
	}
}
