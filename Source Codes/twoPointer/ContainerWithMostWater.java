//Link For Problem: https://leetcode.com/problems/container-with-most-water/

package twoPointer;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int max = 0, i = 0, j = height.length - 1;
		int temp = 0;

		while (i < j) {

			if (height[i] < height[j]) {
				temp = (j - i) * height[i];
				max = Math.max(temp, max);
				i += 1;
			} else {
				temp = (j - i) * height[j];
				max = Math.max(temp, max);
				j -= 1;
			}
		}

		return max;
	}
}
