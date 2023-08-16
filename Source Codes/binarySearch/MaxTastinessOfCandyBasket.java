// Link For Problem: https://leetcode.com/problems/maximum-tastiness-of-candy-basket/

package binarySearch;

import java.util.Arrays;

public class MaxTastinessOfCandyBasket {

	public int maximumTastiness(int[] price, int k) {
		Arrays.sort(price);

		int n = price.length;
		int left = 0, right = price[n - 1] - price[0], ans = 0;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (check(mid, price, k)) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return ans;
	}

	public boolean check(int x, int price[], int k) {
		int j = 0;
		int len = 1;

		for (int i = 1; i < price.length; i++) {
			if (price[i] - price[j] >= x) {
				len += 1;
				j = i;
			}
		}

		return len >= k ? true : false;
	}
}
