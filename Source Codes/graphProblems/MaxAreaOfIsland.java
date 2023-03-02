// Link For Problem: https://leetcode.com/problems/max-area-of-island/

package graphProblems;

import java.util.Stack;

public class MaxAreaOfIsland {

	public int maxAreaOfIsland(int[][] grid) {
		boolean seen[][] = new boolean[grid.length][grid[0].length];

		int ans = 0;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				ans = Math.max(ans, area(row, col, seen, grid));
			}
		}

		return ans;
	}

	public int area(int row, int col, boolean seen[][], int grid[][]) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || seen[row][col])
			return 0;

		seen[row][col] = true;

		return 1 + area(row + 1, col, seen, grid) + area(row - 1, col, seen, grid) + area(row, col + 1, seen, grid)
		        + area(row, col - 1, seen, grid);
	}

	public int iterativeSolution(int[][] grid) {
		boolean seen[][] = new boolean[grid.length][grid[0].length];
		int dr[] = new int[] { 1, -1, 0, 0 };
		int dc[] = new int[] { 0, 0, 1, -1 };

		int ans = 0;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {

				if (grid[row][col] == 1 && !seen[row][col]) {
					int shape = 0;

					Stack<int[]> st = new Stack<>();
					st.push(new int[] { row, col });

					seen[row][col] = true;

					while (!st.isEmpty()) {
						int node[] = st.pop();
						int r = node[0], c = node[1];
						shape += 1;

						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k], nc = c + dc[k];

							if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1
							        && !seen[nr][nc])
							{
								st.push(new int[] { nr, nc });
								seen[nr][nc] = true;
							}
						}
					}

					ans = Math.max(ans, shape);
				}
			}
		}

		return ans;
	}
}
