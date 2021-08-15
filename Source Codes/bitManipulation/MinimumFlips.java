//Link For Problem : https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/

package bitManipulation;

public class MinimumFlips {
	public int minFlips(int a, int b, int c) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			boolean x = false, y = false, z = false;
			if ((a & (1 << i)) != 0)
				x = true;
			if ((b & (1 << i)) != 0)
				y = true;
			if ((c & (1 << i)) != 0)
				z = true;
			if (z == false) {
				if (x == true & y == true)
					ans += 2;
				else if (x == true || y == true)
					ans += 1;
			} else {
				if (x == false & y == false)
					ans += 1;
			}
		}
		return ans;
	}
}
