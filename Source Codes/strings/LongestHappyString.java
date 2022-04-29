//Link For Problem: https://leetcode.com/problems/longest-happy-string/

package strings;

import java.util.PriorityQueue;

public class LongestHappyString {

	public String longestDiverseString(int a, int b, int c) {
		int arr[] = new int[] { a, b, c };

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> arr[y] - arr[x]);

		for (int i = 0; i < arr.length; i++)
			pq.offer(i);

		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = sb.length();
			int current = pq.poll();

			if (n >= 2 && sb.charAt(n - 1) - 'a' == current && sb.charAt(n - 2) - 'a' == current) {
				int second = pq.poll();
				pq.offer(current);
				current = second;
			}

			if (arr[current] == 0)
				break;

			sb.append((char) (current + 'a'));
			arr[current] -= 1;
			pq.offer(current);
		}

		return sb.toString();
	}

	public String optimized(int a, int b, int c) {
		int A = 0, B = 0, C = 0; // continuous count of a, b, c
		StringBuilder sb = new StringBuilder();

		while (a > 0 && A < 2 || b > 0 && B < 2 || c > 0 && C < 2) {
			// append the maximum letter
			if ((a >= b && a >= c && A < 2) || (B == 2 && a > 0) || (C == 2 && a > 0)) {
				sb.append("a");
				a--;
				A++;
				B = 0;
				C = 0;
			}

			else if ((b >= a && b >= c && B < 2) || (A == 2 && b > 0) || (C == 2 && b > 0)) {
				sb.append("b");
				b--;
				B++;
				A = 0;
				C = 0;
			}

			else if ((c >= a && c >= b && C < 2) || (A == 2 && c > 0) || (B == 2 && c > 0)) {
				sb.append("c");
				c--;
				C++;
				A = 0;
				B = 0;
			}
		}

		return sb.toString();
	}
}
