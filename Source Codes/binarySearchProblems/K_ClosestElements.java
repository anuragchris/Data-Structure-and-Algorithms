//Link For Problem: https://leetcode.com/problems/find-k-closest-elements/

package binarySearchProblems;

import java.util.ArrayList;
import java.util.List;

public class K_ClosestElements {
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> al = new ArrayList<Integer>();
		if (arr.length == k) {
			for (int i = 0; i < k; i++) {
				al.add(arr[i]);
			}

			return al;
		}
		int closest = binarySearch(arr, 0, arr.length - 1, x);
		int l = ((closest - k) < 0) ? (0) : closest - k;
		int r = ((closest + k) > arr.length - 1) ? ((arr.length - 1)) : (closest + k);

		while ((r - l + 1) != k) {
			int leftDiff = Math.abs(x - arr[l]);
			int rightDiff = Math.abs(arr[r] - x);

			if (leftDiff <= rightDiff)
				r -= 1;
			else
				l += 1;
		}

		while (l <= r) {
			al.add(arr[l]);
			l += 1;
		}

		return al;
	}

	static int binarySearch(int arr[], int low, int high, int x) {
		if (arr[high] <= x)
			return high;

		if (arr[low] >= x)
			return low;

		int mid = low + (high - low) / 2;

		if (arr[mid] <= x && arr[mid + 1] > x)
			return mid;

		if (arr[mid] < x)
			return binarySearch(arr, mid + 1, high, x);

		return binarySearch(arr, low, mid - 1, x);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int k = 4, x = 3;
		List<Integer> al = findClosestElements(arr, k, x);
		for (int i : al)
			System.out.print(i + " ");
	}
}

