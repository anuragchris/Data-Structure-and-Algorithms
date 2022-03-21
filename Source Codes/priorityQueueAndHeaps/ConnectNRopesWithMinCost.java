//Link For Problem: https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/

package priorityQueueAndHeaps;

import java.util.PriorityQueue;

public class ConnectNRopesWithMinCost {
	static int minCost(int ropes[]) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int cost = 0;

		for (int i : ropes)
			pq.offer(i);

		while (pq.size() >= 2) {
			int first = pq.poll();
			int second = pq.poll();

			cost += first + second;
			pq.offer(first + second);
		}

		return cost;
	}

	public static void main(String[] args) {
		int len[] = { 4, 3, 2, 6 };
		System.out.println(minCost(len));
	}
}
