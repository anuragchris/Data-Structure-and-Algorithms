//Link For Problem: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

package binarySearch;

public class KthSmallestElementInASortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
		int length = matrix.length;
		int low = matrix[0][0], high = matrix[length - 1][length - 1];

		while (low < high) {
			int mid = low + (high - low) / 2;
			int count = count(matrix, mid);

			if (count < k)
				low = mid + 1;
			else
				high = mid;
		}

		return low;
	}

	static int count(int arr[][], int target) {
		int count = 0, len = arr.length, i = len - 1, j = 0;

		while (i >= 0 && j < len) {

			if (arr[i][j] > target)
				i -= 1;
			else {
				count = count + i + 1;
				j += 1;
			}
		}

		return count;
	}
}
