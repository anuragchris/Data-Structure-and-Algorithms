//Link For Problem: https://leetcode.com/problems/squares-of-a-sorted-array/

package twoPointer;

public class SquaresOfASortedArray {

	public int[] sortedSquares(int[] nums) {
		if (nums[0] >= 0) {

			for (int i = 0; i < nums.length; i++)
				nums[i] *= nums[i];

			return nums;
		}

		else {
			int i = 0, j = nums.length - 1;
			int arr[] = new int[nums.length];
			int idx = nums.length - 1;

			while (i <= j) {

				if (Math.abs(nums[i]) > Math.abs(nums[j])) {
					arr[idx] = nums[i] * nums[i];
					i += 1;
					idx -= 1;
				}

				else {
					arr[idx] = nums[j] * nums[j];
					j -= 1;
					idx -= 1;
				}
			}

			return arr;
		}
	}
}
