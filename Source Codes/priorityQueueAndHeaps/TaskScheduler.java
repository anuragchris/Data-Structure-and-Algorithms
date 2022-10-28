//Link For Problem: https://leetcode.com/problems/task-scheduler/

package priorityQueueAndHeaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
		if (tasks == null || tasks.length == 0)
			return -1;

		Map<Character, Integer> m = new HashMap<>();
		for (char c : tasks)
			m.put(c, m.getOrDefault(c, 0) + 1);

		Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
		        (a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey())
		                : b.getValue().compareTo(a.getValue()));

		queue.addAll(m.entrySet());

		int count = 0;
		while (!queue.isEmpty()) {
			int interval = n + 1;

			List<Map.Entry<Character, Integer>> list = new ArrayList<>();

			while (interval > 0 && !queue.isEmpty()) {
				Map.Entry<Character, Integer> entry = queue.poll();
				entry.setValue(entry.getValue() - 1);

				list.add(entry);

				interval -= 1;
				count += 1;
			}

			list.parallelStream().forEach(i -> {
				if (i.getValue() > 0)
					queue.offer(i);
			});

			if (queue.isEmpty())
				break;

			count += interval;
		}

		return count;
	}
}
