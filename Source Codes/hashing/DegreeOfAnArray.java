//Link For Problem: https://leetcode.com/problems/degree-of-an-array/

package hashing;

import java.util.HashMap;

public class DegreeOfAnArray {

	public int findShortestSubArray(int[] nums) {
		HashMap<Integer, Integer> count = new HashMap<>();
		HashMap<Integer, Integer> firstSeen = new HashMap<>();

		int degree = 0, minLength = 0;

		for (int i = 0; i < nums.length; i++) {
			firstSeen.putIfAbsent(nums[i], i);
			count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

			if (count.get(nums[i]) > degree) {
				degree = count.get(nums[i]);
				minLength = i - firstSeen.get(nums[i]) + 1;
			} else if (count.get(nums[i]) == degree) {
				minLength = Math.min(minLength, i - firstSeen.get(nums[i]) + 1);
			}
		}

		return minLength;
	}
}
