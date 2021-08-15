package sorting;

public class ShellSort {
    public void shellSort(int a[]) {
	int len = a.length;
	for (int h = len / 2; h > 0; h /= 2) {
	    for (int i = h; i < len - 1; i++) {
		int key = a[i];
		while (i > h && a[i - 1] > key) {
		    a[i] = a[i - h];
		    i -= h;
		}
		a[i] = key;
	    }
	}
    }
}
