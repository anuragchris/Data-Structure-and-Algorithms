//Link For Problem : https://leetcode.com/problems/course-schedule/

package graphProblems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
	static boolean canFinish(int numCourses, int[][] prerequisites) {
		java.util.List<Integer> adj[] = new LinkedList[numCourses];

		for (int i = 0; i < numCourses; i++)
			adj[i] = new LinkedList<Integer>();

		for (int i = 0; i < prerequisites.length; i++) {
			int pre[] = prerequisites[i];
			adj[pre[1]].add(pre[0]);
		}

		boolean visited[] = new boolean[numCourses];
		boolean helper[] = new boolean[numCourses];

		boolean ans;

		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == false) {
				ans = isCyclic(adj, visited, helper, i);
				if (ans == true)
					return false;
			}
		}
		return true;
	}

	static boolean isCyclic(List<Integer> adj[], boolean visited[], boolean helper[], int i) {
		if (helper[i])
			return true;

		if (visited[i])
			return false;

		visited[i] = true;
		helper[i] = true;

		Iterator<Integer> it = adj[i].iterator();

		while (it.hasNext()) {
			if (isCyclic(adj, visited, helper, it.next()))
				return true;
		}

		helper[i] = false;
		return false;
	}
}
