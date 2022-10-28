//Link For Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/

package binarySearch;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			return findMedianSortedArrays(nums2, nums1);

		int x = nums1.length, y = nums2.length;

		int start = 0, end = x;

		while (start <= end) {
			int i = (start + end) / 2;
			int j = (x + y + 1) / 2 - i;

			int minX = i <= 0 ? Integer.MIN_VALUE : nums1[i - 1];
			int maxX = i == x ? Integer.MAX_VALUE : nums1[i];

			int minY = j <= 0 ? Integer.MIN_VALUE : nums2[j - 1];
			int maxY = j == y ? Integer.MAX_VALUE : nums2[j];

			if (minY <= maxX && minX <= maxY) {

				if ((x + y) % 2 == 0)
					return ((double) Math.max(minX, minY) + Math.min(maxX, maxY)) / 2;
				else
					return Math.max(minX, minY);
			}

			else if (minX >= maxY)
				end = i - 1;

			else
				start = i + 1;
		}

		return 0.0;
	}
}
