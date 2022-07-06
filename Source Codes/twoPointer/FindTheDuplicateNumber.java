//Link For Problem: https://leetcode.com/problems/find-the-duplicate-number/

package twoPointer;

public class FindTheDuplicateNumber {

	public int findDuplicate(int[] nums) {
		int duplicate = -1;

		for (int i = 0; i < nums.length; i++) {
			int current = Math.abs(nums[i]);

			if (nums[current] < 0) {
				duplicate = current;
				break;
			}

			nums[current] *= -1;
		}

		for (int i = 0; i < nums.length; i++)
			nums[i] = Math.abs(nums[i]);

		return duplicate;
	}

	public int floydCycleDetection(int nums[]) {
		int slow = 0, fast = 0;
		boolean flag = true;

		while (flag) {
			slow = nums[slow];
			fast = nums[nums[fast]];

			if (slow == fast)
				break;
		}

		int slow2 = 0;

		while (flag) {
			slow = nums[slow];
			slow2 = nums[slow2];

			if (slow == slow2)
				return slow;
		}

		return -1;
	}

	public int anotherSolution(int nums[]) {
		// Find the intersection point of the two runners.
		int tortoise = nums[0];
		int hare = nums[0];

		do {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		} while (tortoise != hare);

		// Find the "entrance" to the cycle.
		tortoise = nums[0];

		while (tortoise != hare) {
			tortoise = nums[tortoise];
			hare = nums[hare];
		}

		return hare;
	}
}
