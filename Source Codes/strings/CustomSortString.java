//Link For Problem: https://leetcode.com/problems/custom-sort-string/

package strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class CustomSortString {

	private class CustomComparator implements Comparator<Character> {
		private HashMap<Character, Integer> hm;

		public CustomComparator(String order) {
			hm = new HashMap<Character, Integer>();

			for (int i = 0; i < order.length(); i++)
				hm.put(order.charAt(i), i);
		}

		@Override
		public int compare(Character a, Character b) {
			return hm.getOrDefault(a, 27) - hm.getOrDefault(b, 27);
		}
	}

	public String customSortString(String order, String s) {
		Character arr[] = new Character[s.length()];

		for (int i = 0; i < s.length(); i++)
			arr[i] = s.charAt(i);

		Arrays.sort(arr, new CustomComparator(order));

		StringBuilder sb = new StringBuilder();
		for (Character c : arr)
			sb.append(c);

		return sb.toString();
	}

	public String optimized(String order, String s) {
		int freq[] = new int[26];

		for (char c : s.toCharArray())
			freq[c - 'a'] += 1;

		StringBuilder ans = new StringBuilder();

		for (char c : order.toCharArray()) {

			for (int i = 0; i < freq[c - 'a']; i++) {
				ans.append(c);
			}

			freq[c - 'a'] = 0;
		}

		for (char c = 'a'; c <= 'z'; c++) {

			for (int i = 0; i < freq[c - 'a']; i++) {
				ans.append(c);
			}
		}

		return ans.toString();
	}
}
