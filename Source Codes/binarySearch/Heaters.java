//Link For Problem: https://leetcode.com/problems/heaters/

package binarySearch;

import java.util.Arrays;
import java.util.TreeSet;

public class Heaters {

	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(heaters);

		int result = Integer.MIN_VALUE;

		for (int house : houses) {
			int index = Arrays.binarySearch(heaters, house);

			if (index < 0)
				index = -(index + 1);

			int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
			int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

			result = Math.max(result, Math.min(dist1, dist2));
		}

		return result;
	}

	public int anotherSolution(int houses[], int heaters[]) {
		TreeSet<Integer> tree = new TreeSet<>();

		for (int i : heaters)
			tree.add(i);

		int radius = Integer.MIN_VALUE;

		for (int h : houses) {
			Integer left = tree.floor(h);
			Integer right = tree.ceiling(h);

			int temp = Integer.MAX_VALUE;

			if (left != null)
				temp = Math.min(temp, h - left);

			if (right != null)
				temp = Math.min(temp, right - h);

			radius = Math.max(radius, temp);
		}

		return radius;
	}
}
