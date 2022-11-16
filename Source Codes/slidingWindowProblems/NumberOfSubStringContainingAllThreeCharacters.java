//Link For Problem: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

package slidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubStringContainingAllThreeCharacters {

	public int numberOfSubstrings(String s) {
		Map<Character, Integer> map = new HashMap<>();

		int ans = 0, left = 0;

		for (int right = 0; right < s.length(); right++) {
			char current = s.charAt(right);

			map.put(current, map.getOrDefault(current, 0) + 1);

			while (map.size() >= 3) {
				char leftChar = s.charAt(left);

				map.put(leftChar, map.get(leftChar) - 1);

				if (map.get(leftChar) == 0)
					map.remove(leftChar);

				left += 1;
			}

			ans += left;
		}

		return ans;
	}

	public int anotherSolution(String s) {
		int arr[] = new int[3];

		int count = 0, n = s.length(), i = 0;

		for (int j = 0; j < n; j++) {
			arr[s.charAt(j) - 'a'] += 1;

			while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
				count += n - j;
				arr[s.charAt(i++) - 'a'] -= 1;
			}
		}

		return count;
	}
}
