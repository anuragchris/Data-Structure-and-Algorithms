//Link For Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

package twoPointer;

public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] nums) {
		if (nums.length < 3)
			return nums.length;

		int i = 0;

		for (int n : nums) {

			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		}

		return i;
	}
}
