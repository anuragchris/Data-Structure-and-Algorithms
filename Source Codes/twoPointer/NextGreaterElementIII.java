//Link For Problem: https://leetcode.com/problems/next-greater-element-iii/

package twoPointer;

public class NextGreaterElementIII {

	public int nextGreaterElement(int n) {
		char arr[] = Integer.toString(n).toCharArray();

		int i = arr.length - 2;

		while (i >= 0 && arr[i] >= arr[i + 1])
			i -= 1;

		if (i == -1)
			return -1;

		int k = arr.length - 1;

		while (arr[k] <= arr[i])
			k -= 1;

		swap(arr, i, k);

		StringBuilder ans = new StringBuilder();

		for (int j = 0; j <= i; j++)
			ans.append(arr[j]);

		for (int j = arr.length - 1; j > i; j--)
			ans.append(arr[j]);

		long ans_ = Long.parseLong(ans.toString());

		return ans_ > Integer.MAX_VALUE ? -1 : (int) ans_;
	}

	void swap(char arr[], int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
