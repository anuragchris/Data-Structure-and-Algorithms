//Link For Problem : https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

package strings;

import java.util.HashMap;

public class MakeTwoStringsAnagram {

	public int minSteps(String s, String t) {
		if (s.equalsIgnoreCase(t))
			return 0;

		HashMap<Character, Integer> a = new HashMap<Character, Integer>();
		HashMap<Character, Integer> b = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			a.put(s.charAt(i), a.getOrDefault(s.charAt(i), 0) + 1);
			b.put(t.charAt(i), b.getOrDefault(t.charAt(i), 0) + 1);
		}

		for (char c : a.keySet()) {
			if (b.containsKey(c)) {

				if (b.get(c) > a.get(c))
					b.put(c, b.get(c) - a.get(c));
				else
					b.remove(c);
			}
		}

		int count = 0;
		for (char c : b.keySet())
			count += b.get(c);

		return count;
	}

	public int anotherMapSolution(String s, String t) {
		HashMap<Character, Integer> a = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++)
			a.put(s.charAt(i), a.getOrDefault(s.charAt(i), 0) + 1);

		int count = 0;
		for (char ch : t.toCharArray()) {
			if (!a.containsKey(ch) || a.get(ch) == 0)
				count += 1;
			else
				a.put(ch, a.get(ch) - 1);
		}

		return count;
	}

	public int optimized(String s, String t) {
		if (s.equalsIgnoreCase(t))
			return 0;

		int a[] = new int[26];
		int b[] = new int[26];

		for (char ch : s.toCharArray())
			a[ch - 'a'] += 1;

		for (char ch : t.toCharArray())
			b[ch - 'a'] += 1;

		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (b[i] > a[i])
				count += b[i] - a[i];
		}

		return count;
	}

	public int anotherSolution(String s, String t) {
		int arr[] = new int[26];

		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a'] += 1;
			arr[t.charAt(i) - 'a'] -= 1;
		}

		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (arr[i] > 0)
				count += arr[i];
		}

		return count;
	}

	public static void main(String[] args) {
		String s = "leetcode";
		String t = "practice";

		MakeTwoStringsAnagram mt = new MakeTwoStringsAnagram();
		System.out.println(mt.minSteps(s, t));
		System.out.println(mt.optimized(s, t));
	}
}
