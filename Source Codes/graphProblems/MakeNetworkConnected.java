//Link For Problem : https://leetcode.com/problems/number-of-operations-to-make-network-connected/

package graphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GraphList {
	private int vertexCount;
	List<Integer>[] adjList;

	public GraphList(int totalVertex) {
		this.vertexCount = totalVertex;
		adjList = new ArrayList[totalVertex];
		for (int i = 0; i < totalVertex; i++)
			adjList[i] = new ArrayList<Integer>();
	}

	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}
}

public class MakeNetworkConnected {
	public int makeConnected(int n, int[][] connections) {
		GraphList graph = new GraphList(n);
		boolean visited[] = new boolean[n];
		Arrays.fill(visited, false);
		int edgeCount = 0;
		for (int c[] : connections) {
			graph.addEdge(c[1], c[0]);
			graph.addEdge(c[0], c[1]);
			edgeCount++;
		}
		if (edgeCount < n - 1)
			return -1;
		int component = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				component++;
				dfs(i, graph, visited);
			}
		}
		int red = edgeCount - ((n - 1) - (component - 1));
		if (red >= (component - 1))
			return (component - 1);
		return -1;
	}

	void dfs(int current, GraphList graph, boolean visited[]) {
		visited[current] = true;
		for (int i : graph.adjList[current]) {
			if (visited[i] == false)
				dfs(i, graph, visited);
		}
	}
}
