//Link For Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

package binarySearch;

public class FindFirstAndLastPositionOfElement {

	public int[] searchRange(int[] nums, int target) {
		int result[] = new int[2];
		result[0] = findFirst(nums, target);
		result[1] = findLast(nums, target);

		return result;
	}

	int findFirst(int nums[], int target) {
		int temp = -1;
		int start = 0, end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] < target)
				start = mid + 1;

			else if (nums[mid] > target)
				end = mid - 1;

			else {
				temp = mid;
				end = mid - 1;
			}
		}

		return temp;
	}

	int findLast(int nums[], int target) {
		int temp = -1;
		int start = 0, end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] < target)
				start = mid + 1;

			else if (nums[mid] > target)
				end = mid - 1;

			else {
				temp = mid;
				start = mid + 1;
			}
		}

		return temp;
	}
}
