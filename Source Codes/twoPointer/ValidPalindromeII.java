//Link For Problem: https://leetcode.com/problems/valid-palindrome-ii/

package twoPointer;

public class ValidPalindromeII {

	public boolean validPalindrome(String s) {
		int i = 0, j = s.length() - 1;

		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j);

			i += 1;
			j -= 1;
		}

		return true;
	}

	boolean checkPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;

			i += 1;
			j -= 1;
		}

		return true;
	}
}
