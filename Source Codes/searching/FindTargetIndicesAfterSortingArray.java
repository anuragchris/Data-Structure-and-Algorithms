//Link For Problem: https://leetcode.com/problems/find-target-indices-after-sorting-array/

package searching;

import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {

	public List<Integer> targetIndices(int[] nums, int target) {
		int lessThan = 0, equalTo = 0;

		for (int i : nums) {
			if (i == target)
				equalTo += 1;
			else if (i < target)
				lessThan += 1;
		}

		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < equalTo; i++)
			ans.add(lessThan++);

		return ans;
	}
}
