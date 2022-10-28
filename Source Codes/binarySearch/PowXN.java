//Link For Problem: https://leetcode.com/problems/powx-n/

package binarySearch;

public class PowXN {

	public double myPow(double x, int n) {
		double ans = 1.0;
		long nn = n;

		if (nn < 0)
			nn *= -1;

		while (nn > 0) {

			if ((nn & 1) == 1) {
				ans *= x;
				nn -= 1;
			} else {
				x *= x;
				nn >>= 1;
			}
		}

		if (n < 0)
			ans = 1.0 / ans;

		return ans;
	}
}
