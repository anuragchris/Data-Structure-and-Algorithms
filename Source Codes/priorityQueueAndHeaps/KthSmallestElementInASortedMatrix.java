//Link For Problem : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

package priorityQueueAndHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

				if (pq.size() < k)
					pq.add(matrix[i][j]);

				else if (matrix[i][j] < pq.peek()) {
					pq.poll();
					pq.add(matrix[i][j]);
				}
			}
		}

		return pq.poll();
	}
}
