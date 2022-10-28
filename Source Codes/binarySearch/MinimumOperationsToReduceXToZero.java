//Link For Problem: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

package binarySearch;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {

	public int minOperations(int[] nums, int x) {
		int n = nums.length, sum = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			sum += nums[i];
			map.put(sum, i);
		}

		if (x > sum)
			return -1;

		map.put(0, 0);

		int longest = 0, val = 0;
		sum -= x;

		for (int i = 0; i < n; i++) {
			val += nums[i];

			if (map.containsKey(val - sum)) {

				if (val - sum == 0)
					longest = Math.max(longest, i - map.get(val - sum) + 1);
				else
					longest = Math.max(longest, i - map.get(val - sum));
			}
		}

		return longest == 0 ? (sum == 0 ? n : -1) : n - longest;
	}
}
