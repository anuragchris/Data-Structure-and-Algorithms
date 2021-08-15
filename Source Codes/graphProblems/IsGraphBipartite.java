//Link For Problem : https://leetcode.com/problems/is-graph-bipartite/

package graphProblems;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
	static boolean isBipartite(int[][] graph) {
		int len = graph.length;
		int colors[] = new int[len];
		for (int i = 0; i < len; i++) {
			if (colors[i] == 1 || colors[i] == -1)
				continue;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(i);
			colors[i] = 1;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int next : graph[cur]) {
					if (colors[next] == 0) {
						colors[next] = -colors[cur];
						q.add(next);
					}
					if (colors[next] == colors[cur]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
