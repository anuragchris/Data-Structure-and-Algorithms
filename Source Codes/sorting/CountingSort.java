package sorting;

import java.util.Arrays;

public class CountingSort {

	public int[] countElements(int a[], int k) {
		int c[] = new int[k + 1];
		Arrays.fill(c, 0);

		for (int i = 0; i < a.length; i++) {
			int j = a[i];
			c[j] += 1;
		}

		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}

		return c;
	}

	public int[] sort(int a[], int k) {
		int c[] = countElements(a, k);
		int sorted[] = new int[a.length];

		for (int i = a.length - 1; i >= 0; i--) {
			int j = a[i];
			sorted[c[j] - 1] = j;
			c[j] -= 1;
		}

		return sorted;
	}
}
