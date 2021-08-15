package sorting;

import java.util.Arrays;

public class RadixSort {
    public int getMax(int a[], int l) {
	int max = a[0];
	for (int i = 1; i < l; i++) {
	    if (a[i] > max) {
		max = a[i];
	    }
	}
	return max;
    }

    public void radixSort(int a[], int l) {
	int max = getMax(a, l);
	for (int place = 1; (max / place) > 0; place *= 10) {
	    countingSort(a, l, place, max);
	}
    }

    public void countingSort(int a[], int length, int place, int max) {
	int output[] = new int[length];
	int count[] = new int[10];
	Arrays.fill(count, 0);
	for (int i = 0; i < length; i++) {
	    count[(a[i] / place) % 10]++;
	}
	for (int i = 1; i < count.length; i++) {
	    count[i] += count[i - 1];
	}
	for (int i = length - 1; i >= 0; i--) {
	    output[count[(a[i] / place) % 10] - 1] = a[i];
	    count[(a[i] / place) % 10]--;
	}
	for (int i = 0; i < length; i++) {
	    a[i] = output[i];
	}
    }
}
