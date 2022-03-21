//Link For Problem: https://www.geeksforgeeks.org/sum-elements-k1th-k2th-smallest-elements/

package priorityQueueAndHeaps;

import java.util.PriorityQueue;

public class SumOfElements {
	static int sum(int arr[], int k1, int k2) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i : arr)
			pq.offer(i);

		for (int i = 1; i <= k1; i++)
			pq.poll();

		int sum = 0;
		for (int i = k1 + 1; i < k2; i++)
			sum += pq.poll();

		return sum;
	}

	public static void main(String[] args) {
		int[] a = { 20, 8, 22, 4, 12, 10, 14 };
		int k1 = 3, k2 = 6;

		System.out.println(sum(a, k1, k2));
	}
}
