//Link For Problem: https://leetcode.com/problems/longest-mountain-in-array/

package twoPointer;

public class LongestMountainInArray {

	public int longestMountain(int[] arr) {
		int n = arr.length;
		int ans = 0, base = 0;

		while (base < n) {
			int end = base;

			if (end + 1 < n && arr[end + 1] > arr[end]) {

				while (end + 1 < n && arr[end + 1] > arr[end])
					end += 1;

				if (end + 1 < n && arr[end + 1] < arr[end]) {

					while (end + 1 < n && arr[end + 1] < arr[end])
						end += 1;

					ans = Math.max(ans, end - base + 1);
				}
			}

			base = Math.max(end, base + 1);
		}

		return ans;
	}
}
