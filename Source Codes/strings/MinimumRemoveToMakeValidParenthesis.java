//Link For Problem: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

package strings;

public class MinimumRemoveToMakeValidParenthesis {

	public String minRemoveToMakeValid(String s) {
		int balance = 0;
		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (balance == 0 && c == ')')
				continue;

			if (balance > 0 && c == ')')
				balance -= 1;

			else if (c == '(')
				balance += 1;

			sb.append(c);
		}

		for (int i = sb.length() - 1; i >= 0; i--) {
			if (balance > 0 && sb.charAt(i) == '(') {
				balance -= 1;
				sb.deleteCharAt(i);
			}
		}

		return sb.toString();
	}
}
