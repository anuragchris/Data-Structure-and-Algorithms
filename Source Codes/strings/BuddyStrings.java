//Link For Problem: https://leetcode.com/problems/buddy-strings/

package strings;

public class BuddyStrings {

	public boolean buddyStrings(String s, String goal) {
		if (s.length() != goal.length())
			return false;

		if (s.equals(goal)) {
			int map[] = new int[26];

			for (int i = 0; i < s.length(); i++) {
				map[s.charAt(i) - 'a'] += 1;

				if (map[s.charAt(i) - 'a'] > 1)
					return true;
			}
			return false;
		}

		int first = -1, second = -1;
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) != goal.charAt(i)) {
				if (first == -1)
					first = i;

				else if (second == -1)
					second = i;

				else
					return false;
			}
		}

		if (second == -1)
			return false;

		return (s.charAt(first) == goal.charAt(second)) && (s.charAt(second) == goal.charAt(first));
	}
}
