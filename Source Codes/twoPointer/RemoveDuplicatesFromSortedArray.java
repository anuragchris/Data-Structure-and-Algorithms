//Link For Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

package twoPointer;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 1)
			return 1;

		int i = nums.length > 0 ? 1 : 0;

		for (int n : nums) {
			if (n > nums[i - 1])
				nums[i++] = n;
		}

		return i;
	}
}
