//Link For Problem: https://leetcode.com/problems/k-closest-points-to-origin/

package priorityQueueAndHeaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class K_ClosestPointToOrigin {

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
		        (p1, p2) -> ((p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1])));

		for (int i = 0; i < points.length; i++) {
			pq.offer(points[i]);

			if (pq.size() > k)
				pq.poll();
		}

		int arr[][] = new int[k][2];

		while (k > 0)
			arr[--k] = pq.poll();

		return arr;
	}

	public int[][] k_Closest(int points[][], int k) {
		Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));

		return Arrays.copyOf(points, k);
	}
}
