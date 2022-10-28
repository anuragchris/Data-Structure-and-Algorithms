//Link For Problem: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

package priorityQueueAndHeaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

		for (int i = 0; i < nums1.length && i < k; i++)
			heap.add(new int[] { nums1[i], nums2[0], 0 });

		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < k && !heap.isEmpty(); i++) {
			int current[] = heap.poll();

			list.add(List.of(current[0], current[1]));

			int nums2Idx = current[2];

			if (nums2Idx < nums2.length - 1)
				heap.add(new int[] { current[0], nums2[nums2Idx + 1], nums2Idx + 1 });
		}

		return list;
	}
}
