//Link For Problem: https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/

package binarySearch;

public class MinimumLimitOfBallsInABag {

	public int minimumSize(int[] nums, int maxOperations) {
		int start = 1, end = Integer.MIN_VALUE;

		for (int i : nums)
			end = Math.max(end, i);

		int penalty = end;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (isPossible(nums, maxOperations, mid)) {
				penalty = mid;
				end = mid - 1;
			} else
				start = mid + 1;
		}

		return penalty;
	}

	boolean isPossible(int nums[], int maxOperations, int penalty) {
		int required = 0;

		for (int n : nums) {
			int x = n / penalty;

			if (n % penalty == 0)
				x -= 1;

			required += x;
		}

		return required <= maxOperations;
	}
}
