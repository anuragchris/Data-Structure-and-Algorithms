//Link For Problem : https://leetcode.com/problems/isomorphic-strings/

package strings;

import java.util.Arrays;
import java.util.HashMap;

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		int st[] = new int[256];
		Arrays.fill(st, -1);

		int ts[] = new int[256];
		Arrays.fill(ts, -1);

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (st[c1] == -1 && ts[c2] == -1) {
				st[c1] = c2;
				ts[c2] = c1;
			}

			else if (st[c1] != c2 && ts[c2] != c1)
				return false;
		}

		return true;
	}

	public boolean anotherSolution(String s, String t) {
		return transformString(s).equals(transformString(t));
	}

	private String transformString(String str) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		StringBuilder sb = new StringBuilder();


		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (!hm.containsKey(c))
				hm.put(c, i);

			sb.append(hm.get(c));
			sb.append(" ");
		}

		return sb.toString();
	}
}
