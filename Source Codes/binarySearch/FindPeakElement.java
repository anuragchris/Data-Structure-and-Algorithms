//Link For Problem: https://leetcode.com/problems/find-peak-element/

package binarySearch;

public class FindPeakElement {

	public int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;

		int n = nums.length;

		if (nums[0] > nums[1])
			return 0;

		if (nums[n - 1] > nums[n - 2])
			return n - 1;

		int start = 1, end = n - 2;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
				return mid;

			else if (nums[mid - 1] > nums[mid])
				end = mid - 1;

			else
				start = mid + 1;
		}

		return -1;
	}
}
