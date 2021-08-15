package searching;

import java.util.Arrays;

public class SumClosestToZero {
    public int usingSort(int a[], int n) {
	Arrays.sort(a);
	int sum = Integer.MAX_VALUE;
	int i = 0;
	int j = n - 1;
	int index1 = 0;
	int index2 = 0;
	if (n < 2) {
	    return -1;
	}
	while (i < j) {
	    int temp = a[i] + a[j];
	    if (Math.abs(temp) < sum) {
		sum = temp;
		index1 = i;
		index2 = j;
	    } else if (temp < 0) {
		i++;
	    } else {
		j--;
	    }
	}
	System.out.println("Elements Whose Sum is Closest to Zero are : " + a[index1] + " and " + a[index2]);
	return sum;
    }
}
