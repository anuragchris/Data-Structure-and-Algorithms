package binarySearchProblems;

public class ReverseSortedArray {
	static int binarySearch(int arr[], int element) {
		int start = 0, end = arr.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == element)
				return mid;
			else if (arr[mid] > element)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(binarySearch(arr, 5));

	}
}
