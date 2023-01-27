package graphAlgorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyList {

	private int vertexCount;

	private LinkedList<Integer> adjList[];

	@SuppressWarnings("unchecked")
	public AdjacencyList(int vertexCount) {
		this.vertexCount = vertexCount;
		this.adjList = new LinkedList[vertexCount];

		for (int i = 0; i < vertexCount; i++)
			adjList[i] = new LinkedList<>();
	}

	public void addEdge(int v, int w) {
		adjList[v].add(w);
		adjList[w].add(v);
	}

	public void recursiveDFS() {
		boolean visited[] = new boolean[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i])
				recursiveDFSUtil(i, visited);
		}
	}

	private void recursiveDFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.println(v + " ");

		Iterator<Integer> it = adjList[v].listIterator();

		while (it.hasNext()) {
			int current = it.next();

			if (!visited[current])
				recursiveDFSUtil(current, visited);
		}
	}

	public void iterativeDFS() {
		boolean visited[] = new boolean[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i])
				iterativeDFSUtil(i, visited);
		}
	}

	private void iterativeDFSUtil(int v, boolean visited[]) {
		Stack<Integer> st = new Stack<>();
		st.push(v);

		while (!st.isEmpty()) {
			int current = st.pop();

			if (!visited[current]) {
				System.out.println(current + " ");
				visited[current] = true;
			}

			Iterator<Integer> it = adjList[current].listIterator();

			while (it.hasNext()) {
				int temp = it.next();

				if (!visited[temp])
					st.push(temp);
			}
		}
	}

	public void BFSForConnectedGraph(int source) {
		boolean visited[] = new boolean[vertexCount];

		Queue<Integer> q = new LinkedList<Integer>();

		visited[source] = true;
		q.add(source);

		while (!q.isEmpty()) {
			int current = q.poll();
			System.out.println(current + " ");

			Iterator<Integer> it = adjList[current].listIterator();

			while (it.hasNext()) {
				int temp = it.next();

				if (!visited[temp]) {
					visited[temp] = true;
					q.add(temp);
				}
			}
		}
	}

	public void BFSForDisconnectedGraph(int source) {
		boolean visited[] = new boolean[vertexCount];

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i]) {
				q.add(i);

				while (!q.isEmpty()) {
					int current = q.poll();
					visited[current] = true;
					System.out.println(current);

					Iterator<Integer> it = adjList[current].listIterator();

					while (it.hasNext()) {
						int temp = it.next();

						if (!visited[temp]) {
							visited[temp] = true;
							q.add(temp);
						}
					}
				}
			}
		}
	}

	public boolean isCyclicForDirectedGraph() {
		boolean visited[] = new boolean[vertexCount];
		boolean recStack[] = new boolean[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			if (isCyclicUtilForDirectedGraph(i, visited, recStack))
				return true;
		}

		return false;
	}

	private boolean isCyclicUtilForDirectedGraph(int current, boolean visited[], boolean recStack[]) {
		if (recStack[current])
			return true;

		if (visited[current])
			return false;

		visited[current] = true;
		recStack[current] = true;

		Iterator<Integer> it = adjList[current].listIterator();

		while (it.hasNext()) {
			if (isCyclicUtilForDirectedGraph(it.next(), visited, recStack))
				return true;
		}

		recStack[current] = false;

		return false;
	}

	public boolean isCyclicForUndirectedGraph() {
		boolean visited[] = new boolean[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i]) {
				if (isCyclicUtilForUndirectedGraph(i, -1, visited))
					return true;
			}
		}

		return false;
	}

	private boolean isCyclicUtilForUndirectedGraph(int current, int parent, boolean visited[]) {
		visited[current] = true;

		Iterator<Integer> it = adjList[current].listIterator();

		while (it.hasNext()) {
			int temp = it.next();

			if (!visited[temp]) {
				if (isCyclicUtilForUndirectedGraph(temp, current, visited))
					return true;
			}

			else if (temp != parent)
				return true;
		}

		return false;
	}

	public void topologicalSort() {
		boolean visited[] = new boolean[vertexCount];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i])
				topologicalSortUtil(i, visited, st);
		}

		while (!st.isEmpty())
			System.out.println(st.pop());
	}

	private void topologicalSortUtil(int current, boolean visited[], Stack<Integer> st) {
		visited[current] = true;

		Iterator<Integer> it = adjList[current].listIterator();

		while (it.hasNext()) {
			int temp = it.next();

			while (!visited[temp]) {
				topologicalSortUtil(temp, visited, st);
			}
		}

		st.push(current);
	}
}
