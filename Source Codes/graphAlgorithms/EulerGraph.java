package graphAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;

public class EulerGraph {
	private int vertexCount;
	private LinkedList<Integer> list[];

	public EulerGraph(int totalVertex) {
		this.vertexCount = totalVertex;
		list = new LinkedList[totalVertex];
		for (int i = 0; i < totalVertex; i++) {
			list[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int src, int dest) {
		list[src].addFirst(dest);
	}

	private boolean isConnectedGraph() {
		boolean visited[] = new boolean[vertexCount];
		Arrays.fill(visited, false);
		int node = -1;
		for (int i = 0; i < vertexCount; i++) {
			if (list[i].size() > 0) {
				node = i;
				break;
			}
		}
		if (node == -1) //// No start node was found-->No edges are present in graph
			return true; // It's always Eulerian

		dfs(node, visited);

		// Check if all the non-zero vertices are visited
		for (int i = 0; i < vertexCount; i++) {
			if (visited[i] == false && list[i].size() > 0)
				return false; // We have edges in multi-component
		}
		return true;
	}

	private void dfs(int current, boolean visited[]) {
		visited[current] = true;
		for (int var : list[current]) {
			if (!visited[var])
				dfs(var, visited);
		}
	}

	private int findEuler() {
		if (!isConnectedGraph()) // multi-component edged graph
			return 0; // All non-zero degree vertices should be connected

		// Count odd-degree vertices
		int odd = 0;
		for (int i = 0; i < vertexCount; i++) {
			if (list[i].size() % 2 != 0)
				odd += 1;
		}
		if (odd > 2) // Only start and end node can have odd degree
			return 0;
		return (odd == 0) ? 2 : 1; // 1->Semi-Eulerian...2->Eulerian
	}

	public void findEulerPathCycle() {
		int ret = findEuler();
		if (ret == 0)
			System.out.println("Graph is Not a Euler Graph");
		else if (ret == 1)
			System.out.println("Graph is Semi - Eulerian");
		else
			System.out.println("Graph is Eulerian");
	}
}
