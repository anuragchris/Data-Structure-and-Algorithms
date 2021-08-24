//Link For Problem : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

package binarySearchProblems;

public class ShipWithinDays {
	static int shipWithinDays(int[] weights, int days) {
		int start = Integer.MIN_VALUE, end = 0;
		for (int i = 0; i < weights.length; i++) {
			start = Math.max(start, weights[i]);
			end += weights[i];
		}
		int ans = -1, mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (isValid(weights, weights.length, days, mid)) {
				ans = mid;
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return ans;
	}

	static boolean isValid(int arr[], int n, int k, int max) {
		int days = 1, sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum > max) {
				days += 1;
				sum = arr[i];
			}
			if (days > k)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int weights[] = { 1, 2, 3, 1, 1 };
		int days = 4;
		System.out.println(shipWithinDays(weights, days));
	}
}
