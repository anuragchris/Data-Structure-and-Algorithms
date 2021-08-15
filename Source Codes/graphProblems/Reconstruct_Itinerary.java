package graphProblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Reconstruct_Itinerary {

	List<String> findItinerary(List<List<String>> tickets) {
		HashMap<String, PriorityQueue<String>> hm = new HashMap<String, PriorityQueue<String>>();
		for (int i = 0; i < tickets.size(); i++) {
			String key = tickets.get(i).get(0);
			String value = tickets.get(i).get(1);
			if (!hm.containsKey(key)) {
				PriorityQueue<String> temp = new PriorityQueue<>();
				hm.put(key, temp);
			}
			hm.get(key).add(value);
		}
		LinkedList<String> res = new LinkedList<>();
		dfs("JFK", hm, res);
		return res;
	}

	static void dfs(String dep, HashMap<String, PriorityQueue<String>> hm, LinkedList<String> res) {
		PriorityQueue<String> arrival = hm.get(dep);
		while (arrival != null && !arrival.isEmpty()) {
			dfs(arrival.poll(), hm, res);
		}
		res.addFirst(dep);
	}
}
