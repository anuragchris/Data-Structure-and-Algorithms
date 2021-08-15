package graphAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrix {
	private Vertex node[];
	private boolean adjMatrix[][];
	private int vertexCount;
	private Stack<Integer> graphStack;
	private Queue<Integer> graphQueue;

	public AdjacencyMatrix(int totalVertex) {
		node = new Vertex[totalVertex];
		vertexCount = 0;
		adjMatrix = new boolean[totalVertex][totalVertex];
		for (boolean[] row : adjMatrix) {
			Arrays.fill(row, false);
		}
		graphStack = new Stack<Integer>();
		graphQueue = new LinkedList<Integer>();
	}

	public void addVertex(char lab) {
		node[vertexCount++] = new Vertex(lab);
	}

	public void displayVertex(int vertex) {
		System.out.println(node[vertex].label);
	}

	private int getAdjUnvisitedVertex(int v) {
		if (v > vertexCount) {
			return -1;
		}
		for (int i = 0; i < vertexCount; i++) {
			if (adjMatrix[v][i] == true && node[i].visited == false) {
				return i;
			}
		}
		return -1;
	}

	private List<Integer> getAllAdjacentVertex(int v) {
		if (v > vertexCount) {
			return null;
		}
		List<Integer> adj = new ArrayList<Integer>();
		for (int i = 0; i < vertexCount; i++) {
			if (adjMatrix[v][i] == true && node[i].visited == false) {
				adj.add(i);
			}
		}
		return adj;
	}

	public void addEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
			adjMatrix[i][j] = true;
			// adjMatrix[j][i] = true;
		}
	}

	public void removeEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
			adjMatrix[i][j] = false;
			adjMatrix[j][i] = false;
		}
	}

	public boolean isEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
			return adjMatrix[i][j];
		}
		return false;
	}

	public void printRecursiveDFS() {
		for (int i = 0; i < vertexCount; i++) {
			if (node[i].visited == false) {
				recursiveDFS(i);
			}
		}
	}

	private void recursiveDFS(int i) {
		System.out.println(node[i].label);
		node[i].visited = true;
		for (int j = 0; j < vertexCount; j++) {
			if (adjMatrix[i][j] == true && node[j].visited == false) {
				recursiveDFS(j);
			}
		}
	}

	public void printIterativeDFS() {
		node[0].visited = true;
		displayVertex(0);
		graphStack.push(0);
		while (!graphStack.isEmpty()) {
			int v = getAdjUnvisitedVertex(graphStack.peek());
			if (v == -1) {
				graphStack.pop();
			} else {
				node[v].visited = true;
				displayVertex(v);
				graphStack.push(v);
			}
		}
		for (int i = 0; i < vertexCount; i++) {
			node[i].visited = false;
		}
	}

	public void BFSTraversal() {
		node[0].visited = true;
		graphQueue.add(0);
		displayVertex(0);
		int v2;
		while (!graphQueue.isEmpty()) {
			int v1 = graphQueue.poll();
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				node[v2].visited = true;
				displayVertex(v2);
				graphQueue.add(v2);
			}
		}
		for (int i = 0; i < vertexCount; i++) {
			node[i].visited = false;
		}
	}

	public boolean isCyclic() {
		for (int i = 0; i < vertexCount; i++) {
			if (node[i].visited == false) {
				if (detectCycleByDFS(i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean detectCycleByDFS(int src, int parent) {
		node[src].visited = true;
		for (int i = 0; i < vertexCount; i++) {
			int v = getAdjUnvisitedVertex(src);
			if (v == -1) {
				return false;
			}
			boolean temp = node[v].visited;
			if (temp == false) {
				if (detectCycleByDFS(v, src)) {
					return true;
				} else if (v != parent) {
					return true;
				}
			}
		}
		return false;
	}

	public void topologicalSort() {
		Stack<Integer> st = new Stack<Integer>();
		boolean visited[] = new boolean[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				topologicalSortHelper(i, visited, st);
			}
		}
		while (!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}

	private void topologicalSortHelper(int i, boolean visited[], Stack<Integer> st) {
		for (int x : getAllAdjacentVertex(i)) {
			if (visited[x] == false) {
				visited[x] = true;
				topologicalSortHelper(x, visited, st);
			}
		}
		st.push(i);
	}

	public boolean checkPath(int src, int dest) {
		if (src == dest)
			return true;
		boolean visited[] = new boolean[vertexCount];
		visited[src] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		while (!q.isEmpty()) {
			int source = q.poll();
			for (int i : getAllAdjacentVertex(source)) {
				if (i == dest)
					return true;
				visited[i] = true;
				q.add(i);
			}
		}
		return false;
	}
}
