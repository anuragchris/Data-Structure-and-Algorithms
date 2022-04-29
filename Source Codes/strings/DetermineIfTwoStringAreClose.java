//Link For Problem: https://leetcode.com/problems/determine-if-two-strings-are-close/

package strings;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DetermineIfTwoStringAreClose {

	public boolean closeStrings(String word1, String word2) {
		if (word1.length() != word2.length())
			return false;

		if (word1.equals(word2))
			return true;

		int c1[] = new int[26];
		int c2[] = new int[26];

		for (char c : word1.toCharArray())
			c1[c - 'a'] += 1;

		for (char c : word2.toCharArray())
			c2[c - 'a'] += 1;

		for (int i = 0; i < 26; i++) {

			if ((c1[i] == 0 && c2[i] != 0) || (c1[i] != 0 && c2[i] == 0))
				return false;
		}

		Arrays.sort(c1);
		Arrays.sort(c2);

		for (int i = 25; i >= 0; i--) {
			if (c1[i] != c2[i])
				return false;

			if (c1[i] == 0)
				return true;
		}

		return true;
	}

	public boolean anotherSolution(String word1, String word2) {
		if (word1.length() != word2.length())
			return false;

		if (word1.equals(word2))
			return true;

		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		for (int i = 0; i < word1.length(); i++) {
			map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
		}

		Map<Character, Integer> map2 = new HashMap<Character, Integer>();
		for (int i = 0; i < word2.length(); i++) {
			map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
		}

		return isSame(map1.keySet(), map2.keySet()) && isSame(map1.values(), map2.values());
	}

	boolean isSame(Collection a, Collection b) {
		Map<Object, Integer> mp = new HashMap<Object, Integer>();

		for (Object o : a)
			mp.put(o, mp.getOrDefault(o, 0) + 1);

		for (Object o : b) {
			if (!mp.containsKey(o) || mp.get(o) <= 0)
				return false;

			mp.put(o, mp.get(o) - 1);
		}

		return true;
	}
}
