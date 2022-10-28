package binarySearch;

public class AllocateMinimumPages {
	static int allocateMinPage(int book[], int student) {
		if (book.length < student)
			return -1;
		int start = Integer.MIN_VALUE, end = 0;
		for (int i = 0; i < book.length; i++) {
			start = Math.max(start, book[i]);
			end += book[i];
		}
		int ans = -1, mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (isValid(book, book.length, student, mid)) {
				ans = mid;
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return ans;
	}

	static boolean isValid(int arr[], int n, int k, int max) {
		int student = 1;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum > max) {
				student += 1;
				sum = arr[i];
			}
			if (student > k)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int arr[] = { 12, 34, 67, 90 };
		int m = 2; //No. of students
		System.out.println(allocateMinPage(arr, m));
	}
}
