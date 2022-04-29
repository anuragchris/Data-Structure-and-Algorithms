//Link For Problem: https://leetcode.com/problems/score-of-parentheses/

package strings;

import java.util.Stack;

public class ScoreOfParenthesis {

	public int scoreOfParentheses(String s) {
		Stack<Integer> st = new Stack<Integer>();
		int score = 0;

		for (char c : s.toCharArray()) {
			if (c == '(') {
				st.push(score);
				score = 0;
			}

			else
				score = st.pop() + Math.max(2 * score, 1);
		}

		return score;
	}

	public int optimized(String s) {
		int depth = 0, res = 0;
		char prev = '(';

		for (char c : s.toCharArray()) {
			if (c == '(')
				depth += 1;

			else {
				depth -= 1;

				if (prev == '(')
					res += 1 << depth;
			}

			prev = c;
		}

		return res;
	}
}
