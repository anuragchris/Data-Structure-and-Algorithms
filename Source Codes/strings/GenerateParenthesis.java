//Link For Problem: https://leetcode.com/problems/generate-parentheses/

package strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		List<String> ls = new ArrayList<String>();
		solve(ls, new StringBuilder(), 0, 0, n);
		return ls;
	}

	void solve(List<String> ls, StringBuilder sb, int open, int close, int max) {
		if (sb.length() == max * 2) {
			ls.add(sb.toString());
			return;
		}

		if (open < max) {
			sb.append("(");
			solve(ls, sb, open + 1, close, max);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (close < open) {
			sb.append(")");
			solve(ls, sb, open, close + 1, max);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
