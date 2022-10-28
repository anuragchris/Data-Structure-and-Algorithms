//Link For Problem: https://leetcode.com/problems/minimum-cost-to-hire-k-workers/solution/

package priorityQueueAndHeaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Worker implements Comparable<Worker> {
	public int quality, wage;

	public Worker(int quality, int wage) {
		this.quality = quality;
		this.wage = wage;
	}

	public double ratio() {
		return (double) wage / quality;
	}

	@Override
	public int compareTo(Worker otherWorker) {
		return Double.compare(this.ratio(), otherWorker.ratio());
	}
}

public class MinimumCostToHireKWorkers {

	public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
		int n = quality.length;

		Worker workers[] = new Worker[n];

		for (int i = 0; i < n; i++)
			workers[i] = new Worker(quality[i], wage[i]);

		Arrays.sort(workers);

		double ans = 1e9;
		int sum = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (var w : workers) {
			pq.offer(w.quality);

			sum += w.quality;

			if (pq.size() > k)
				sum += pq.poll();

			if (pq.size() == k)
				ans = Math.min(ans, sum * w.ratio());
		}

		return ans;
	}
}
