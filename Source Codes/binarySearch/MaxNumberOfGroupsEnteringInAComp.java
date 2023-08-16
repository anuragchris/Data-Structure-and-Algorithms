// Link For Problem: https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/

package binarySearch;

public class MaxNumberOfGroupsEnteringInAComp {

	public int maximumGroups(int[] grades) {
		int n = grades.length, k = 0;

		while (n >= k + 1) {
			k += 1;
			n -= k;
		}

		return k;
	}

	public int binarySearch(int grades[]) {
		int left = 0, right = 1000, n = grades.length;

		while (left < right) {
			int k = (left + right + 1) / 2;

			if (k * (k + 1) / 2 > n)
				right = k - 1;
			else
				left = k;
		}

		return left;
	}

	public int anotherSolution(int grades[]) {
		int n = grades.length, k = 1;

		while (k * (k + 1) / 2 <= n)
			k += 1;

		return k - 1;
	}
}
