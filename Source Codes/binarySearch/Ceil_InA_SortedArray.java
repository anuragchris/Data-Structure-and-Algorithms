package binarySearch;

public class Ceil_InA_SortedArray {
	static int ceil(int arr[], int element) {
		int start = 0, end = arr.length - 1;
		int mid, ans = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == element)
				return arr[mid];
			if (arr[mid] < element)
				start = mid + 1;
			else {
				ans = arr[mid];
				end = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
		System.out.println(ceil(arr, 9));
	}
}
