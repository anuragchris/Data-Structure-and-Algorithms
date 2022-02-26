// Link For Problem : https://leetcode.com/problems/trapping-rain-water/

package stacks;

public class TrappingRainWater {
	static int trap(int[] height) {
		int maxLeft[] = new int[height.length];
		int maxRight[] = new int[height.length];

		maxLeft[0] = height[0];
		for (int i = 1; i < height.length; i++)
			maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);

		maxRight[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--)
			maxRight[i] = Math.max(maxRight[i + 1], height[i]);

		int water = 0;
		for (int i = 0; i < height.length; i++)
			water += Math.min(maxLeft[i], maxRight[i]) - height[i];

		return water;
	}

	static int trapUsingConstantSpace(int height[]) {
		int left = 0, right = height.length - 1;
		int maxLeft = 0, maxRight = 0;
		int ans = 0;

		while (left < right) {

			maxLeft = Math.max(maxLeft, height[left]);
			maxRight = Math.max(maxRight, height[right]);

			if (maxLeft < maxRight) {
				ans += maxLeft - height[left];
				left += 1;
			} else {
				ans += maxRight - height[right];
				right -= 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(height));
		System.out.println(trapUsingConstantSpace(height));
	}
}
