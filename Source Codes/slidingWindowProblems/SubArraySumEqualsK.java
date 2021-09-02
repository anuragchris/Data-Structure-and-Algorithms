// Link For Problem : https://leetcode.com/problems/subarray-sum-equals-k/

package slidingWindowProblems;

import java.util.HashMap;

public class SubArraySumEqualsK {
	static int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int current = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			current += nums[i];
			if (current == k)
				count += 1;
			if (map.containsKey(current - k))
				count += map.get(current - k);
			if (map.containsKey(current))
				map.put(current, map.get(current) + 1);
			else
				map.put(current, 1);
		}
		return count;
	}
}
