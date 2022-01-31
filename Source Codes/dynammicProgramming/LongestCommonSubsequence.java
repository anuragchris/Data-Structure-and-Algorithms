package dynammicProgramming;

public class LongestCommonSubsequence {
	static int LCS(String x, String y, int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		}
		if (x.charAt(n - 1) == y.charAt(m - 1)) {
			return 1 + LCS(x, y, n - 1, m - 1);
		} else {
			return Math.max(LCS(x, y, n, m - 1), LCS(x, y, n - 1, m));
		}
	}

	static int LCSUsingMemoization(String x, String y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				t[i][j] = -1;
			}
		}
		return memoization(x, y, m, n, t);
	}

	static int memoization(String x, String y, int m, int n, int t[][]) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (t[m][n] != -1) {
			return t[m][n];
		}
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return t[m][n] = 1 + memoization(x, y, m - 1, n - 1, t);
		} else {
			return t[m][n] = Math.max(memoization(x, y, m, n - 1, t), memoization(x, y, m - 1, n, t));
		}
	}

	static int LCSUsingTopDownApproach(String x, String y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		return t[m][n];
	}

	static int longestCommonSubString(String x, String y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		int result = 0;
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					t[i][j] = t[i - 1][j - 1] + 1;
					result = Math.max(result, t[i][j]);
				} else {
					t[i][j] = 0;
				}
			}
		}
		return result;
	}

	//    public int findLength(int[] nums1, int[] nums2) {
	//	int t[][] = new int[nums1.length + 1][nums2.length + 1];
	//	int result = 0;
	//	for (int i = 0; i < nums1.length + 1; i++) {
	//	    for (int j = 0; j < nums2.length + 1; j++) {
	//		if (i == 0 || j == 0) {
	//		    t[i][j] = 0;
	//		} else if (nums1[i - 1] == nums2[j - 1]) {
	//		    t[i][j] = t[i - 1][j - 1] + 1;
	//		    result = Math.max(result, t[i][j]);
	//		} else {
	//		    t[i][j] = 0;
	//		}
	//	    }
	//	}
	//	return result;
	//    }
	static String printLCS(String x, String y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		String result = "";
		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				result += x.toString().charAt(i - 1);
				i--;
				j--;
			} else {
				if (t[i][j - 1] > t[i - 1][j]) {
					j--;
				} else {
					i--;
				}
			}
		}
		StringBuilder sbr = new StringBuilder(result);
		return sbr.reverse().toString();
	}

	static int shortestCommonSuperSequence(String x, String y, int m, int n) {
		return m + n - LCSUsingTopDownApproach(x, y, m, n);
	}

	static String printSCS(String x, String y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		int i = m;
		int j = n;
		StringBuilder res = new StringBuilder(" ");
		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				res.append(x.charAt(i - 1));
				i--;
				j--;
			} else {
				if (t[i][j - 1] > t[i - 1][j]) {
					res.append(y.charAt(j - 1));
					j--;
				} else {
					res.append(x.charAt(i - 1));
					i--;
				}
			}
		}
		while (i > 0) {
			res.append(x.charAt(i - 1));
			i--;
		}
		while (j > 0) {
			res.append(y.charAt(j - 1));
			j--;
		}
		String ans = res.reverse().toString();
		return ans;
	}

	//Link For the Problem : https://leetcode.com/problems/uncrossed-lines/
	static int maxUncrossedLines(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;
		int dp[][] = new int[len1 + 1][len2 + 1];
		for (int i = 1; i <= len1; ++i) {
			for (int j = 1; j <= len2; ++j) {
				if (nums1[i - 1] == nums2[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[len1][len2];
	}

	static void minInsertionAndDeletionToConverString(String x, String y, int m, int n) {
		int deletion = m - LCSUsingTopDownApproach(x, y, m, n);
		int insertion = n - LCSUsingTopDownApproach(x, y, m, n);
		System.out.println(deletion + " " + insertion);
	}

	static int longestPalindromicSubsequence(String x, int m) {
		StringBuilder y = new StringBuilder(x);
		String rev = y.reverse().toString();
		return LCSUsingTopDownApproach(x, rev, m, m);
	}

	static int minimunDeletionToMakePalindrome(String x, int m) {
		StringBuilder y = new StringBuilder(x);
		return m - LCSUsingTopDownApproach(x, y.reverse().toString(), m, m);
	}

	static int longestRepeatingSubsequence(String x, int m) {
		int t[][] = new int[m + 1][m + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if ((x.charAt(i - 1) == x.charAt(j - 1)) && (i != j)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		return t[m][m];
	}

	static String printLRS(String x, int m) {
		int t[][] = new int[m + 1][m + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if ((x.charAt(i - 1) == x.charAt(j - 1)) && (i != j)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		int i = m;
		int j = m;
		StringBuilder res = new StringBuilder("");
		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == x.charAt(j - 1) && (i != j)) {
				res.append(x.charAt(i - 1));
				i--;
				j--;
			} else if (t[i - 1][j] > t[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		String ans = res.reverse().toString();
		return ans;
	}

	static boolean sequencePatternMatching(String x, String y, int m, int n) {
		int lcs = LCSUsingTopDownApproach(x, y, m, n);
		if (lcs == x.length()) {
			return true;
		} else {
			return false;
		}
	}

	static boolean sequencePatternMatchingByTwoPointers(String x, String y, int m, int n) {
		if (x.isEmpty()) {
			return true;
		}
		int i = 0;
		int j;
		for (j = 0; j < y.length(); j++) {
			if ((i < x.length()) && (x.charAt(i) == y.charAt(j))) {
				i++;
			}
		}
		if (i == x.length()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		//	String x = "AGGTAB";
		//	String y = "GXTXAYB";
		//	System.out.println(LCS(x, y, x.length(), y.length()));
		//	System.out.println(LCSUsingMemoization(x, y, x.length(), y.length()));
		//	System.out.println(LCSUsingTopDownApproach(x, y, x.length(), y.length()));
		//	String x = "abcbc";
		//	String y = "cbcef";
		//	System.out.println(longestCommonSubString(x, y, x.length(), y.length()));
		//	String x = "AGGTAB";
		//	String y = "GXTXAYB";
		//	System.out.println(printLCS(x, y, x.length(), y.length()));
		//	System.out.println(shortestCommonSuperSequence(x, y, x.length(), y.length()));
		//	String x = "abac";
		//	String y = "cab";
		//	System.out.println(printSCS(x, y, x.length(), y.length()));
		//	String x = "heap";
		//	String y = "pea";
		//	minInsertionAndDeletionToConverString(x, y, x.length(), y.length());
		//	String x = "cbbd";
		//	int m = x.length();
		//	System.out.println(longestPalindromicSubsequence(x, m));
		//	String x = "geeksforgeeks";
		//	System.out.println(minimunDeletionToMakePalindrome(x, x.length()));
		String x = "b";
		String y = "abc";
		//	System.out.println(longestRepeatingSubsequence(x, x.length()));
		//	System.out.println(printLRS(x, x.length()));
		//	System.out.println(sequencePatternMatching(x, y, x.length(), y.length()));
		System.out.println(sequencePatternMatchingByTwoPointers(x, y, x.length(), y.length()));
	}
}
