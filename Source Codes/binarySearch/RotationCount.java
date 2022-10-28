package binarySearch;

public class RotationCount {
	static int count(int arr[]) {
		int start = 0, end = arr.length - 1;
		int mid = 0;
		int n = arr.length;
		while (start <= end) {
			mid = start + (end - start) / 2;
			int next = (mid + 1) % n;
			int prev = (mid + n - 1) % n;
			if (arr[mid] <= arr[next] && arr[mid] <= arr[prev])
				return mid;
			if (arr[start] <= arr[mid])
				start = mid + 1;
			else if (arr[mid] <= arr[end])
				end = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 15, 18, 2, 3, 6, 12 };
		System.out.println(count(arr));
	}
}
