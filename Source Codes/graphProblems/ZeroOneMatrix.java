//Link For Problem: https://leetcode.com/problems/01-matrix/

package graphProblems;

import java.util.ArrayDeque;
import java.util.Queue;

public class ZeroOneMatrix {

	int DIR[] = { 0, 1, 0, -1, 0 };

	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		Queue<int[]> q = new ArrayDeque<int[]>();

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {

				if (mat[r][c] == 0)
					q.offer(new int[] { r, c });
				else
					mat[r][c] = -1;
			}
		}

		while (!q.isEmpty()) {
			int curr[] = q.poll();
			int r = curr[0], c = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + DIR[i], nc = c + DIR[i + 1];

				if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1)
					continue;

				mat[nr][nc] = mat[r][c] + 1;
				q.offer(new int[] { nr, nc });
			}
		}

		return mat;
	}
}
