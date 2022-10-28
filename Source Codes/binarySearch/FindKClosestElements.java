//Link For Problem: https://leetcode.com/problems/find-k-closest-elements/

package binarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int left = 0, right = arr.length - k;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (x - arr[mid] > arr[mid + k] - x)
				left = mid + 1;
			else
				right = mid;
		}

		List<Integer> list = new ArrayList<>();

		for (int i = left; i < left + k; i++)
			list.add(arr[i]);

		return list;

		//		return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
	}
}
