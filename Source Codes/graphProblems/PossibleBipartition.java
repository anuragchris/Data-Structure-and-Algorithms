//Link For Problem : https://leetcode.com/problems/possible-bipartition/

package graphProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PossibleBipartition {
	static boolean possibleBipartition(int n, int[][] dislikes) {
		int color[] = new int[n + 1];
		List<Integer>[] graph = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int v[] : dislikes) {
			graph[v[0]].add(v[1]);
			graph[v[1]].add(v[0]);
		}
		for (int i = 1; i <= n; i++) {
			if (color[i] == 0) {
				LinkedList<Integer> q = new LinkedList<Integer>();
				q.add(i);
				color[i] = 1;
				while (q.size() != 0) {
					int top = q.removeFirst();
					for (int neighour : graph[top]) {
						if (color[neighour] == color[top])
							return false;
						if (color[neighour] == 0) {
							color[neighour] = -color[top];
							q.add(neighour);
						}
					}
				}
			}
		}
		return true;
	}
}
