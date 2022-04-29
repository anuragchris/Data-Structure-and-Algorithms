//Link For Problem: https://leetcode.com/problems/largest-substring-between-two-equal-characters/

package strings;

import java.util.HashMap;

public class LargestSubstringBetweenTwoEqualCharacters {

	public int maxLengthBetweenEqualCharacters(String s) {
		int arr[] = new int[26];
		int ans = -1;

		for (int i = 0; i < s.length(); i++)
			arr[s.charAt(i) - 'a'] = i;

		for (int i = 0; i < s.length(); i++)
			ans = Math.max((arr[s.charAt(i) - 'a'] - i - 1), ans);

		return ans;
	}

	public int usingMap(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int ans = -1;

		for (int i = 0; i < s.length(); i++) {

			if (hm.containsKey(s.charAt(i)))
				ans = Math.max(ans, i - 1 - hm.get(s.charAt(i)));
			else
				hm.put(s.charAt(i), i);
		}

		return ans;
	}

	public int anotherSolution(String s) {
		int arr[] = new int[26];
		int ans = -1;

		for (int i = 0; i < s.length(); i++) {
			int start = arr[s.charAt(i) - 'a'];

			if (start > 0)
				ans = Math.max(ans, i - start);
			else
				arr[s.charAt(i) - 'a'] = i + 1;
		}

		return ans;
	}
}
