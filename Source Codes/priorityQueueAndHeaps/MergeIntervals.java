//Link For Problem: https://leetcode.com/problems/merge-intervals/solution/

package priorityQueueAndHeaps;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		LinkedList<int[]> merged = new LinkedList<>();

		for (int[] i : intervals) {

			if (merged.isEmpty() || merged.getLast()[1] < i[0])
				merged.add(i);
			else
				merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);
		}

		return merged.toArray(new int[merged.size()][]);
	}
}
