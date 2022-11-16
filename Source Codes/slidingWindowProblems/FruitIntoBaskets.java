//Link For Problem: https://leetcode.com/problems/fruit-into-baskets/description/

package slidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

	static public int totalFruit(int[] fruits) {
		if (fruits.length < 2)
			return 1;

		Map<Integer, Integer> map = new HashMap<>();
		int left = 0, max = 0;

		for (int right = 0; right < fruits.length; right++) {
			map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

			while (map.size() > 2) {
				map.put(fruits[left], map.get(fruits[left]) - 1);

				if (map.get(fruits[left]) == 0)
					map.remove(fruits[left]);

				left += 1;
			}

			max = Math.max(max, right - left + 1);
		}

		return max;
	}

	public static void main(String[] args) {
		int fruits[] = { 0, 1, 6, 6, 4, 4, 6 };

		System.out.println(totalFruit(fruits));
	}
}
