package binarySearchProblems;

public class FirstAndLastOccurence {
	static int firstOccurence(int arr[], int element) {
		int start = 0, end = arr.length - 1;
		int mid = 0;
		int ans = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == element) {
				ans = mid;
				end = mid - 1;
			} else if (arr[mid] < element)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return ans;
	}

	static int lastOccurence(int arr[], int element) {
		int start = 0, end = arr.length - 1;
		int mid = 0, ans = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == element) {
				ans = mid;
				start = mid + 1;
			} else if (arr[mid] < element)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 10, 10, 10, 18, 20 };
		System.out.println(firstOccurence(arr, 10));
		System.out.println(lastOccurence(arr, 10));
	}
}
