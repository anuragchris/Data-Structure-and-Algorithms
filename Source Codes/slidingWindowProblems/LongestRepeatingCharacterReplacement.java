//Link For Problem: https://leetcode.com/problems/longest-repeating-character-replacement/

package slidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();

		int ans = 0, left = 0, maxFreq = 0;

		for (int right = 0; right < s.length(); right++) {
			char current = s.charAt(right);

			map.put(current, map.getOrDefault(current, 0) + 1);

			maxFreq = Math.max(maxFreq, map.get(current));

			if (right - left + 1 - maxFreq > k) {
				current = s.charAt(left);

				map.put(current, map.get(current) - 1);
				left += 1;
			}

			ans = Math.max(ans, right - left + 1);
		}

		return ans;
	}
}
