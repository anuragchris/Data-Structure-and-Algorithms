package graphAlgorithms;

import java.util.Arrays;

class Kruskal_Edge implements Comparable<Kruskal_Edge> {
	int src;
	int dest;
	int weight;

	@Override
	public int compareTo(Kruskal_Edge compare) {
		return this.weight - compare.weight;
	}
}

public class KruskalsAlgorithm {
	private int vertexCount;
	private int edgeCount;
	private Kruskal_Edge ke[];
	private int count;

	public KruskalsAlgorithm(int vertex, int edge) {
		this.vertexCount = vertex;
		this.edgeCount = edge;
		ke = new Kruskal_Edge[edge];
		this.count = 0;
	}

	public void addVerticesWithEdgeAndWeight(int source, int destination, int userWeight) {
		ke[count] = new Kruskal_Edge();
		ke[count].src = source;
		ke[count].dest = destination;
		ke[count].weight = userWeight;
		count++;
	}

	public void kruskalMST() {
		Arrays.sort(ke);

		Kruskal_Edge op[] = new Kruskal_Edge[vertexCount - 1];

		int k = 0;
		int parent[] = new int[vertexCount];

		for (int i = 0; i < vertexCount; i++)
			parent[i] = i;

		for (int i = 0; i < edgeCount; i++) {
			if (k == vertexCount - 1)
				break;

			Kruskal_Edge current = ke[i];
			int src_parent = find(current.src, parent);
			int dest_parent = find(current.dest, parent);

			if (src_parent != dest_parent) {
				op[k] = current;
				k++;
				parent[src_parent] = dest_parent;
			}
		}

		for (int i = 0; i < op.length; i++) {
			System.out.println(op[i].src + " ->" + op[i].dest + " ->" + op[i].weight);
		}
	}

	private int find(int v, int parent[]) {
		if (parent[v] == v) {
			return v;
		}
		return find(parent[v], parent);
	}
}
