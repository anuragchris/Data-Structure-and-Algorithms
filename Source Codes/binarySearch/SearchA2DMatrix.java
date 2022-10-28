//Link For Problem: https://leetcode.com/problems/search-a-2d-matrix/

package binarySearch;

public class SearchA2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length, col = matrix[0].length;

		if (row == 0 || col == 0)
			return false;

		int start = 0, end = (row * col) - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			int temp = matrix[mid / col][mid % col];

			if (target == temp)
				return true;

			else if (target < temp)
				end = mid - 1;

			else
				start = mid + 1;
		}

		return false;
	}
}
