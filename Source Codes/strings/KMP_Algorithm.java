package strings;

public class KMP_Algorithm {

	static boolean kmp(String text, String pattern) {
		char txt[] = text.toCharArray();
		char pat[] = pattern.toCharArray();

		int lps[] = computeLPS(pat);
		int i = 0, j = 0;

		while (i < txt.length && j < pat.length) {
			if (txt[i] == pat[j]) {
				i += 1;
				j += 1;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i += 1;
				}
			}
		}

		if (j == pat.length)
			return true;

		return false;
	}

	private static int[] computeLPS(char pattern[]) {
		int lps[] = new int[pattern.length];
		int index = 0;

		for (int i = 1; i < lps.length;) {

			if (pattern[i] == pattern[index]) {
				lps[i] = index + 1;
				index += 1;
				i += 1;
			}

			else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = 0;
					i += 1;
				}
			}
		}

		return lps;
	}

	public static void main(String[] args) {
		String txt = "abcxabcdabcdabcy";
		String pat = "abcdabcy";
		System.out.println(kmp(txt, pat));
	}
}
