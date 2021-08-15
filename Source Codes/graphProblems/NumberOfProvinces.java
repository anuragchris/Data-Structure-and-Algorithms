//Link For Problem : https://leetcode.com/problems/number-of-provinces/

package graphProblems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
	static int findCircleNum(int[][] isConnected) {
		int ans = 0;
		ans = BFS(ans, isConnected);
		return ans;
	}

	static int BFS(int ans, int isConnected[][]) {
		int v = isConnected.length;
		boolean visited[] = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (visited[i] == false) {
				ans++;
				BFSHelper(isConnected, i, visited, v);
			}
		}
		return ans;
	}

	static void BFSHelper(int isConnected[][], int sv, boolean visited[], int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(sv);
		visited[sv] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < v; i++) {
				if (isConnected[temp][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
