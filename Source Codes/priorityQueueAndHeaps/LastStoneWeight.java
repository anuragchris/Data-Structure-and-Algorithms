// Link For Problem : https://leetcode.com/problems/last-stone-weight/

package priorityQueueAndHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i : stones)
			pq.add(i);
		while (pq.size() > 1) {
			int first = pq.remove();
			int second = pq.remove();

			if (first != second) {
				pq.add(first - second);
			}
		}
		return pq.isEmpty() ? 0 : pq.peek();
	}
}
