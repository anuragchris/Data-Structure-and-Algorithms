// Link For Problem: https://leetcode.com/problems/kth-largest-element-in-a-stream/

package priorityQueueAndHeaps;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

	private int k;
	private PriorityQueue<Integer> heap;

	public KthLargestElementInAStream(int k, int[] nums) {
		this.k = k;
		this.heap = new PriorityQueue<>();

		for (int i : nums)
			this.add(i);
	}

	public int add(int val) {
		this.heap.add(val);

		if (heap.size() > this.k)
			this.heap.remove();

		return this.heap.peek();
	}
}
