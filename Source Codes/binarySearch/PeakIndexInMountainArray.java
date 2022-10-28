//Link For Problem: https://leetcode.com/problems/peak-index-in-a-mountain-array/

package binarySearch;

public class PeakIndexInMountainArray {

	public int peakIndexInMountainArray(int[] arr) {
		int start = 0, end = arr.length - 1;
		int mid;

		while (start < end) {
			mid = start + (end - start) / 2;

			if (arr[mid] < arr[mid + 1])
				start = mid + 1;
			else
				end = mid;
		}

		return start;
	}
}
