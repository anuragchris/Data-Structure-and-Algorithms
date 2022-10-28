package binarySearch;

public class First1inBinaryInfiniteSortedArray {
	static int findPosition(int arr[]) {
		int start = 0, end = 1;
		while (arr[end] < 1) {
			start = end;
			end *= 2;
		}
		return firstOccurence(arr, start, end);
	}

	static int firstOccurence(int arr[], int start, int end) {
		int mid;
		int ans = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0))
				return mid;
			if (arr[mid] == 1) {
				ans = mid;
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 0, 1, 1, 1, 1 };
		System.out.println(findPosition(arr));
	}
}
