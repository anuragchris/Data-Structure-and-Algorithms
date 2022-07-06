//Link For Problem: https://leetcode.com/problems/3sum/

package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3)
			return new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		if (nums[0] > 0)
			return new ArrayList<List<Integer>>();

		List<List<Integer>> al = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				break;

			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int low = i + 1, high = nums.length - 1;
			int sum = 0;

			while (low < high) {
				sum = nums[i] + nums[low] + nums[high];

				if (sum > 0)
					high -= 1;

				else if (sum < 0)
					low += 1;

				else {
					al.add(Arrays.asList(nums[i], nums[low], nums[high]));

					int lastLow = nums[low], lastHigh = nums[high];

					while (low < high && lastLow == nums[low])
						low += 1;

					while (low < high && lastHigh == nums[high])
						high -= 1;
				}
			}
		}

		return al;
	}
}
