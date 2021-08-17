package binarySearchProblems;

public class FloorInASortedArray {
	static int floor(int arr[], int element) {
		int start = 0, end = arr.length - 1;
		int mid;
		int ans = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == element)
				return arr[mid];
			if (arr[mid] < element) {
				ans = arr[mid];
				start = mid + 1;
			} else if (arr[mid] > element)
				end = mid - 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
		System.out.println(floor(arr, 7));
	}
}
