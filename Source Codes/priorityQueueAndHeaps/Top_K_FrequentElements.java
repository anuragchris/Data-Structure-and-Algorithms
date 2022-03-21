//Link For Problem: https://leetcode.com/problems/top-k-frequent-elements/

package priorityQueueAndHeaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_FrequentElements {
	class Node {
		private int number;
		private int frequency;

		public Node(int number, int frequency) {
			this.number = number;
			this.frequency = frequency;
		}

		public int getNumber() {
			return number;
		}

		public int getFrequency() {
			return frequency;
		}
	}

	public int[] topKFrequent(int[] nums, int k) {
		if (k == nums.length)
			return nums;

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i : nums)
			hm.put(i, hm.getOrDefault(i, 0) + 1);

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if (n2.getFrequency() > n1.getFrequency())
					return 1;
				else if (n1.getFrequency() > n2.getFrequency())
					return -1;
				return 0;
			}
		});

		for (Map.Entry<Integer, Integer> me : hm.entrySet())
			pq.offer(new Node(me.getKey(), me.getValue()));

		int ans[] = new int[k];
		int i = 0;
		while (k-- > 0) {
			Node temp = pq.poll();
			ans[i++] = temp.getNumber();
		}

		return ans;
	}
}
