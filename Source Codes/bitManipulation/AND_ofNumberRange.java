//Link For Problem : https://leetcode.com/problems/bitwise-and-of-numbers-range/

package bitManipulation;

public class AND_ofNumberRange {
	static int rangeBitwiseAnd(int left, int right) {
		int count = 0;
		while (left != right) {
			left >>= 1;
			right >>= 1;
			count++;
		}
		return (left <<= count);
	}

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5, 7));
	}
}
