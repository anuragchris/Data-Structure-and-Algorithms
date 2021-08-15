package searching;

import java.util.Arrays;

public class SumEqualToK {
    public void usingSort(int a[], int k) {
	Arrays.sort(a);
	for (int i = 0, j = a.length - 1; i < j;) {
	    int temp = a[i] + a[j];
	    if (temp == k) {
		System.out.println("Found Elements : " + a[i] + " and " + a[j]);
	    }
	    if (temp < k) {
		i += 1;
	    } else if (temp > k) {
		j -= 1;
	    } else {
		i += 1;
		j -= 1;
	    }
	}
    }
}
