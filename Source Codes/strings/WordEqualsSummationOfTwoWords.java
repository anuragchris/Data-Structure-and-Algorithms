//Link For Problem: https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/

package strings;

public class WordEqualsSummationOfTwoWords {

	public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
		StringBuilder first = new StringBuilder();
		StringBuilder second = new StringBuilder();
		StringBuilder target = new StringBuilder();

		for (char c : firstWord.toCharArray())
			first.append(c - 'a');

		for (char c : secondWord.toCharArray())
			second.append(c - 'a');

		for (char c : targetWord.toCharArray())
			target.append(c - 'a');

		int sum = Integer.parseInt(first.toString()) + Integer.parseInt(second.toString());
		int req = Integer.parseInt(target.toString());

		return sum == req;
	}

	public boolean anotherSolution(String firstWord, String secondWord, String targetWord) {
		int first = 0, second = 0, target = 0;

		for (int i = 0; i < firstWord.length(); i++)
			first = (10 * first) + (firstWord.charAt(i) - 'a');

		for (int i = 0; i < secondWord.length(); i++)
			second = (10 * second) + (secondWord.charAt(i) - 'a');

		for (int i = 0; i < targetWord.length(); i++)
			target = (10 * target) + (targetWord.charAt(i) - 'a');

		return (first + second) == target;
	}
}
