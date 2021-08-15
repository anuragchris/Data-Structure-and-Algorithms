package searching;

import java.util.Arrays;

public class MaximnumFrequency {
    public int maxFrequency(int a[]) {
	Arrays.sort(a);
	int max_count = 0;
	int current_count = 0;
	int res = a[0];
	for (int i = 1; i < a.length; i++) {
	    if (a[i] == a[i - 1]) {
		current_count += 1;
	    } else {
		if (current_count > max_count) {
		    max_count = current_count;
		    res = a[i - 1];
		}
		current_count = 1;
	    }

	}
	if (current_count > max_count) {
	    max_count = current_count;
	    res = a[a.length - 1];
	}
	if (current_count == max_count) {
	    return -1;
	}
	return res;
    }
}
