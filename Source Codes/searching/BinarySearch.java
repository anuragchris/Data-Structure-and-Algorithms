package searching;

public class BinarySearch {
    public int iterative(int a[], int element) {
	int left = 0;
	int right = a.length - 1;
	while (left <= right) {
	    int mid = (left + right) / 2;
	    if (a[mid] == element) {
		return mid + 1;
	    } else if (a[mid] < element) {
		left = mid + 1;
	    } else {
		right = mid - 1;
	    }
	}
	return -1;
    }

    public int recursive(int a[], int left, int right, int element) {
	int mid = (left + right) / 2;
	if (a[mid] == element) {
	    return mid + 1;
	}
	if (a[mid] < element) {
	    return recursive(a, mid + 1, right, element);
	}
	if (a[mid] > element) {
	    return recursive(a, left, mid - 1, element);
	}
	return -1;
    }
}
