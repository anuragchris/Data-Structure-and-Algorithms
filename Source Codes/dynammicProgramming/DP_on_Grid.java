package dynammicProgramming;

import java.util.Stack;

public class DP_on_Grid {

	//Link For Problem : https://leetcode.com/problems/unique-paths/
	public int uniquePaths(int m, int n) {
		int dp[][] = new int[m][n];

		for (int row = 0; row < dp.length; row++)
			dp[row][0] = 1;

		for (int col = 0; col < dp[0].length; col++)
			dp[0][col] = 1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	//Link For Problem : https://leetcode.com/problems/unique-paths-ii/
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int rows = obstacleGrid.length, cols = obstacleGrid[0].length;

		if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1)
			return 0;

		int dp[][] = new int[rows][cols];
		boolean flag = false;

		for (int i = 0; i < cols; i++) {
			if (flag || obstacleGrid[0][i] == 1) {
				flag = true;
				dp[0][i] = 0;
			} else
				dp[0][i] = 1;
		}
		flag = false;
		for (int i = 0; i < rows; i++) {
			if (flag || obstacleGrid[i][0] == 1) {
				flag = true;
				dp[i][0] = 0;
			} else
				dp[i][0] = 1;
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (obstacleGrid[i][j] == 1)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[rows - 1][cols - 1];
	}

	//Link For Problem : https://leetcode.com/problems/minimum-path-sum/
	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;

		if (m == 0)
			return 0;

		int dp[][] = new int[m][n];
		dp[0][0] = grid[0][0];

		for (int i = 1; i < m; i++)
			dp[i][0] = dp[i - 1][0] + grid[i][0];

		for (int i = 1; i < n; i++)
			dp[0][i] = dp[0][i - 1] + grid[0][i];

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[m - 1][n - 1];
	}

	//Link For Problem : https://leetcode.com/problems/maximal-square/
	public int maximalSquare(char[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return 0;
		int col = matrix[0].length;
		int dp[][] = new int[row + 1][col + 1];
		int largest = 0;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
					largest = Math.max(largest, dp[i][j]);
				}
			}
		}
		return largest * largest;
	}

	//Link For Problem : https://leetcode.com/problems/largest-rectangle-in-histogram/
	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int left[] = new int[n];
		int right[] = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			if (st.isEmpty()) {
				left[i] = 0;
				st.push(i);
			} else {
				while (!st.isEmpty() && heights[st.peek()] >= heights[i])
					st.pop();
				left[i] = st.isEmpty() ? 0 : st.peek() + 1;
				st.push(i);
			}
		}
		st.clear();
		for (int i = n - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				right[i] = n - 1;
				st.push(i);
			} else {
				while (!st.isEmpty() && heights[st.peek()] >= heights[i])
					st.pop();
				right[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
				st.push(i);
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, heights[i] * (right[i] - left[i] + 1));
		}
		return ans;
	}
}
