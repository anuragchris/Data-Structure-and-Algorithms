package graphAlgorithms;

import java.util.Arrays;

class bellmanFordEdge {
	int src;
	int dest;
	int weight;
}

public class BellmanFord {
	private int vertexCount;
	private int edgeCount;
	private bellmanFordEdge edge[];
	private int count = 0;

	public BellmanFord(int totalVertex, int totalEdge) {
		this.vertexCount = totalVertex;
		edge = new bellmanFordEdge[totalEdge];
		this.edgeCount = totalEdge;
	}

	public void addVerticesWithEdgeAndWeight(int source, int destination, int userWeight) {
		edge[count] = new bellmanFordEdge();
		edge[count].src = source;
		edge[count].dest = destination;
		edge[count].weight = userWeight;
		count++;
	}

	public void bellmanFord() {
		int parent[] = new int[vertexCount];
		int value[] = new int[vertexCount];
		Arrays.fill(value, Integer.MAX_VALUE);
		parent[0] = -1;
		value[0] = 0;
		boolean updated = false;
		for (int i = 0; i < vertexCount - 1; i++) {
			updated = false;
			for (int j = 0; j < edgeCount; j++) {
				int src = edge[j].src;
				int dest = edge[j].dest;
				int weight = edge[j].weight;
				if (value[src] != Integer.MAX_VALUE && value[src] + weight < value[dest]) {
					value[dest] = value[src] + weight;
					parent[dest] = src;
					updated = true;
				}
			}
			if (updated == false) {
				break;
			}
		}
		for (int j = 0; j < edgeCount && updated; ++j) {
			int src = edge[j].src;
			int dest = edge[j].dest;
			int weight = edge[j].weight;
			if (value[src] != Integer.MAX_VALUE && value[src] + weight < value[dest]) {
				System.out.println("Graph has Negative Edge Cycle");
				return;
			}
		}
		for (int i = 0; i < vertexCount; i++) {
			if (i == 0)
				System.out.println("0");
			else
				System.out.println(parent[i] + " -> " + i + " -> " + value[i]);
		}
	}
}
