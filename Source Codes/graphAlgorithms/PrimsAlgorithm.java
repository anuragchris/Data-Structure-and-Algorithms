package graphAlgorithms;

public class PrimsAlgorithm {
	private int adjMatrix[][];
	private int vertexCount;

	public PrimsAlgorithm(int totalVertex) {
		this.vertexCount = totalVertex;
		adjMatrix = new int[totalVertex][totalVertex];
	}

	public void addWeight(int source, int destination, int weight) {
		adjMatrix[source][destination] = weight;
		adjMatrix[destination][source] = weight;
	}

	public void prim() {
//		int vertexCount = adjMatrix.length;
		int parent[] = new int[vertexCount];
		int weight[] = new int[vertexCount];
		boolean visited[] = new boolean[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			weight[i] = Integer.MAX_VALUE;
			visited[i] = false;
			parent[i] = -1;
		}
		weight[0] = 0;
		for (int i = 0; i < vertexCount - 1; i++) {
			int u = findMin(weight, visited);
			visited[u] = true;
			for (int j = 0; j < vertexCount; j++) {
				if (adjMatrix[u][j] != 0 && visited[j] == false && adjMatrix[u][j] < weight[j]) {
					parent[j] = u;
					weight[j] = adjMatrix[u][j];
				}
			}
		}
		for (int i = 1; i < vertexCount; i++) {
			System.out.println(parent[i] + "-" + i + " ->" + adjMatrix[i][parent[i]]);
		}
	}

	private int findMin(int weight[], boolean visited[]) {
		int v = weight.length;
		int min = Integer.MAX_VALUE, minIndex = -1;
		for (int i = 0; i < v; i++) {
			if (visited[i] == false && weight[i] < min) {
				min = weight[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
