//Link For Problem: https://leetcode.com/problems/long-pressed-name/

package twoPointer;

public class LongPressedName {

	public boolean isLongPressedName(String name, String typed) {
		if (typed.length() < name.length())
			return false;

		int i = 0, j = 0, m = name.length(), n = typed.length();

		for (; j < n; j++) {
			if (i < m && name.charAt(i) == typed.charAt(j))
				i += 1;
			else {
				if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
					return false;
			}
		}

		return i == m;
	}
}
