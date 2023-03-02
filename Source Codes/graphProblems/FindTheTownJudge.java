//Link For Problem: https://leetcode.com/problems/find-the-town-judge/

package graphProblems;

public class FindTheTownJudge {

	public int findJudge(int n, int[][] trust) {
		if (trust.length == 0 && n == 1)
			return 1;

		if (trust.length == 0)
			return -1;

		int people[] = new int[n + 1];

		for (int t[] : trust) {
			people[t[0]] -= 1;

			people[t[1]] += 1;
		}

		for (int i = 0; i < people.length; i++) {
			if (people[i] == n - 1)
				return i;
		}

		return -1;
	}
}
