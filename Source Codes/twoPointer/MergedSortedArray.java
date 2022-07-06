//Link For Problem: https://leetcode.com/problems/merge-sorted-array/

package twoPointer;

public class MergedSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, idx = m + n - 1;

		while (j >= 0) {

			if (i >= 0 && nums1[i] > nums2[j]) {
				nums1[idx] = nums1[i];
				i -= 1;
				idx -= 1;
			}

			else {
				nums1[idx] = nums2[j];
				j -= 1;
				idx -= 1;
			}
		}
	}
}
