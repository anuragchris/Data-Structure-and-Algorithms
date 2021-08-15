package searching;

public class InterpolationSearch {
    public int interpolationSearch(int a[], int element) {
	int low = 0;
	int high = a.length - 1;
	while (element >= a[low] && element <= a[high] && low <= high) {
	    int probe = low + (high - low) * (element - a[low]) / (a[high] - a[low]);
	    if (a[probe] == element) {
		return probe + 1;
	    }
	    if (a[probe] < element) {
		high = probe - 1;
	    }
	    if (a[probe] > element) {
		low = probe + 1;
	    }
	    if (high == low) {
		if (a[low] == element) {
		    return low + 1;
		} else {
		    return -1;
		}
	    }
	}
	return -1;
    }
}
