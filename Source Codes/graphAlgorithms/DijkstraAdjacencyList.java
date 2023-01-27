package graphAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

class Node implements Comparator<Node> {
	public int node;
	public int cost;

	public Node() {
	} //empty constructor 

	public Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compare(Node node1, Node node2) {
		if (node1.cost < node2.cost)
			return -1;

		if (node1.cost > node2.cost)
			return 1;

		return 0;
	}
}

public class DijkstraAdjacencyList {
	private int vertexCount;
	private ArrayList<Node> adjList[];

	@SuppressWarnings("unchecked")
	public DijkstraAdjacencyList(int vertexCount) {
		this.vertexCount = vertexCount;
		this.adjList = new ArrayList[vertexCount];

		for (int i = 0; i < vertexCount; i++)
			adjList[i] = new ArrayList<>();
	}

	public void addEdge(int v, Node w) {
		adjList[v].add(w);
	}

	public void dijkstra(int source) {
		int distance[] = new int[vertexCount];
		Set<Integer> visited = new HashSet<>();
		PriorityQueue<Node> pq = new PriorityQueue<>(vertexCount, new Node());

		for (int i = 0; i < vertexCount; i++) {
			if (i == source)
				continue;

			distance[i] = Integer.MAX_VALUE;
		}

		pq.add(new Node(source, 0));

		while (visited.size() != vertexCount) {
			int u = pq.poll().node;

			visited.add(u);

			Iterator<Node> it = adjList[u].listIterator();

			while (it.hasNext()) {
				Node temp = it.next();

				if (!visited.contains(temp.node)) {
					int value = temp.node, edgeDistance = temp.cost;
					int newDistance = distance[u] + edgeDistance;

					if (newDistance < distance[value])
						distance[value] = newDistance;

					pq.add(new Node(value, distance[value]));
				}
			}
		}

		for (int i = 0; i < vertexCount; i++)
			System.out.println(source + " \t\t " + i + " \t\t " + distance[i]);
	}
}
