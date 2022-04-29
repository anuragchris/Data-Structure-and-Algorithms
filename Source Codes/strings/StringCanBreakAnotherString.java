//Link For Problem: https://leetcode.com/problems/check-if-a-string-can-break-another-string/

package strings;

import java.util.Arrays;

public class StringCanBreakAnotherString {

	public boolean checkIfCanBreak(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;


		char arr1[] = s1.toCharArray();
		char arr2[] = s2.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		boolean f1 = false, f2 = false;

		for (int i = 0; i < s1.length(); i++) {

			if (arr1[i] > arr2[i]) {
				if (f2)
					return false;

				f1 = true;
			}

			else if (arr2[i] > arr1[i]) {
				if (f1)
					return false;

				f2 = true;
			}
		}

		return true;
	}

	public boolean optimized(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		int freq1[] = new int[26];
		int freq2[] = new int[26];

		for (char c : s1.toCharArray())
			freq1[c - 'a'] += 1;

		for (char c : s2.toCharArray())
			freq2[c - 'a'] += 1;

		int count1 = 0, count2 = 0;
		boolean flag1 = false, flag2 = false;

		for (int i = 0; i < 26; i++) {
			count1 += freq1[i];
			count2 += freq2[i];

			if (count1 > count2)
				flag1 = true;

			else if (count2 > count1)
				flag2 = true;

			if (flag1 && flag2)
				return false;
		}

		return true;
	}
}
