//Link For Problem: https://leetcode.com/problems/arranging-coins/

package binarySearch;

public class ArrangingCoins {

	public int arrangeCoins(int n) {
		long start = 0, end = n;

		while (start <= end) {
			long k = start + (end - start) / 2;

			long current = k * (k + 1) / 2;

			if (current == n)
				return (int) k;

			if (n > current)
				start = k + 1;
			else
				end = k - 1;
		}

		return (int) end;
	}
}
