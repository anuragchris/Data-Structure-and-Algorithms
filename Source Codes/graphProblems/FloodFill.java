//Link For Problem : https://leetcode.com/problems/flood-fill/

package graphProblems;

public class FloodFill {
	static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (newColor == image[sr][sc]) {
			return image;
		}
		dfs(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	static void dfs(int image[][], int row, int col, int newColor, int oldColor) {
		if (row >= image.length || row < 0 || col < 0 || col >= image[0].length || image[row][col] != oldColor) {
			return;
		}
		image[row][col] = newColor;
		dfs(image, row + 1, col, newColor, oldColor);
		dfs(image, row - 1, col, newColor, oldColor);
		dfs(image, row, col + 1, newColor, oldColor);
		dfs(image, row, col - 1, newColor, oldColor);
	}
}
