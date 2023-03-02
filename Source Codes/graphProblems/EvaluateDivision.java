//Link For Problem: https://leetcode.com/problems/evaluate-division/

package graphProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Edge {
	String v;
	double value;

	public Edge(String v, double value) {
		this.v = v;
		this.value = value;
	}
}

public class EvaluateDivision {

	public void addEdge(Map<String, List<Edge>> map, String u, String v, double value) {
		if (!map.containsKey(u))
			map.put(u, new ArrayList<>());

		map.get(u).add(new Edge(v, value));
	}

	public double dfs(Map<String, List<Edge>> map, Set<String> set, String u, String v) {
		if (!map.containsKey(u) || !map.containsKey(v))
			return -1;

		if (u.equals(v))
			return 1;

		for (Edge e : map.get(u)) {
			if (set.contains(e.v))
				continue;

			else if (e.v.equals(v))
				return e.value;

			set.add(u);

			double val = dfs(map, set, e.v, v);

			if (val != -1)
				return val * e.value;
		}

		return -1;
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		double answer[] = new double[queries.size()];
		Map<String, List<Edge>> map = new HashMap<>();

		for (int i = 0; i < values.length; i++) {
			List<String> equation = equations.get(i);

			addEdge(map, equation.get(0), equation.get(1), values[i]);
			addEdge(map, equation.get(1), equation.get(0), 1 / values[i]);
		}

		for (int i = 0; i < answer.length; i++) {
			List<String> query = queries.get(i);
			answer[i] = dfs(map, new HashSet<>(), query.get(0), query.get(1));
		}

		return answer;
	}
}
