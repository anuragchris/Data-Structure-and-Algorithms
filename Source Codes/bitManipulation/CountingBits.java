//Link For Problem : https://leetcode.com/problems/counting-bits/

package bitManipulation;

public class CountingBits {
	static int[] countBits(int n) {
		int num[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			num[i] = num[i / 2] + i % 2;
		return num;
	}
}
