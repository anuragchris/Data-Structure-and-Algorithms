// Link For Problem : https://www.interviewbit.com/problems/knight-on-chess-board/

package graphProblems;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {
	static class Coordinate {
		int x;
		int y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int knight(int n, int m, int x1, int y1, int x2, int y2) {
		int dx[] = { -1, -2, -1, -2, 1, 2, 1, 2 };
		int dy[] = { -2, -1, 2, 1, -2, -1, 2, 1 };
		boolean isVisited[][] = new boolean[n + 1][m + 1];
		Queue<Coordinate> q = new LinkedList<>();
		q.add(new Coordinate(x1, y1));
		isVisited[x1][y1] = true;
		int count = 0;
		while (!q.isEmpty()) {
			int nodesAtCurrentBreadth = q.size();
			for (int i = 0; i < nodesAtCurrentBreadth; i++) {
				Coordinate curr = q.remove();
				if (curr.x == x2 && curr.y == y2) {
					return count;
				}
				for (int j = 0; j < 8; j++) {
					if (isValid(curr.x + dx[j], curr.y + dy[j], n, m)
							&& isVisited[curr.x + dx[j]][curr.y + dy[j]] == false) {
						q.add(new Coordinate(curr.x + dx[j], curr.y + dy[j]));
						isVisited[curr.x + dx[j]][curr.y + dy[j]] = true;
					}
				}
			}
			count++;
		}
		return -1;
	}

	private static boolean isValid(int x, int y, int n, int m) {
		if (x <= 0 || y <= 0 || x > n || y > m) {
			return false;
		}
		return true;
	}
}
