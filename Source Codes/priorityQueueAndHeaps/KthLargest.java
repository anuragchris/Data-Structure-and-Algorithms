// Link For Problem : https://leetcode.com/problems/kth-largest-element-in-an-array/

package priorityQueueAndHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i : nums)
			pq.offer(i);
		for (int i = 0; i < k - 1; i++)
			pq.poll();
		return pq.poll();
	}



	public static void main(String[] args) {
		int nums[] = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		System.out.println(findKthLargest(nums, k));
	}
}
