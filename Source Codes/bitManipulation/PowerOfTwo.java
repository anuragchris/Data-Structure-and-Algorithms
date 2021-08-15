//Link For Problem : https://leetcode.com/problems/power-of-two/

package bitManipulation;

public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		if (n < 0)
			return false;
		int count = 0;
		while (n != 0) {
			count++;
			n &= n - 1;
		}
		if (count == 1)
			return true;
		return false;
	}

	public boolean efficientApproach(int n) {
		if (n <= 0)
			return false;
		if ((n & (n - 1)) == 0)
			return true;
		return false;
	}
}
