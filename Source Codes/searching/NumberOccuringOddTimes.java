package searching;

public class NumberOccuringOddTimes {
    public int usingXOR(int a[]) {
	int X, n = a.length;
	X = 0;
	for (int i = 0; i < n; i++) {
	    X = X ^ a[i];
	}
	return X;
    }
}
