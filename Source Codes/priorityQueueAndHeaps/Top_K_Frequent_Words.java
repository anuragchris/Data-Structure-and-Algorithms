//Link For Problem: https://leetcode.com/problems/top-k-frequent-words/

package priorityQueueAndHeaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Words {

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();

		for (String str : words)
			map.put(str, map.getOrDefault(str, 0) + 1);

		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,
		        b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.offer(entry);

			if (pq.size() > k)
				pq.poll();
		}

		List<String> ans = new LinkedList<>();

		while (!pq.isEmpty())
			ans.add(0, pq.poll().getKey());

		return ans;
	}
}
