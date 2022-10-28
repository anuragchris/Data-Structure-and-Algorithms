//Link For Problem: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

package binarySearch;

public class CountNegativeNumbersInSortedMatrix {

	public int countNegatives(int[][] grid) {
		int row = grid.length, col = grid[0].length;

		if (grid[0][0] < 0)
			return row * col;

		if (grid[row - 1][col - 1] >= 0)
			return 0;

		int r = row - 1, c = 0, count = 0;

		while (r >= 0 && c < col) {

			if (grid[r][c] < 0) {
				r -= 1;
				count += col - c;
			} else
				c += 1;
		}

		return count;
	}
}
