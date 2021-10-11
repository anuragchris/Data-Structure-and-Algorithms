package stringAlgorithms;

public class KMP_Algorithm {
	static void KMPSearch(String pat, String txt) {
		int m = pat.length(), n = txt.length();
		int lps[] = new int[m];
		int j = 0;
		computeLPSArray(pat, m, lps);
		int i = 0;
		while (i < n) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j += 1;
				i += 1;
			}
			if (j == m) {
				System.out.println("Found pattern " + "at index " + (i - j));
				j = lps[j - 1];
			} else if (i < n && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i += 1;
			}
		}
	}

	static void computeLPSArray(String pat, int m, int lps[]) {
		int len = 0, i = 1;
		lps[0] = 0;
		while (i < m) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len += 1;
				lps[i] = len;
				i += 1;
			} else {
				if (len != 0)
					len = lps[len - 1];
				else {
					lps[i] = len;
					i += 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		KMPSearch(pat, txt);
	}
}
