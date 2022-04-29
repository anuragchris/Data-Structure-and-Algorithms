//Link For Problem: https://leetcode.com/problems/valid-parentheses/

package strings;

import java.util.Stack;

public class ValidParenthesis {

	public boolean isValid(String s) {
		if (s.length() == 1 || (s.length() & 1) == 1)
			return false;

		if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']')
			return false;

		Stack<Character> st = new Stack<Character>();
		char arr[] = s.toCharArray();

		for (char c : arr) {
			if (c == ')') {
				if (!st.isEmpty() && st.peek() == '(')
					st.pop();
				else
					return false;
			}

			else if (c == '}') {
				if (!st.isEmpty() && st.peek() == '{')
					st.pop();
				else
					return false;
			}

			else if (c == ']') {
				if (!st.isEmpty() && st.peek() == '[')
					st.pop();
				else
					return false;
			}

			else
				st.push(c);
		}

		return st.isEmpty();
	}

	public boolean anotherSolution(String s) {
		if (s.length() == 1 || (s.length() & 1) == 1)
			return false;

		if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']')
			return false;

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '[' || c == '{' || c == '(')
				stack.push(c);

			else {
				if (stack.isEmpty())
					return false;

				char popped = stack.pop();
				if ((c == ')' && popped == '(') || (c == ']' && popped == '[') || (c == '}' && popped == '{'))
					continue;

				return false;
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s = "{{({})}}";
		ValidParenthesis vp = new ValidParenthesis();
		System.out.println(vp.anotherSolution(s));
	}
}
