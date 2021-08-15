//Link For Problem : https://leetcode.com/problems/keys-and-rooms/

package graphProblems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
	static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[rooms.size()];
		visited[0] = true;
		for (int i : rooms.get(0)) {
			q.add(i);
			visited[i] = true;
		}
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i : rooms.get(temp)) {
				if (visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				return false;
			}
		}
		return true;
	}
}
