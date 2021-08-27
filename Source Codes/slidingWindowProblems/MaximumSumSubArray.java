package slidingWindowProblems;

public class MaximumSumSubArray {
	static int maxSum(int arr[], int k) {
		int i = 0, j = 0;
		int sum = 0, max = Integer.MIN_VALUE;
		while (j < arr.length) {
			sum += arr[j];
			if (j - i + 1 < k)
				j++;
			else if (j - i + 1 == k) {
				max = Math.max(max, sum);
				sum -= arr[i];
				i++;
				j++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int k = 4;
		System.out.println(maxSum(arr, k));
	}
}
