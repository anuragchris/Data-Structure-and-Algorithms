//Link For Problem: https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

package strings;

import java.util.Arrays;
import java.util.HashMap;

public class MaxOccurenceOfSubstring {

	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		int max = 0;

		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for (int i = 0; i <= s.length() - minSize; i++) {
			String current = s.substring(i, i + minSize);

			int unique = 1;
			if (!hm.containsKey(current) && maxLetters < minSize) {
				char arr[] = current.toCharArray();
				Arrays.sort(arr);

				for (int j = 1; j < arr.length; j++) {
					if (arr[j] != arr[j - 1])
						unique += 1;
				}

				if (unique > maxLetters)
					continue;

				hm.put(current, hm.getOrDefault(current, 0) + 1);
			}

			for (int o : hm.values())
				max = Math.max(max, o);
		}

		return max;
	}
}
