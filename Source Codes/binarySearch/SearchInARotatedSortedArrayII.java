//Link For Problem: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

package binarySearch;

public class SearchInARotatedSortedArrayII {

	public boolean search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;

		while (start <= end) {

			while (start < end && nums[start] == nums[start + 1])
				start += 1;

			while (end > start && nums[end] == nums[end - 1])
				end -= 1;

			int mid = start + (end - start) / 2;

			if (nums[mid] == target)
				return true;

			if (nums[start] <= nums[mid]) {
				if (target >= nums[start] && target <= nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if (target >= nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}

		return false;
	}
}