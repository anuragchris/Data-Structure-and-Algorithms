//Link For Problem : https://leetcode.com/problems/find-smallest-letter-greater-than-target/

package binarySearchProblems;

public class NextAlphabeticalElement {
	static char nextAlphabet(char arr[], char element) {
		int start = 0, end = arr.length - 1;
		int mid;
		char ans = '#';
		while (start <= end) {
			mid = start + (end - start) / 2;
			if ((mid == arr.length - 1) && (arr[mid] <= element))
				return arr[0];
			if (arr[mid] == element)
				start = mid + 1;
			else if (arr[mid] < element)
				start = mid + 1;
			else if (arr[mid] > element) {
				ans = arr[mid];
				end = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		char letters[] = { 'c', 'f', 'j' };
		char k = 'g';
		System.out.println(nextAlphabet(letters, k));
	}
}
