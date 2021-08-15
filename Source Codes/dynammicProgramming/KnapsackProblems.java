package dynammicProgramming;

public class KnapsackProblems {
    static int maxProfitUsingRecursion(int wt[], int val[], int w, int n) {
	if (n == 0 || w == 0) {
	    return 0;
	}
	if (wt[n - 1] <= w) {
	    return Math.max(val[n - 1] + maxProfitUsingRecursion(wt, val, w - wt[n - 1], n - 1),
		    maxProfitUsingRecursion(wt, val, w, n - 1));
	} else {
	    return maxProfitUsingRecursion(wt, val, w, n - 1);
	}
    }

    static int maxProfitUsingMemoization(int wt[], int val[], int w, int n) {
	int t[][] = new int[n + 1][w + 1];
	for (int i = 0; i < n + 1; i++) {
	    for (int j = 0; j < w + 1; j++) {
		t[i][j] = -1;
	    }
	}
	return memoizaton(wt, val, w, n, t);
    }

    static int memoizaton(int wt[], int val[], int w, int n, int t[][]) {
	if (n == 0 || w == 0) {
	    return 0;
	}
	if (t[n][w] != -1) {
	    return t[n][w];
	}
	if (wt[n - 1] <= w) {
	    return t[n][w] = Math.max(val[n - 1] + memoizaton(wt, val, w - wt[n - 1], n - 1, t),
		    memoizaton(wt, val, w, n - 1, t));
	} else {
	    return t[n][w] = memoizaton(wt, val, w, n - 1, t);
	}
    }

    static int maxProfitUsingTopDownApproach(int wt[], int val[], int w, int n) {
	int t[][] = new int[n + 1][w + 1];
	for (int i = 0; i < n + 1; i++) {
	    for (int j = 0; j < w + 1; j++) {
		if (i == 0 || j == 0) {
		    t[i][j] = 0;
		} else if (wt[i - 1] <= j) {
		    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
		} else {
		    t[i][j] = t[i - 1][j];
		}
	    }
	}
	return t[n][w];
    }

    static boolean isSubsetSum(int set[], int n, int sum) {
	boolean t[][] = new boolean[n + 1][sum + 1];
	for (int i = 0; i <= n; i++) {
	    t[i][0] = true;
	}
	for (int i = 1; i <= sum; i++) {
	    t[0][i] = false;
	}
//	for (int i = 0; i < n + 1; i++) {
//	    for (int j = 0; j < sum + 1; j++) {
//		if (i == 0) {
//		    t[i][j] = false;
//		}
//		if (j == 0) {
//		    t[i][j] = true;
//		}
//	    }
//	}
	for (int i = 1; i < n + 1; i++) {
	    for (int j = 1; j < sum + 1; j++) {
		if (set[i - 1] <= j) {
		    t[i][j] = t[i - 1][j - set[i - 1]] || t[i - 1][j];
		} else {
		    t[i][j] = t[i - 1][j];
		}
	    }
	}
	return t[n][sum];
    }

    static boolean equalSumPartition(int a[], int n) {
	int sum = 0;
	for (int i = 0; i < n; i++) {
	    sum += a[i];
	}
	if (sum % 2 != 0) {
	    return false;
	}
	return isSubsetSumEqual(a, n, sum / 2);
    }

    static boolean isSubsetSumEqual(int a[], int n, int sum) {
	if (sum == 0) {
	    return true;
	}
	if (n == 0 && sum != 0) {
	    return false;
	}
	if (a[n - 1] > sum) {
	    return isSubsetSumEqual(a, n - 1, sum);
	}
	return isSubsetSumEqual(a, n - 1, sum) || isSubsetSumEqual(a, n - 1, sum - a[n - 1]);
    }

    static int countOfASubsetWithGivenSum(int a[], int sum, int n) {
	int t[][] = new int[n + 1][sum + 1];
	for (int i = 0; i < n + 1; i++) {
	    t[i][0] = 1;
	}
	for (int i = 1; i < sum + 1; i++) {
	    t[0][i] = 0;
	}
	for (int i = 1; i < n + 1; i++) {
	    for (int j = 1; j < sum + 1; j++) {
		if (a[i - 1] <= j) {
		    t[i][j] = t[i - 1][j] + t[i - 1][j - a[i - 1]];
		} else {
		    t[i][j] = t[i - 1][j];
		}
	    }
	}
	return t[n][sum];
    }

    static int minSubsetSumDifference(int a[], int n) {
	int sum = 0;
	for (int i = 0; i < n; i++) {
	    sum += a[i];
	}
	boolean t[][] = new boolean[n + 1][sum + 1];
	for (int i = 0; i < n + 1; i++) {
	    t[i][0] = true;
	}
	for (int i = 1; i < sum + 1; i++) {
	    t[0][i] = false;
	}
	for (int i = 1; i < n + 1; i++) {
	    for (int j = 1; j < sum + 1; j++) {
		if (a[i - 1] <= j) {
		    t[i][j] = t[i - 1][j - a[i - 1]];
		} else {
		    t[i][j] = t[i - 1][j];
		}
	    }
	}
	int diff = Integer.MAX_VALUE;
	for (int j = sum / 2; j >= 0; j--) {
	    if (t[n][j] == true) {
		diff = sum - (2 * j);
		break;
	    }
	}
	return diff;
    }

    static int numberOfSubsetWithGivenDifference(int a[], int diff, int n) {
	int sum = 0;
	for (int i = 0; i < a.length; i++) {
	    sum += a[i];
	}
	if ((sum + diff) % 2 != 0) {
	    return 0;
	} else {
	    sum = (sum + diff) / 2;
	}
	return countOfASubsetWithGivenSum(a, sum, n);
    }

    static int targetSum(int a[], int sum, int n) {
	return numberOfSubsetWithGivenDifference(a, sum, n);
    }

    public static void main(String[] args) {
//	int val[] = new int[] { 60, 100, 120 };
//	int wt[] = new int[] { 10, 20, 30 };
//	int w = 50;
//	int n = val.length;
//	System.out.println(maxProfitUsingRecursion(wt, val, w, n));
//	System.out.println(maxProfitUsingMemoization(wt, val, w, n));
//	System.out.println(maxProfitUsingTopDownApproach(wt, val, w, n));

//	int set[] = { 3, 34, 4, 12, 5, 2 };
//	int sum = 1;
//	int n = set.length;
//	System.out.println(isSubsetSum(set, n, sum));
//	int arr[] = { 1, 5, 11, 5 };
//	int n = arr.length;
//	System.out.println(equalSumPartition(arr, n));
//	int a[] = { 3, 3, 3, 3 };
//	int sum = 6;
//	int n = a.length;
//	System.out.println(countOfASubsetWithGivenSum(a, sum, n));

//	int arr[] = { 1, 2, 4 };
//	int n = arr.length;
//	System.out.println(minSubsetSumDifference(arr, n));
//	int a[] = { 1, 1, 2, 3 };
//	int diff = 1;
//	int n = a.length;
//	System.out.println(numberOfSubsetWithGivenDifference(a, diff, n));
	int a[] = { 1, 1, 1, 1, 1 };
	int sum = 3;
	int n = a.length;
	System.out.println(targetSum(a, sum, n));
    }
}
