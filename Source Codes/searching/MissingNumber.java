package searching;

public class MissingNumber {
    public int usingSum(int a[]) {
	int n = a.length;
	int arraySum = 0;
	int sum = n * (n + 1) / 2;
	for (int i = 0; i < n; i++) {
	    if (a[i] <= n) {
		arraySum += a[i];
	    }
	}
	if (sum - arraySum > 0) {
	    return (sum - arraySum);
	}
	if (sum - arraySum == 0) {
	    return 0;
	}
	return -1;
    }

    public int usingXOR(int a[]) {
	int X, Y, n;
	n = a.length;
	X = 0;
	Y = 0;
	for (int i = 0; i < n; i++) {
	    X = X ^ a[i];
	}
	for (int i = 1; i <= n + 1; i++) {
	    Y = Y ^ i;
	}
	return Y ^ X;
    }
}
