// Link For Problem : https://leetcode.com/problems/minimum-window-substring/

package slidingWindowProblems;

import java.util.HashMap;

public class MinimumWindowSubString {
	static String minWindow(String s, String t) {
		if (t.length() > s.length())
			return "";
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (char c : t.toCharArray())
			hm.put(c, hm.getOrDefault(c, 0) + 1);
		int i = 0, j = 0;
		int min = Integer.MAX_VALUE, minSt = 0;
		int count = t.length();
		for (; j < s.length(); j++) {
			char current = s.charAt(j);
			if (hm.containsKey(current)) {
				hm.put(current, hm.get(current) - 1);
				if (hm.get(current) >= 0)
					count -= 1;
			}
			while (i < s.length() && count == 0) {
				if (min > j - i + 1) {
					min = j - i + 1;
					minSt = i;
				}
				char temp = s.charAt(i);
				if (hm.containsKey(temp)) {
					hm.put(temp, hm.get(temp) + 1);
					if (hm.get(temp) > 0)
						count += 1;
				}
				i += 1;
			}
		}
		return min < Integer.MAX_VALUE ? s.substring(minSt, minSt + min) : "";
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
	}
}
