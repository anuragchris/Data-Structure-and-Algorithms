//Link For Problem: https://leetcode.com/problems/rotate-array/	

package stacks;

public class RotateArray {

	public void rotate(int[] nums, int k) {
		k = k % nums.length;

		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	void reverse(int arr[], int i, int j) {
		int l = i, r = j;

		while (l < r) {
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			l += 1;
			r -= 1;
		}
	}
}
