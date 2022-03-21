//Link For Problem: https://www.geeksforgeeks.org/find-k-closest-numbers-in-an-unsorted-array/

package priorityQueueAndHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class K_ClosestNumber {
	static class Pair {
		private int value;
		private int diff;

		public Pair(int value, int diff) {
			this.value = value;
			this.diff = diff;
		}

		public int getValue() {
			return value;
		}

		public int getDiff() {
			return diff;
		}
	}

	static class Solution {
		public void kClosestElements(int arr[], int k, int x) {
			PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
				@Override
				public int compare(Pair p1, Pair p2) {
					if (p2.getDiff() > p1.getDiff())
						return 1;
					else if (p1.getDiff() > p2.getDiff())
						return -1;
					return 0;
				}
			});

			for (int i = 0; i < k; i++)
				pq.offer(new Pair(arr[i], Math.abs(arr[i] - x)));

			for (int i = k; i < arr.length; i++) {
				int diff = Math.abs(arr[i] - x);

				if (diff > pq.peek().getDiff())
					continue;

				pq.poll();
				pq.offer(new Pair(arr[i], diff));
			}

			while (pq.size() > 0) {
				System.out.print(pq.poll().getValue() + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int arr[] = { -10, -50, 20, 17, 80 };
		int k = 2, x = 20;
		Solution s = new Solution();
		s.kClosestElements(arr, k, x);
	}
}
