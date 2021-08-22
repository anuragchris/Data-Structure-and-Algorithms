package binarySearchProblems;

public class MaxElementInBitonicArray {
	static int maxElement(int arr[]) {
		int start = 0, end = arr.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
				return arr[mid];
			else if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1])
				start = mid + 1;
			else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid - 1])
				end = mid - 1;
		}
		return arr[arr.length - 1];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 8, 3, 2 };
		System.out.println(maxElement(arr));
	}
}
