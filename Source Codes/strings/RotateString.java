//Link For Problem : https://leetcode.com/problems/rotate-string/

package strings;

import java.util.LinkedList;
import java.util.Queue;

public class RotateString {

	public boolean rotateString(String s, String goal) {
		return (s.length() == goal.length()) && ((s + s).indexOf(goal) != -1);
	}

	public boolean anotherSolution(String s, String goal) {
		if (s.length() != goal.length())
			return false;

		Queue<Character> q1 = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++)
			q1.offer(s.charAt(i));

		Queue<Character> q2 = new LinkedList<Character>();
		for (int i = 0; i < goal.length(); i++)
			q2.offer(goal.charAt(i));

		int k = goal.length();

		while (k > 0) {
			k -= 1;

			char ch = q2.poll();
			q2.offer(ch);

			if (q2.equals(q1))
				return true;
		}

		return false;
	}

	public boolean usingKMP(String s, String goal) {
		if (s.length() != goal.length())
			return false;

		return kmp(s + s, goal);
	}

	static boolean kmp(String s, String goal) {
		int lps[] = buildLPS(s);
		int i = 0, j = 0;

		while (i < s.length() && j < goal.length()) {

			if (s.charAt(i) == goal.charAt(j)) {
				i += 1;
				j += 1;
			} else {
				if (j != 0)
					j = lps[j - 1];

				else
					i += 1;
			}
		}

		return j == goal.length();
	}

	static int[] buildLPS(String s) {
		int lps[] = new int[s.length()];
		int index = 0;

		for (int i = 1; i < lps.length;) {

			if (s.charAt(i) == s.charAt(index)) {
				lps[i] = index + 1;
				index += 1;
				i += 1;
			}

			else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = 0;
					i += 1;
				}
			}
		}

		return lps;
	}

	public static void main(String[] args) {
		String s = "abcde";
		String goal = "cdeab";

		RotateString rs = new RotateString();
		System.out.println(rs.anotherSolution(s, goal));
	}
}
