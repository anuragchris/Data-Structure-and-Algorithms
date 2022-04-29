//Link For Problem: https://leetcode.com/problems/largest-odd-number-in-string/

package strings;

public class LargestOddNumberInString {

	public String largestOddNumber(String num) {
		for (int i = num.length() - 1; i >= 0; i--) {
			char ch = num.charAt(i);

			if (ch == '1' || ch == '3' || ch == '5' || ch == '7' || ch == '9') {

				if (i == num.length() - 1)
					return num;
				else
					return num.substring(0, i + 1);
			}
		}

		return "";
	}
}
