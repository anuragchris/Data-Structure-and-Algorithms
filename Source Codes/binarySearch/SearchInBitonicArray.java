package binarySearch;

public class SearchInBitonicArray {
	static int ascendingBinarySearch(int arr[], int start, int end, int element) {
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == element)
				return mid;
			if (arr[mid] > element)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	static int descendingBinarySearch(int arr[], int start, int end, int element) {
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == element)
				return mid;
			if (arr[mid] < element)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	static int findPeak(int arr[]) {
		int start = 0, end = arr.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
				return mid;
			else if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1])
				start = mid + 1;
			else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid - 1])
				end = mid - 1;
		}
		return arr.length - 1;
	}

	static int searchElement(int arr[], int element, int peak) {
		if (element > peak)
			return -1;
		if (element == peak)
			return peak;
		int ans = ascendingBinarySearch(arr, 0, peak - 1, element);
		if (ans != -1)
			return ans;
		return descendingBinarySearch(arr, peak + 1, arr.length - 1, element);
	}

	static int searchBitonic(int arr[], int element) {
		int peak = findPeak(arr);
		int ans = searchElement(arr, element, peak);
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { -8, 1, 2, 3, 4, 5, -2, -3 };
		System.out.println(searchBitonic(arr, -3));
	}
}
