package slidingWindowProblems;

import java.util.HashMap;

public class LongestSubArrayOfSumK {
	static int longestSubArray(int arr[], int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0, maxLen = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (sum == k)
				maxLen = i + 1;

			if (!map.containsKey(sum))
				map.put(sum, i);

			if (map.containsKey(sum - k))
				maxLen = Math.max(maxLen, i - map.get(sum - k));
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 7, 1, 9 };
		int k = 15;
		System.out.println(longestSubArray(arr, k));
	}
}
