package sorting;

public class QuickSort {
	public void quickSort(int a[], int low, int high) {
		if (low < high) {
			int pi = partition(a, low, high);
			quickSort(a, low, pi - 1);
			quickSort(a, pi + 1, high);
		}
	}

	public int partition(int a[], int low, int high) {
		int pivot = a[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (a[j] < pivot) {
				i++;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		int temp = a[i + 1];
		a[i + 1] = a[high];
		a[high] = temp;
		return i + 1;
	}

	public void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
