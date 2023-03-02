//Link For Problem: https://leetcode.com/problems/redundant-connection/

package graphProblems;

public class RedundantConnection {

	public int[] findRedundantConnection(int[][] edges) {
		int parent[] = new int[edges.length + 1];

		for (int i = 0; i < parent.length; i++)
			parent[i] = i;

		for (int edge[] : edges) {
			if (find(edge[0], parent) == find(edge[1], parent))
				return edge;

			union(edge[0], edge[1], parent);
		}

		return new int[] { -1, -1 };
	}

	public int find(int node, int parent[]) {
		while (parent[node] != node)
			node = parent[node];

		return node;
	}

	public void union(int x, int y, int parent[]) {
		int xRoot = find(x, parent), yRoot = find(y, parent);

		if (xRoot != yRoot)
			parent[yRoot] = xRoot;
	}
}
