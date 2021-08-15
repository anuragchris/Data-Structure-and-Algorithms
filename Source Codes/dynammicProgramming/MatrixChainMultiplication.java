package dynammicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatrixChainMultiplication {
    static int minCostRecursive(int arr[]) {
	return solve(arr, 1, arr.length - 1);
    }

    static int solve(int arr[], int i, int j) {
	if (i >= j) {
	    return 0;
	}
	int min = Integer.MAX_VALUE;
	for (int k = i; k <= j - 1; k++) {
	    int temp = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
	    if (temp < min) {
		min = temp;
	    }
	}
	return min;
    }

    static int minCostUsingMemoization(int arr[]) {
	int t[][] = new int[arr.length][arr.length];
	for (int[] row : t) {
	    Arrays.fill(row, -1);
	}
	return memoization(arr, 1, arr.length - 1, t);
    }

    static int memoization(int arr[], int i, int j, int t[][]) {
	if (i >= j) {
	    return 0;
	}
	if (t[i][j] != -1) {
	    return t[i][j];
	}
	int min = Integer.MAX_VALUE;
	for (int k = i; k <= j - 1; k++) {
	    int temp = memoization(arr, i, k, t) + memoization(arr, k + 1, j, t) + (arr[i - 1] * arr[k] * arr[j]);
	    if (temp < min) {
		min = temp;
	    }
	}
	return t[i][j] = min;
    }

    static int palindromePartitioningUsingRecursion(String s) {
	return partitionUsingRecursion(s, 0, s.length() - 1);
    }

    static int partitionUsingRecursion(String s, int i, int j) {
	if (i >= j) {
	    return 0;
	}
	if (isPalindrome(s, i, j)) {
	    return 0;
	}
	int ans = Integer.MAX_VALUE;
	int temp;
	for (int k = i; k < j; k++) {
	    temp = partitionUsingRecursion(s, i, k) + partitionUsingRecursion(s, k + 1, j) + 1;
	    ans = Math.min(ans, temp);
	}
	return ans;
    }

    static boolean isPalindrome(String s, int i, int j) {
	while (i < j) {
	    if (s.charAt(i) != s.charAt(j)) {
		return false;
	    } else {
		i++;
		j--;
	    }
	}
	return true;
    }

    static int palindromePartioningUsingMemoization(String s) {
	int t[][] = new int[s.length() + 1][s.length() + 1];
	for (int[] row : t) {
	    Arrays.fill(row, -1);
	}
	return memoization(s, 0, s.length() - 1, t);
    }

    static int memoization(String s, int i, int j, int t[][]) {
	if (i >= j || isPalindrome(s, i, j)) {
	    return 0;
	}
	if (t[i][j] != -1) {
	    return t[i][j];
	}
	int ans = Integer.MAX_VALUE;
	int temp;
	for (int k = i; k < j; k++) {
	    temp = memoization(s, i, k, t) + memoization(s, k + 1, j, t) + 1;
	    ans = Math.min(ans, temp);
	}
	return ans;
    }

    static boolean isScramble(String a, String b) {
	Map<String, Boolean> mp = new HashMap<String, Boolean>();
	return scrambledString(a, b, mp);
    }

    static boolean scrambledString(String a, String b, Map<String, Boolean> mp) {
	if ((a.length() != b.length())) {
	    return false;
	}
	if ((a.isEmpty() && b.isEmpty())) {
	    return true;
	}
	if (a.equals(b)) {
	    return true;
	}
	if (areAnagram(a.toCharArray(), b.toCharArray()) == false) {
	    return false;
	}
	if (a.length() <= 1) {
	    return false;
	}
	StringBuilder sb = new StringBuilder();
	sb.append(a);
	sb.append(" ");
	sb.append(b);
	if (mp.containsKey(sb.toString())) {
	    return mp.get(sb.toString());
	}
	int n = a.length();
	for (int i = 1; i < n; i++) {
	    if ((scrambledString(a.substring(0, i), b.substring(0, i), mp)
		    && (scrambledString(a.substring(i, n), b.substring(i, n), mp)))) {
		mp.put(sb.toString(), true);
		return true;
	    }
	    if ((scrambledString(a.substring(n - i, n), b.substring(0, i), mp)
		    && (scrambledString(a.substring(0, n - i), b.substring(i, n), mp)))) {
		mp.put(sb.toString(), true);
		return true;
	    }
	}
	mp.put(sb.toString(), false);
	return false;
    }

    static boolean areAnagram(char[] a, char[] b) {
	if (a.length != b.length) {
	    return false;
	}
	Arrays.sort(a);
	Arrays.sort(b);
	for (int i = 0; i < a.length; i++) {
	    if (a[i] != b[i]) {
		return false;
	    }
	}
	return true;
    }

    public static void main(String[] args) {
//	int arr[] = new int[] { 1, 2, 3, 4, 3 };
//	System.out.println(minCostRecursive(arr));
//	System.out.println(minCostUsingMemoization(arr));
//	String s = "eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj";
	// System.out.println(palindromePartitioningUsingRecursion(s));
//	System.out.println(palindromePartioningUsingMemoization(s));
	String a = "aaccd";
	String b = "acaad";
	System.out.println(isScramble(a, b));
    }
}
