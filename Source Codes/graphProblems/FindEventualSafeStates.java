//Link For Problem: https://leetcode.com/problems/find-eventual-safe-states/

package graphProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindEventualSafeStates {

	public List<Integer> eventualSafeNodes(int[][] graph) {
		int n = graph.length;
		Map<Integer, Boolean> safe = new HashMap<>();

		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (dfs(i, safe, graph))
				ans.add(i);
		}

		return ans;
	}

	boolean dfs(int i, Map<Integer, Boolean> safe, int graph[][]) {
		if (safe.containsKey(i))
			return safe.get(i);

		safe.put(i, false);

		for (int neighour : graph[i]) {
			if (!dfs(neighour, safe, graph))
				return false;
		}

		safe.put(i, true);

		return true;
	}
}
