package graphAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class TarjansAlgorithm {
	private int adjMatrix[][];
	private int vertexCount;
	static int time = 0;

	public TarjansAlgorithm(int totalVertex) {
		this.vertexCount = totalVertex;
		adjMatrix = new int[totalVertex][totalVertex];
	}

	public void addEdge(int source, int destination) {
		adjMatrix[source][destination] = 1;
	}

	private List<Integer> getAllAdjacentVertex(int v) {
		if (v > vertexCount) {
			return null;
		}
		boolean visited[] = new boolean[vertexCount];
		List<Integer> adj = new ArrayList<Integer>();
		for (int i = 0; i < vertexCount; i++) {
			if (adjMatrix[v][i] == 1 && visited[i] == false) {
				adj.add(i);
				visited[i] = true;
			}
		}
		return adj;
	}

	public void tarjanUsingDFS() {
		time = 0;
		int disc[] = new int[vertexCount];
		Arrays.fill(disc, -1);
		int low[] = new int[vertexCount];
		Arrays.fill(low, -1);
		boolean inStack[] = new boolean[vertexCount];
		Arrays.fill(inStack, false);
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < vertexCount; i++) {
			if (disc[i] == -1)
				dfs(i, disc, low, st, inStack);
		}
	}

	private void dfs(int u, int disc[], int low[], Stack<Integer> st, boolean inStack[]) {
		disc[u] = low[u] = time;
		time += 1;
		st.push(u);
		inStack[u] = true;
		for (int v : getAllAdjacentVertex(u)) {
			if (disc[v] == -1) {
				dfs(v, disc, low, st, inStack);
				low[u] = Math.min(low[u], low[v]);
			}
			// Differentiate back-edge and cross-edge
			else if (inStack[v]) // Back-edge case
				low[u] = Math.min(low[u], disc[v]);
		}
		// u is head of SCC
		if (low[u] == disc[u]) {
			System.out.print("SCC is : ");
			while (st.peek() != u) {
				System.out.print(st.peek() + " ");
				inStack[st.peek()] = false;
				st.pop();
			}
			System.out.print(st.peek());
			inStack[st.peek()] = false;
			st.pop();
			System.out.println();
		}
	}

	public void articulatePoints() {
		time = 0;
		int disc[] = new int[vertexCount];
		Arrays.fill(disc, -1);
		int low[] = new int[vertexCount];
		Arrays.fill(low, -1);
		int parent[] = new int[vertexCount];
		Arrays.fill(parent, -1);
		boolean ap[] = new boolean[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			if (disc[i] == -1)
				APusingDFS(i, disc, low, parent, ap);
		}
		System.out.print("Articulation Points are : ");
		for (int i = 0; i < vertexCount; i++) {
			if (ap[i] == true)
				System.out.print(i + " ");
		}
	}

	private void APusingDFS(int u, int disc[], int low[], int parent[], boolean ap[]) {
		disc[u] = low[u] = time;
		time += 1;
		int children = 0;
		for (int v : getAllAdjacentVertex(u)) {
			if (disc[v] == -1) {
				children += 1;
				parent[v] = u;
				APusingDFS(v, disc, low, parent, ap);
				low[u] = Math.min(low[u], low[v]);
				if (parent[u] == -1 && children > 1) // Case 1 : u is root
					ap[u] = true;
				if (parent[u] != -1 && low[v] >= disc[u]) // Case 2 : Atleast 1 component will get seperated
					ap[u] = true;
			} else if (v != parent[u]) // Ignore Child To Parent Edge
				low[u] = Math.min(low[u], disc[v]);
		}
	}

	public void findBridgesUsingDfs() {
		time = 0;
		Map<Integer, Integer> bridge = new HashMap<Integer, Integer>();
		int disc[] = new int[vertexCount];
		Arrays.fill(disc, -1);
		int low[] = new int[vertexCount];
		Arrays.fill(low, -1);
		int parent[] = new int[vertexCount];
		Arrays.fill(parent, -1);
		for (int i = 0; i < vertexCount; i++) {
			if (disc[i] == -1)
				bridge(i, disc, low, parent, bridge);
		}
		System.out.print("Bridges are : ");
		for (Entry<Integer, Integer> mp : bridge.entrySet()) {
			System.out.print("(" + mp.getKey() + "," + mp.getValue() + ") ");
		}
	}

	private void bridge(int u, int disc[], int low[], int parent[], Map<Integer, Integer> bridge) {
		disc[u] = low[u] = time;
		time += 1;
		for (int v : getAllAdjacentVertex(u)) {
			if (disc[v] == -1) {
				parent[v] = u;
				bridge(v, disc, low, parent, bridge);
				low[u] = Math.min(low[u], low[v]);
				if (low[v] > disc[u]) {
					bridge.put(u, v);
				}
			} else if (v != parent[u]) {
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}
}
