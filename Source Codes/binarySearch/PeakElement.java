//Link For Problem : https://leetcode.com/problems/find-peak-element/

package binarySearch;

public class PeakElement {
	static int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;
		int start = 0, end = nums.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (mid > 0 && mid < nums.length - 1) {
				if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid])
					return mid;
				else if (nums[mid - 1] > nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else if (mid == 0) {
				if (nums[1] < nums[0])
					return 0;
				else
					return 1;
			} else if (mid == nums.length - 1) {
				if (nums[nums.length - 2] < nums[nums.length - 1])
					return nums.length - 1;
				else
					return nums.length - 2;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 1, 3, 5, 6, 4 };
		System.out.println(findPeakElement(nums));
	}
}
