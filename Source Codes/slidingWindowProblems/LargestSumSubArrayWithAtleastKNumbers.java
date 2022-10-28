//Link For Problem: https://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/

package slidingWindowProblems;

public class LargestSumSubArrayWithAtleastKNumbers {

	static int maxSumWithK(int arr[], int n, int k) {
		int maxSum[] = new int[n];
		maxSum[0] = arr[0];

		int currentMax = arr[0];
		for (int i = 1; i < n; i++) {
			currentMax = Math.max(currentMax, currentMax + arr[i]);
			maxSum[i] = currentMax;
		}

		int sum = 0;

		for (int i = 0; i < k; i++)
			sum += arr[i];

		int result = sum;

		for (int i = k; i < n; i++) {
			sum = sum + arr[i] - arr[i - k];

			result = Math.max(result, sum);

			result = Math.max(result, sum + maxSum[i - k]);
		}

		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, -10, -3 };
		int k = 4;

		System.out.println(maxSumWithK(arr, arr.length, k));
	}
}
