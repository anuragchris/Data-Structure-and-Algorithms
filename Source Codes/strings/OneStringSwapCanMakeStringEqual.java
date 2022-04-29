//Link For Problem: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

package strings;

public class OneStringSwapCanMakeStringEqual {

	public boolean areAlmostEqual(String s1, String s2) {
		if (s1.equals(s2))
			return true;

		char first[] = new char[2];
		char second[] = new char[2];

		int count = 0;

		for (int i = 0; i < s1.length(); i++) {
			char x = s1.charAt(i);
			char y = s2.charAt(i);

			if (x != y) {
				if (count == 2)
					return false;

				first[count] = x;
				second[count] = y;
				count += 1;
			}
		}

		return first[0] == second[1] && first[1] == second[0];
	}

	public boolean anotherSolution(String s1, String s2) {
		if (s1.equals(s2))
			return true;

		int a = -1, b = -1;

		for (int i = 0; i < s1.length(); i++) {
			char x = s1.charAt(i);
			char y = s2.charAt(i);

			if (x != y) {
				if (a == -1)
					a = i;

				else if (b == -1)
					b = i;

				else
					return false;
			}
		}

		if (a == -1)
			return true;

		else if (b == -1)
			return false;

		return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
	}
}
