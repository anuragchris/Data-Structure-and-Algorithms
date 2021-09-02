package slidingWindowProblems;

import java.util.HashMap;

public class LongestSubStringWithKUniqueChar {
	static int longestSubString(String str, int k) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int i = 0, j = 0, max = Integer.MIN_VALUE;
		while (j < str.length()) {
			hm.put(str.charAt(j), hm.getOrDefault(str.charAt(j), 0) + 1);
			if (hm.size() == k)
				max = Math.max(max, j - i + 1);
			else if (hm.size() > k) {
				while (hm.size() > k) {
					hm.put(str.charAt(i), hm.get(str.charAt(i)) - 1);
					if (hm.get(str.charAt(i)) == 0)
						hm.remove(str.charAt(i));
					i += 1;
				}
			}
			j += 1;
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "aabacbebebe";
		int k = 3;
		System.out.println(longestSubString(s, k));
	}
}
