//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

package binarySearch;

public class FindSmallestDivisorGivenAThreshold {

	public int smallestDivisor(int[] nums, int threshold) {
		int left = 1, right = (int) 1e6;

		while (left < right) {
			int mid = left + (right - left) / 2;

			int sum = 0;

			for (int i : nums)
				sum += (i + mid - 1) / mid;

			if (sum > threshold)
				left = mid + 1;
			else
				right = mid;
		}

		return left;
	}
}
