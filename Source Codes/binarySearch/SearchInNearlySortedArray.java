package binarySearch;

public class SearchInNearlySortedArray {
	static int search(int arr[], int element) {
		int start = 0, end = arr.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == element)
				return mid;
			if (arr[mid - 1] >= start && arr[mid - 1] == element)
				return mid - 1;
			if (arr[mid + 1] <= end && arr[mid + 1] == element)
				return mid + 1;
			if (arr[mid] > element)
				end = mid - 2;
			else
				start = mid + 2;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 2, 10, 4, 40 };
		System.out.println(search(arr, 4));
	}
}
