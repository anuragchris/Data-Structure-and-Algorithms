//Link For Problem : https://leetcode.com/problems/course-schedule-ii/

package graphProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Graph {
	private int vertexCount;
	List<Integer>[] adjList;

	public Graph(int totalVertex) {
		this.vertexCount = totalVertex;
		adjList = new ArrayList[totalVertex];
		for (int i = 0; i < totalVertex; i++)
			adjList[i] = new ArrayList<Integer>();
	}

	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}
}

public class CourseSchedule_2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		GraphList graph = new GraphList(numCourses);
		for (int pre[] : prerequisites) {
			graph.addEdge(pre[1], pre[0]);
		}
		Deque<Integer> stack = new ArrayDeque<>();
		boolean visited[] = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			boolean onPath[] = new boolean[numCourses];
			if (!visited[i] && isCyclic(graph, i, onPath, visited, stack))
				return new int[0];
		}
		int result[] = new int[numCourses];
		int i = 0;
		while (!stack.isEmpty()) {
			result[i] = stack.pollFirst();
			i++;
		}
		return result;
	}

	boolean isCyclic(GraphList graph, int u, boolean onPath[], boolean visited[], Deque<Integer> stack) {
		visited[u] = onPath[u] = true;
		for (int v : graph.adjList[u]) {
			if (onPath[v] || (!visited[v] && isCyclic(graph, v, onPath, visited, stack)))
				return true;
		}
		onPath[u] = false;
		stack.offerFirst(u);
		return false;
	}
}

