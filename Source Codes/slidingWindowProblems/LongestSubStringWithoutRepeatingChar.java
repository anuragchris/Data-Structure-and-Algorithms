// Link For Problem : https://leetcode.com/problems/longest-substring-without-repeating-characters/

package slidingWindowProblems;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingChar {
	static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int max = Integer.MIN_VALUE;
		int j = 0, i = 0;

		while (j < s.length()) {
			hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);

			if (hm.size() == j - i + 1)
				max = Math.max(max, j - i + 1);

			else if (hm.size() < j - i + 1) {
				while (hm.size() < j - i + 1) {
					hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) - 1);
					if (hm.get(s.charAt(i)) == 0)
						hm.remove(s.charAt(i));
					i += 1;
				}
			}
			j += 1;
		}
		return max;
	}
}
