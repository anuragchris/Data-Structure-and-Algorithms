//Link For Problem: https://leetcode.com/problems/course-schedule-iii/

package priorityQueueAndHeaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class CourseScheduleIII {

	public int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, (a, b) -> a[1] - b[1]);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int time = 0;

		for (int arr[] : courses) {
			time += arr[0];
			pq.offer(arr[0]);

			if (time > arr[1])
				time -= pq.poll();
		}

		return pq.size();
	}
}
