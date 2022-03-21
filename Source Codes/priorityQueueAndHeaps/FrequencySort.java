package priorityQueueAndHeaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {

	//Link For Problem: https://leetcode.com/problems/sort-array-by-increasing-frequency/
	public int[] frequencySort(int[] nums) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i : nums)
			hm.put(i, hm.getOrDefault(i, 0) + 1);

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
		        (a, b) -> hm.get(a) != hm.get(b) ? hm.get(a) - hm.get(b) : b - a);

		for (int i : nums)
			pq.offer(i);

		int i = 0;
		while (!pq.isEmpty())
			nums[i++] = pq.poll();

		return nums;
	}

	//Link For Problem: https://leetcode.com/problems/sort-characters-by-frequency/
	public String frequencySort(String s) {

		char arr[] = s.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (char c : arr)
			hm.put(c, hm.getOrDefault(c, 0) + 1);

		PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> hm.get(b) - hm.get(a));

		for (char c : hm.keySet())
			pq.offer(c);

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			char temp = pq.poll();
			for (int i = 0; i < hm.get(temp); i++)
				sb.append(temp);
		}

		return sb.toString();
	}

	public String optimization(String s) {

		int frequency[] = new int[128];
		for (char c : s.toCharArray())
			frequency[c] += 1;

		int target = -1;
		StringBuilder sb = new StringBuilder();

		while ((target = findMax(frequency)) > 0) {

			while (frequency[target]-- > 0)
				sb.append((char) target);
		}
		return sb.toString();
	}

	private int findMax(int frequency[]) {
		int index = -1, max = Integer.MIN_VALUE;

		for (int i = 0; i < 128; i++) {

			if (frequency[i] > max) {
				max = frequency[i];
				index = i;
			}
		}
		return index;
	}
}
