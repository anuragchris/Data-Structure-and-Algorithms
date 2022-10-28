//Link For Problem: https://leetcode.com/problems/reorganize-string/

package priorityQueueAndHeaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

	public String reorganizeString(String s) {
		Map<Character, Integer> map = new HashMap<>();

		for (char c : s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

		pq.addAll(map.entrySet());

		Map.Entry<Character, Integer> prev = null;
		StringBuilder ans = new StringBuilder();

		while (!pq.isEmpty()) {
			var current = pq.poll();

			ans.append(current.getKey());

			current.setValue(current.getValue() - 1);

			if (prev != null)
				pq.offer(prev);

			if (current.getValue() > 0)
				prev = current;
			else
				prev = null;
		}


		return ans.length() == s.length() ? ans.toString() : "";
	}

	public String linearTimeSolution(String s) {
		int[] hash = new int[26];

		for (int i = 0; i < s.length(); i++)
			hash[s.charAt(i) - 'a']++;

		int max = 0, letter = 0;

		for (int i = 0; i < hash.length; i++) {
			if (hash[i] > max) {
				max = hash[i];
				letter = i;
			}
		}

		if (max > (s.length() + 1) / 2)
			return "";

		char[] res = new char[s.length()];
		int idx = 0;

		while (hash[letter] > 0) {
			res[idx] = (char) (letter + 'a');
			idx += 2;
			hash[letter]--;
		}

		for (int i = 0; i < hash.length; i++) {
			while (hash[i] > 0) {
				if (idx >= res.length) {
					idx = 1;
				}
				res[idx] = (char) (i + 'a');
				idx += 2;
				hash[i]--;
			}
		}

		return String.valueOf(res);
	}
}
