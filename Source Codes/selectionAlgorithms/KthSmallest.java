package selectionAlgorithms;

public class KthSmallest {
    public int kthSmmallest(int a[], int l, int r, int k) {
	if (k > 0 && k <= (r - l + 1)) {
	    int pos = randomPartition(a, l, r);
	    if (pos - l == k - 1) {
		return a[pos];
	    }
	    if (pos - l > k - 1) {
		return kthSmmallest(a, l, pos - 1, k);
	    }
	    return kthSmmallest(a, pos + 1, r, k - pos + l - 1);
	}
	return Integer.MAX_VALUE;
    }

    int randomPartition(int a[], int l, int r) {
	int n = r - l + 1;
	int pivot = (int) (Math.random() * (n));
	swap(a, l + pivot, r);
	return partition(a, l, r);
    }

    void swap(int a[], int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

    int partition(int a[], int l, int r) {
	int x = a[r];
	int i = l;
	for (int j = l; j < r; j++) {
	    if (a[j] <= x) {
		swap(a, i, j);
		i++;
	    }
	}
	swap(a, i, r);
	return i;
    }
}
