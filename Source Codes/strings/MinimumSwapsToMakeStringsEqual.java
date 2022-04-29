//Link For Problem: https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/

package strings;

public class MinimumSwapsToMakeStringsEqual {

	public int minimumSwap(String s1, String s2) {
		if (s1.length() != s2.length())
			return -1;

		if (s1.equals(s2))
			return 0;

		int xy = 0, yx = 0;
		for (int i = 0; i < s1.length(); i++) {

			if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y')
				xy += 1;

			else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x')
				yx += 1;
		}

		if ((xy + yx) % 2 != 0)
			return -1;

		else {
			if (xy % 2 == 0 && yx % 2 == 0)
				return (xy + yx) / 2;

			else
				return 2 + (xy / 2) + (yx / 2);
		}
	}
}
