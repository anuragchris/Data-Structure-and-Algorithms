//Link For Problem: https://leetcode.com/problems/pacific-atlantic-water-flow/

package graphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantaWaterFlow {

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int row = heights.length, col = heights[0].length;

		boolean pacific[][] = new boolean[row][col];
		boolean atlantic[][] = new boolean[row][col];

		for (int i = 0; i < col; i++) {
			dfs(0, i, pacific, heights[0][i], heights);
			dfs(row - 1, i, atlantic, heights[row - 1][i], heights);
		}

		for (int i = 0; i < row; i++) {
			dfs(i, 0, pacific, heights[i][0], heights);
			dfs(i, col - 1, atlantic, heights[i][col - 1], heights);
		}

		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (pacific[i][j] && atlantic[i][j])
					res.add(Arrays.asList(i, j));
			}
		}

		return res;
	}

	void dfs(int row, int col, boolean visited[][], int prevHeight, int heights[][]) {
		if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visited[row][col]
		        || prevHeight > heights[row][col])
			return;

		visited[row][col] = true;

		dfs(row + 1, col, visited, heights[row][col], heights);
		dfs(row - 1, col, visited, heights[row][col], heights);
		dfs(row, col + 1, visited, heights[row][col], heights);
		dfs(row, col - 1, visited, heights[row][col], heights);
	}
}
