//Link For Problem: https://leetcode.com/problems/find-median-from-data-stream/

package priorityQueueAndHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

	private PriorityQueue<Integer> small, large;

	public MedianFinder() {
		this.small = new PriorityQueue<>(Collections.reverseOrder());
		this.large = new PriorityQueue<>();
	}

	public void addNum(int num) {
		this.small.add(num);

		if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek())
			large.add(small.poll());

		if (small.size() > large.size() + 1)
			large.add(small.poll());

		if (large.size() > small.size() + 1)
			small.add(large.poll());
	}

	public double findMedian() {
		if (small.size() > large.size())
			return small.peek();

		if (large.size() > small.size())
			return large.peek();

		return (small.peek() + large.peek()) / 2.0;
	}
}
