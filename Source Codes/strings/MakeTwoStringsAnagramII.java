//Link For Problem: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/

package strings;

public class MakeTwoStringsAnagramII {

	public int minSteps(String s, String t) {
		if (s.equalsIgnoreCase(t))
			return 0;

		int a[] = new int[26];
		int b[] = new int[26];

		for (char c : s.toCharArray())
			a[c - 'a'] += 1;

		for (char c : t.toCharArray())
			b[c - 'a'] += 1;

		int count = 0;
		for (int i = 0; i < 26; i++)
			count += Math.abs(a[i] - b[i]);

		return count;
	}

	public int anotherSolution(String s, String t) {
		int a[] = new int[26];

		for (char c : s.toCharArray())
			a[c - 'a'] += 1;

		for (char c : t.toCharArray())
			a[c - 'a'] -= 1;

		int count = 0;
		for (int i = 0; i < 26; i++)
			count += Math.abs(a[i]);

		return count;
	}
}
