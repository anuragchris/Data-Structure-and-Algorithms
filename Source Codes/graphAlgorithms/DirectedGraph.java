package graphAlgorithms;

import java.util.ArrayList;

public class DirectedGraph {
	private int vertexCount;
	ArrayList<ArrayList<Integer>> list;

	public DirectedGraph(int totalVertex) {
		this.vertexCount = totalVertex;
		list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < totalVertex; i++) {
			list.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int src, int dest) {
		list.get(src).add(dest);
	}

	public boolean isCyclic() {
		boolean visited[] = new boolean[vertexCount];
		boolean helper[] = new boolean[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			if (visited[i] == false) {
				boolean ans = dfs(i, visited, helper);
				if (ans == true)
					return true;
			}
		}
		return false;
	}

	private boolean dfs(int i, boolean visited[], boolean helper[]) {
		visited[i] = true;
		helper[i] = true;
		ArrayList<Integer> neighours = list.get(i);
		for (int k = 0; k < neighours.size(); k++) {
			int current = neighours.get(k);
			if (helper[current] == true)
				return true;
			if (visited[current] == false) {
				boolean ans = dfs(current, visited, helper);
				if (ans == true)
					return true;
			}
		}
		helper[i] = false;
		return false;
	}

	public static void main(String[] args) {
	}
}
