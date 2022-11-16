//Link For Problem: https://leetcode.com/problems/binary-subarrays-with-sum/description/

package slidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArraysWithSum {

	public int numSubarraysWithSum(int[] nums, int goal) {
		Map<Integer, Integer> map = new HashMap<>();

		int sum = 0, total = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (map.containsKey(sum - goal))
				total += map.get(sum - goal);

			if (sum == goal)
				total += 1;

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return total;
	}

	public int usingArrays(int nums[], int goal) {
		int n = nums.length;

		int prefix[] = new int[n + 1];
		int sum = 0, total = 0;

		for (int i = 0; i < n; i++) {
			sum += nums[i];
			int diff = sum - goal;

			if (diff >= 0)
				total += prefix[diff];

			if (sum == goal)
				total += 1;

			prefix[sum] += 1;
		}

		return total;
	}
}
