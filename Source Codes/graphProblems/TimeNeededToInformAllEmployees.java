//Link For Problem: https://leetcode.com/problems/time-needed-to-inform-all-employees/

package graphProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {

	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < manager.length; i++) {
			int current = manager[i];

			if (!map.containsKey(current))
				map.put(current, new ArrayList<>());

			map.get(current).add(i);
		}

		return dfs(map, informTime, headID);
	}

	int dfs(Map<Integer, List<Integer>> map, int informTime[], int current) {
		int max = 0;

		if (!map.containsKey(current))
			return max;

		for (int i = 0; i < map.get(current).size(); i++)
			max = Math.max(max, dfs(map, informTime, map.get(current).get(i)));

		return max + informTime[current];
	}

	public int anotherSolution(int n, int headID, int[] manager, int[] informTime) {
		int result = 0;

		for (int i = 0; i < n; i++)
			result = Math.max(result, anotherDFS(i, informTime, manager));

		return result;
	}

	int anotherDFS(int i, int informTime[], int manager[]) {

		if (manager[i] != -1) {
			informTime[i] += anotherDFS(manager[i], informTime, manager);
			manager[i] = -1;
		}

		return informTime[i];
	}
}
