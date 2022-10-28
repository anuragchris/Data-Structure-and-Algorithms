//Link For Problem: https://leetcode.com/problems/ipo/

package priorityQueueAndHeaps;

import java.util.PriorityQueue;

public class IPO {

	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		PriorityQueue<int[]> cap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		PriorityQueue<int[]> profit = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for (int i = 0; i < profits.length; i++)
			cap.offer(new int[] { capital[i], profits[i] });

		for (int i = 0; i < k; i++) {

			while (!cap.isEmpty() && cap.peek()[0] <= w)
				profit.offer(cap.poll());

			if (profit.isEmpty())
				break;

			w += profit.poll()[1];
		}

		return w;
	}
}
