// Link For Problem: https://leetcode.com/problems/employee-importance/

package graphProblems;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportance {

	class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	}

	Map<Integer, Employee> map;

	public int getImportance(List<Employee> employees, int id) {
		map = new HashMap<>();

		for (Employee e : employees)
			map.put(e.id, e);

		return dfs(id);
	}

	public int dfs(int eid) {
		Employee emp = map.get(eid);
		int ans = emp.importance;

		for (int sumId : emp.subordinates)
			ans += dfs(sumId);

		return ans;
	}

	public int bfs(List<Employee> employees, int id) {
		HashMap<Integer, Employee> map = new HashMap<>();
		Queue<Employee> q = new ArrayDeque<>();

		for (Employee e : employees)
			map.put(e.id, e);

		q.add(map.get(id));

		int res = 0;
		while (!q.isEmpty()) {
			Employee emp = q.poll();
			res += emp.importance;

			for (int subId : emp.subordinates)
				q.add(map.get(subId));
		}

		return res;
	}
}
