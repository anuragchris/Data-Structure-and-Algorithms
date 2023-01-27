package graphAlgorithms;

public class Dijkstra {
	class Vertex {
		char label;
		boolean visited;

		public Vertex(char lab) {
			label = lab;
			visited = false;
		}
	}

	private Vertex node[];
	private int adjMatrix[][];
	private int vertexCount;

	public Dijkstra(int totalVertex) {
		node = new Vertex[totalVertex];
		vertexCount = 0;
		adjMatrix = new int[totalVertex][totalVertex];
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
			if (adjMatrix[v][i] != 0 && node[i].visited == false) {
				return i;
			}
		}

		return -1;
	}

	public void addWeight(int source, int destination, int weight) {
		adjMatrix[source][destination] = weight;
	}

	public void shortestPathUsingDijkstra(int src) {
		int distance[] = new int[vertexCount];
		int v = adjMatrix.length;

		boolean visited[] = new boolean[v];
		distance[src] = 0;

		for (int i = 0; i < v; i++) {
			if (i == src)
				continue;

			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < v - 1; i++) {
			int minV = findMinV(distance, visited);
			visited[minV] = true;

			for (int j = 0; j < v; j++) {
				if (adjMatrix[minV][j] != 0 && visited[j] == false && distance[minV] != Integer.MAX_VALUE) {
					int newDistance = distance[minV] + adjMatrix[minV][j];

					if (newDistance < distance[j])
						distance[j] = newDistance;
				}
			}
		}

		for (int i = 0; i < distance.length; i++) {
			System.out.println(distance[i]);
		}
	}

	public int findMinV(int distance[], boolean visited[]) {
		int minV = -1;

		for (int i = 0; i < distance.length; i++) {
			if (visited[i] == false && (minV == -1 || distance[i] < distance[minV])) {
				minV = i;
			}
		}

		return minV;
	}
}
