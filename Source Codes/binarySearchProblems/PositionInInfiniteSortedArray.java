package binarySearchProblems;

public class PositionInInfiniteSortedArray {
	static int findPosition(int arr[], int element) {
		int start = 0, end = 1;
		while (arr[end] < element) {
			start = end;
			end *= 2;
		}
		return binarySearch(arr, start, end, element);
	}

	static int binarySearch(int arr[], int start, int end, int element) {
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == element)
				return mid;
			else if (arr[mid] < element)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		System.out.println(findPosition(arr, 10));
	}
}
