package slidingWindowProblems;

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstNegativeNumber {
	static void firstNegative(int arr[], int k) {
		int i = 0, j = 0;
		Queue<Integer> q = new ArrayDeque<Integer>();
		while (j < arr.length) {
			if (arr[j] < 0)
				q.add(arr[j]);
			if (j - i + 1 < k)
				j++;
			else if (j - i + 1 == k) {
				if (q.isEmpty()) {
					System.out.println("0");
					j++;
				} else {
					if (arr[i] != q.peek())
						System.out.println(q.peek());
					else
						System.out.println(q.poll());
					i++;
					j++;
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3;
		firstNegative(arr, k);
	}
}
