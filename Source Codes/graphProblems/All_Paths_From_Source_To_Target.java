//Link For Problem : https://leetcode.com/problems/all-paths-from-source-to-target/

package graphProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class All_Paths_From_Source_To_Target {
	static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		curr.add(0);
		dfs(0, curr, graph, graph.length - 1, res);
		return res;
	}

	static void dfs(int src, List<Integer> curr, int graph[][], int dest, List<List<Integer>> res) {
		if (src == dest) {
			res.add(new ArrayList(curr));
			return;
		}
		for (int i : graph[src]) {
			curr.add(i);
			dfs(i, curr, graph, dest, res);
			curr.remove(curr.size() - 1);
		}
	}
}
