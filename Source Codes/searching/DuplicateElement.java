package searching;

import java.util.Arrays;

public class DuplicateElement {
    public int duplicatesUsingSort(int a[]) {
	int temp = 0;
	Arrays.sort(a);
	for (int i = 0; i < a.length - 1; i++) {
	    if (a[i] == a[i + 1]) {
		temp += 1;
	    }
	}
	if (temp == 0) {
	    temp = -1;
	}
	return temp;
    }

}
