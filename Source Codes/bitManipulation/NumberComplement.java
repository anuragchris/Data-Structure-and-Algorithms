//Link For Problem : https://leetcode.com/problems/number-complement/

package bitManipulation;

public class NumberComplement {
	static int findComplement(int num) {
		int result = 0;
		int i = 0;
		while (num != 0) {
			if ((num & 1) == 0)
				result = result + (1 << i);
			i += 1;
			num >>= 1;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findComplement(5));
	}
}
