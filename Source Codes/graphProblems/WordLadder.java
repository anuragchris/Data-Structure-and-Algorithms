// Link For Problem : https://leetcode.com/problems/word-ladder/

package graphProblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord) || beginWord.length() != endWord.length()) {
			return 0;
		}
		HashMap<String, Boolean> hm = new HashMap<String, Boolean>();
		for (int i = 0; i < wordList.size(); i++) {
			hm.put(wordList.get(i), false);
		}
		Queue<String> q = new LinkedList<String>();
		int length = 1;
		q.add(beginWord);
		hm.put(beginWord, true);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String temp = q.poll();
				if (temp.equals(endWord)) {
					return length;
				}
				wordMatch(temp, hm, q);
			}
			length++;
		}
		return 0;
	}

	static void wordMatch(String temp, HashMap<String, Boolean> hm, Queue<String> q) {
		for (int i = 0; i < temp.length(); i++) {
			char word[] = temp.toCharArray();
			for (int j = 0; j < 26; j++) {
				char c = (char) ('a' + j);
				word[i] = c;
				String s = String.valueOf(word);
				if (hm.containsKey(s) && hm.get(s) == false) {
					q.add(s);
					hm.put(s, true);
				}
			}
		}
	}
}
