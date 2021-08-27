package slidingWindowProblems;

import java.util.HashMap;

public class CountOccurenceOfAnagrams {
	static int countAnagrams(String x, String y) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < y.length(); i++) {
			if (!hm.containsKey(y.charAt(i)))
				hm.put(y.charAt(i), 1);
			else
				hm.put(y.charAt(i), hm.get(y.charAt(i)) + 1);
		}
		int k = y.length(), count = hm.size();
		int i = 0, j = 0, ans = 0;
		while (j < x.length()) {
			if (hm.containsKey(x.charAt(j))) {
				hm.put(x.charAt(j), hm.get(x.charAt(j)) - 1);
				if (hm.get(x.charAt(j)) == 0)
					count -= 1;
			}
			if (j - i + 1 < k)
				j++;
			else if ((j - i + 1) == k) {
				if (count == 0)
					ans += 1;
				if (hm.containsKey(x.charAt(i))) {
					hm.put(x.charAt(i), hm.get(x.charAt(i)) + 1);
					if (hm.get(x.charAt(i)) == 1)
						count += 1;
				}
				i += 1;
				j += 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String text = "forxxorfxdofr";
		String word = "for";
		System.out.println(countAnagrams(text, word));
	}
}
