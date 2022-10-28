//Link For Problem: https://leetcode.com/problems/ugly-number-ii/

package priorityQueueAndHeaps;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class UglyNumberII {

	public int nthUglyNumber(int n) {
		if (n == 1)
			return 1;

		PriorityQueue<Long> pq = new PriorityQueue<>();
		pq.add(1l);

		for (int i = 1; i < n; i++) {
			long temp = pq.poll();

			while (!pq.isEmpty() && pq.peek() == temp)
				pq.poll();

			pq.add(temp * 2);
			pq.add(temp * 3);
			pq.add(temp * 5);
		}

		return pq.poll().intValue();
	}

	public int anotherSolution(int n) {
		if (n == 1)
			return 1;

		TreeSet<Long> set = new TreeSet<Long>();
		set.add(1L);

		for (int i = 0; i < n - 1; i++) {
			long first = set.pollFirst();

			set.add(first * 2);
			set.add(first * 3);
			set.add(first * 5);
		}

		return set.first().intValue();
	}
}
