package binarySearch;

public class MinimumDifferenceElement {
	static int findDifference(int arr[], int element) {
		int start = 0, end = arr.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == element)
				return 0;
			else if (arr[mid] < element)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return Math.min(Math.abs((arr[end] - element)), Math.abs((arr[start] - element)));
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8, 10, 15 };
		System.out.println(findDifference(arr, 12));
	}
}
