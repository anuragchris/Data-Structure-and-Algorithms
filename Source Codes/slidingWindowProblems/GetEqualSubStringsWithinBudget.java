//Link For Problem: https://leetcode.com/problems/get-equal-substrings-within-budget/

package slidingWindowProblems;

public class GetEqualSubStringsWithinBudget {

	public int equalSubstring(String s, String t, int maxCost) {
		int n = s.length(), i = 0, j;

		for (j = 0; j < n; j++) {
			maxCost -= Math.abs(s.charAt(j) - t.charAt(j));

			if (maxCost < 0) {
				maxCost += Math.abs(s.charAt(i) - t.charAt(i));
				i += 1;
			}
		}

		return j - i;
	}

	public int anotherSolution(String s, String t, int maxCost) {
		int diff[] = new int[s.length()];

		for (int i = 0; i < s.length(); i++)
			diff[i] = Math.abs(s.charAt(i) - t.charAt(i));

		int ans = 0, currentCost = 0, start = 0;

		for (int end = 0; end < diff.length; end++) {
			currentCost += diff[end];

			while (currentCost > maxCost) {
				currentCost -= diff[start];
				start += 1;
			}

			ans = Math.max(ans, end - start + 1);
		}

		return ans;
	}
}
