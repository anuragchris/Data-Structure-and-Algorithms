//Link For Problem: https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

package strings;

public class SumOfBeautyOfAllSubstrings {

	public int beautySum(String s) {
		int res = 0;
		int freq[] = new int[26];

		for (char c : s.toCharArray()) {
			freq[c - 'a'] += 1;
			res += helper(freq);
		}


		if (s.length() > 1)
			res += beautySum(s.substring(1));

		return res;
	}

	private int helper(int freq[]) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

		for (int i = 0; i < 26; i++) {
			max = Math.max(max, freq[i]);

			if (freq[i] != 0)
				min = Math.min(min, freq[i]);
		}

		return max - min;
	}

	public int iterative(String s) {
		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			int freq[] = new int[26];

			for (int j = i; j < s.length(); j++) {
				freq[s.charAt(j) - 'a'] += 1;

				int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

				for (int n : freq) {
					if (n == 0)
						continue;

					max = Math.max(max, n);
					min = Math.min(min, n);
				}

				res += max - min;
			}
		}

		return res;
	}
}
