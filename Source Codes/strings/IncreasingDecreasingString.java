//Link For Problem: https://leetcode.com/problems/increasing-decreasing-string/

package strings;

public class IncreasingDecreasingString {

	public String sortString(String s) {
		int freq[] = new int[26];

		for (char c : s.toCharArray())
			freq[c - 'a'] += 1;

		StringBuilder sb = new StringBuilder();

		while (sb.length() < s.length()) {

			for (int i = 0; i < 26; i++) {
				if (freq[i] > 0) {
					sb.append((char) (i + 'a'));
					freq[i] -= 1;
				}
			}

			for (int i = 25; i >= 0; i--) {
				if (freq[i] > 0) {
					sb.append((char) (i + 'a'));
					freq[i] -= 1;
				}
			}
		}

		return sb.toString();
	}
}
