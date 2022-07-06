//Link For Problem: https://leetcode.com/problems/sort-colors/

package twoPointer;

public class SortColors {

	public void sortColors(int[] nums) {
		int zero = 0, one = 0, two = 0;

		for (int i : nums) {

			if (i == 0)
				zero += 1;

			else if (i == 1)
				one += 1;

			else
				two += 1;
		}

		int i = 0;
		while (zero > 0) {
			nums[i] = 0;
			zero -= 1;
			i += 1;
		}

		while (one > 0) {
			nums[i] = 1;
			one -= 1;
			i += 1;
		}

		while (two > 0) {
			nums[i] = 2;
			two -= 1;
			i += 1;
		}
	}

	public void anotherSolution(int[] nums) {
		int zero = 0, one = 0, two = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 0)
				zero += 1;
			else if (nums[i] == 1)
				one += 1;
			else
				two += 1;
		}

		for (int i = 0; i < nums.length; i++) {

			if (i < zero)
				nums[i] = 0;
			else if (i >= zero && one > 0) {
				nums[i] = 1;
				one -= 1;
			} else if (i >= zero && i >= one && two > 0) {
				nums[i] = 2;
				two -= 1;
			}
		}
	}
}
