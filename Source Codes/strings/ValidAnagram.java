//Link For Problem: https://leetcode.com/problems/valid-anagram/

package strings;

import java.util.Arrays;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		int freq[] = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			freq[c1 - 'a'] += 1;
			freq[c2 - 'a'] -= 1;
		}

		for (int i : freq) {
			if (i != 0)
				return false;
		}

		return true;
	}

	public boolean usingSort(String s, String t) {
		if (s.length() != t.length())
			return false;

		char arr1[] = s.toCharArray();
		char arr2[] = t.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}

		return true;
	}
}
