//Link For Problem: https://leetcode.com/problems/minimum-number-of-refueling-stops/

package priorityQueueAndHeaps;

import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int maxReach = startFuel;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		int count = 0, index = 0;

		while (maxReach < target) {

			while (index < stations.length && stations[index][0] <= maxReach) {
				pq.add(stations[index]);
				index += 1;
			}

			if (pq.isEmpty())
				return -1;

			maxReach += pq.poll()[1];
			count += 1;
		}

		return count;
	}
}
